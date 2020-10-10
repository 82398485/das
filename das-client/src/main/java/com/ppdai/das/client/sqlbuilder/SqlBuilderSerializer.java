package com.ppdai.das.client.sqlbuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.ppdai.das.client.BatchUpdateBuilder;
import com.ppdai.das.client.Segment;
import com.ppdai.das.client.SqlBuilder;
import com.ppdai.das.core.DasDiagnose;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class SqlBuilderSerializer implements Serializer {

    private SerializeFactory serializeFactory = SerializeFactory.getInstance();

    public final static SqlBuilderSerializer instance = new SqlBuilderSerializer();

    SqlBuilderSerializer(){
        serializeFactory.addAll(ExpressionSerializers.expressionSerializers());
        serializeFactory.addAll(TextSerializers.textSerializers());
        serializeFactory.add(new ColumnDefinitionSerializer());
        serializeFactory.add(new ColumnOrderSerializer());
        serializeFactory.add(new ColumnReferenceSerializer());
        serializeFactory.add(new TableDeclarationSerializer());
        serializeFactory.add(new TableDefinitionSerializer());
        serializeFactory.add(new TableSerializer());
        serializeFactory.add(new TemplateSerializer());
        serializeFactory.add(new PageSerializer());
        serializeFactory.add(new ParameterSerializer());
        serializeFactory.add(new ParameterDefinitionSerializer());
        serializeFactory.add(new BatchUpdateBuilderSerializer());
        serializeFactory.add(this);
    }

    public static String serializeSegment(SqlBuilder segment) {
        return instance.outGson.toJson(segment);
    }

    public static SqlBuilder deserializeSegment(String json) {
        return instance.outGson.fromJson(json, SqlBuilder.class);
    }

    public static String serializeBatchUpdateBuilder(BatchUpdateBuilder segment) {
        return instance.outGson.toJson(segment);
    }

    public static BatchUpdateBuilder deserializeBatchUpdateBuilder(String json) {
        return instance.outGson.fromJson(json, BatchUpdateBuilder.class);
    }

    public static String serializePrimitive(Object primitive) {
        return instance.primitiveGson.toJson(primitive);
    }

    public static <T> T deserializePrimitive(String json) {
        if(json == null) {
            return null;
        }
        return (T) instance.primitiveGson.fromJson(json, Supplier.class).get();
    }

    @Override
    public Segment deserialize(JsonObject jo) {
        SqlBuilder sqlBuilder = new SqlBuilder();
        JsonArray segs = jo.get("segments").getAsJsonArray();
        for(JsonElement seg: segs){
            sqlBuilder.getSegments().add(getSerializeFactory().deserialize(seg));
        }
        boolean selectCount = jo.getAsJsonPrimitive("selectCount").getAsBoolean();
        writeField(sqlBuilder, "selectCount", selectCount);
        return sqlBuilder;
    }

    @Override
    public JsonObject serialize(Segment obj) {
        SqlBuilder sqlBuilder = (SqlBuilder) obj;
        JsonObject root = new JsonObject();
        JsonArray segs = new JsonArray();
        sqlBuilder.getSegments().forEach(seg-> segs.add(getSerializeFactory().serialize(seg, seg.getClass())));

        root.add("segments", segs);
        root.addProperty("selectCount", sqlBuilder.isSelectCount());
        return addBuildType(root);
    }

    @Override
    public Class getBuildType() {
        return SqlBuilder.class;
    }

    final Gson outGson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Segment.class, (JsonSerializer<Segment>) (segment, typeOfSrc, context) -> serializeFactory.serialize(segment, typeOfSrc))
            .registerTypeHierarchyAdapter(Segment.class, (JsonDeserializer<Segment>) (json, typeOfT, context) -> serializeFactory.deserialize(json))
            .serializeNulls()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

    final Gson primitiveGson = new GsonBuilder()
            .registerTypeHierarchyAdapter(DasDiagnose.class, (JsonSerializer<DasDiagnose>) (str, typeOfSrc, context) -> {
                return JsonNull.INSTANCE;
            })
            .registerTypeHierarchyAdapter(String.class, (JsonSerializer<String>) (str, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", String.class.getSimpleName());
                root.add("value", new JsonPrimitive(str));
                return root;
            })
            .registerTypeHierarchyAdapter(Long.class, (JsonSerializer<Long>) (l, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", Long.class.getSimpleName());
                root.add("value", new JsonPrimitive(l));
                return root;
            })
            .registerTypeHierarchyAdapter(Integer.class, (JsonSerializer<Integer>) (l, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", Integer.class.getSimpleName());
                root.add("value", new JsonPrimitive(l));
                return root;
            })
            .registerTypeHierarchyAdapter(Boolean.class, (JsonSerializer<Boolean>) (l, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", Boolean.class.getSimpleName());
                root.add("value", new JsonPrimitive(l));
                return root;
            })
            .registerTypeHierarchyAdapter(Float.class, (JsonSerializer<Float>) (f, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", Float.class.getSimpleName());
                root.add("value", new JsonPrimitive(f));
                return root;
            })
            .registerTypeHierarchyAdapter(Double.class, (JsonSerializer<Double>) (f, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", Double.class.getSimpleName());
                root.add("value", new JsonPrimitive(f));
                return root;
            })
            .registerTypeHierarchyAdapter(BigInteger.class, (JsonSerializer<BigInteger>) (f, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", BigInteger.class.getSimpleName());
                root.add("value", new JsonPrimitive(f.longValue()));
                return root;
            })
            .registerTypeHierarchyAdapter(BigDecimal.class, (JsonSerializer<BigDecimal>) (f, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", BigDecimal.class.getSimpleName());
                root.add("value", new JsonPrimitive(f.doubleValue()));
                return root;
            })
            .registerTypeHierarchyAdapter(Date.class, (JsonSerializer<Date>) (l, typeOfSrc, context) -> {
                JsonObject root = new JsonObject();
                root.addProperty("type", typeOfSrc.getTypeName());
                root.add("value", new JsonPrimitive(l.getTime()));
                return root;
            })
            .registerTypeHierarchyAdapter(Supplier.class, (JsonDeserializer<Supplier>) (json, typeOfT, context) -> {
                if(json instanceof JsonArray) {
                    JsonArray array = (JsonArray)json;
                    List<Object> list = new ArrayList<>();
                    for(JsonElement e : array){
                        list.add(toPrimitive((JsonObject)e).get());
                    }
                    return () -> list;
                }

                return toPrimitive((JsonObject)json);

            })
            .registerTypeHierarchyAdapter(Map.class, (JsonDeserializer<Map>) (json, typeOfT, context) -> {
                LinkedHashMap<String, Object> map = new LinkedHashMap();
                ((JsonObject)json).entrySet().forEach(e->{
                    map.put(e.getKey(), toPrimitive((JsonObject)e.getValue()).get());
                });
              return map;

            })
            .create();

    Supplier toPrimitive(JsonObject obj){
        if(!obj.has("type")){
            return ()-> new Object();
        }
        String type = obj.get("type").getAsString();
        JsonElement primitive = obj.get("value");
        if(type.equals(String.class.getSimpleName())){
            return () -> primitive.getAsString();
        }
        if(type.equals(Long.class.getSimpleName())){
            return () -> primitive.getAsLong();
        }
        if(type.equals(Integer.class.getSimpleName())){
            return () -> primitive.getAsInt();
        }
        if(type.equals(Double.class.getSimpleName())){
            return () -> primitive.getAsDouble();
        }
        if(type.equals(Boolean.class.getSimpleName())){
            return () -> primitive.getAsBoolean();
        }
        if(type.equals(Float.class.getSimpleName())){
            return () -> primitive.getAsFloat();
        }
        if(type.equals(Date.class.getName())){
            return () -> new Date(primitive.getAsLong());
        }
        if(type.equals(java.sql.Date.class.getName())){
            return () -> new java.sql.Date(primitive.getAsLong());
        }
        if(type.equals(Timestamp.class.getName())){
            return () -> new Timestamp(primitive.getAsLong());
        }
        if(type.equals(BigInteger.class.getSimpleName())){
            return () -> BigInteger.valueOf(primitive.getAsLong());
        }
        if(type.equals(BigDecimal.class.getSimpleName())){
            return () -> BigDecimal.valueOf(primitive.getAsDouble());
        }
        return () -> null;
    }
}
