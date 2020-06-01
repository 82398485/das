package com.ppdai.das.strategy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ModShardLocator<CTX extends ConditionContext> extends AbstractCommonShardLocator<CTX> {
    private Integer mod;
    /**
     * DB shard 0 padding format, default 1.
     */
    protected String zeroPaddingFormat = "%01d";

    public ModShardLocator(Integer mod) {
        this.mod = mod;
    }

    public ModShardLocator(Integer mod, String zeroPaddingFormat) {
        this(mod);
        this.zeroPaddingFormat = zeroPaddingFormat;
    }

    public Set<String> locateByValue(Object value) {
        Set<String> shards = new HashSet<>();
        shards.add(mod(mod, value));
        return applySuffix(shards);
    }

    @Override
    public Set<String> locateForEqual(ConditionContext ctx) {
        return locateByValue(ctx.getValue());
    }

    public Set<String> locateForGreaterThan(CTX ctx) {
        return getAllShards(ctx);
    }

    public Set<String> locateForLessThan(CTX ctx) {
        return getAllShards(ctx);
    }

    @Override
    public Set<String> locateForIn(CTX context) {
        Set<String> allShards = getAllShards(context);
        Set<String> range = new TreeSet<>();
        for(Object value: context.getValues()) {
            range.addAll(locateShards(createConditionContext(context, OperatorEnum.EQUAL, value)));
            if(isAlreadyAllShards(allShards, range))
                break;
        }

        return range;
    }

    @Override
    public Set<String> locateForBetween(ConditionContext ctx) {
        long lowerValue = getLongValue(ctx.getValue());
        long upperValue = getLongValue(ctx.getSecondValue());
        
        Set<String> shards = new HashSet<>();
        // Illegal case for between
        if(lowerValue > upperValue)
            return shards;
        
        // Cross all shards case
        if(upperValue - lowerValue >= (mod -1))
            return ctx.getAllShards();
        
        //For same value
        if(upperValue == lowerValue) {
            int shard = Integer.parseInt(mod(mod, ctx.getValue()));
            shards.add(String.valueOf(shard));
            return applySuffix(shards);
        }

        int lowerShard = Integer.parseInt(mod(mod, ctx.getValue()));
        int upperShard = Integer.parseInt(mod(mod, ctx.getSecondValue()));
        
        if(lowerShard < upperShard) {
            while(lowerShard <= upperShard)
                shards.add(String.valueOf(lowerShard++));
        } else {
            while(lowerShard < mod)
                shards.add(String.valueOf(lowerShard++));
            
            int shard = 0;
            while(shard <= upperShard)
                shards.add(String.valueOf(shard++));
        }

        return applySuffix(shards);
    }

    private String mod(int mod, Object value) {
        Long id = getLongValue(value);
        return String.valueOf(id%mod);
    }

    private Long getLongValue(Object value) {
        if(value == null)
            throw new IllegalArgumentException("The shard column must not be null");
        
        if(value instanceof Long)
            return (Long)value;
        
        if(value instanceof Number)
            return ((Number)value).longValue();
        
        if(value instanceof String)
            return string2Long((String)value);
        
        throw new IllegalArgumentException(String.format("Shard value: %s can not be recoganized as int value", value.toString()));
    }

    protected Long string2Long(String s) {
        return new Long(s);
    }

    private Set<String> applySuffix(Set<String> original) {
        return original.stream()
                .map(s -> String.format(zeroPaddingFormat, Integer.parseInt(s)))
                .collect(Collectors.toSet());
    }
}
