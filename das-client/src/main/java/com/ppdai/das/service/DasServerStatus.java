/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ppdai.das.service;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2020-12-30")
public class DasServerStatus implements org.apache.thrift.TBase<DasServerStatus, DasServerStatus._Fields>, java.io.Serializable, Cloneable, Comparable<DasServerStatus> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DasServerStatus");

  private static final org.apache.thrift.protocol.TField ONLINE_FIELD_DESC = new org.apache.thrift.protocol.TField("online", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField CPU_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuRate", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField MEM_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("memRate", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CLIENT_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("clientCount", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField AVG_RESPONSE_FIELD_DESC = new org.apache.thrift.protocol.TField("avgResponse", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField AVG_THROUGHPUT_FIELD_DESC = new org.apache.thrift.protocol.TField("avgThroughput", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField HEALTHY_POINT_FIELD_DESC = new org.apache.thrift.protocol.TField("healthyPoint", org.apache.thrift.protocol.TType.I32, (short)7);
  private static final org.apache.thrift.protocol.TField TRANSACTION_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("transactionCount", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DasServerStatusStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DasServerStatusTupleSchemeFactory();

  public boolean online; // required
  public int cpuRate; // required
  public int memRate; // required
  public int clientCount; // required
  public long avgResponse; // required
  public long avgThroughput; // required
  public int healthyPoint; // required
  public int transactionCount; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ONLINE((short)1, "online"),
    CPU_RATE((short)2, "cpuRate"),
    MEM_RATE((short)3, "memRate"),
    CLIENT_COUNT((short)4, "clientCount"),
    AVG_RESPONSE((short)5, "avgResponse"),
    AVG_THROUGHPUT((short)6, "avgThroughput"),
    HEALTHY_POINT((short)7, "healthyPoint"),
    TRANSACTION_COUNT((short)8, "transactionCount");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ONLINE
          return ONLINE;
        case 2: // CPU_RATE
          return CPU_RATE;
        case 3: // MEM_RATE
          return MEM_RATE;
        case 4: // CLIENT_COUNT
          return CLIENT_COUNT;
        case 5: // AVG_RESPONSE
          return AVG_RESPONSE;
        case 6: // AVG_THROUGHPUT
          return AVG_THROUGHPUT;
        case 7: // HEALTHY_POINT
          return HEALTHY_POINT;
        case 8: // TRANSACTION_COUNT
          return TRANSACTION_COUNT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ONLINE_ISSET_ID = 0;
  private static final int __CPURATE_ISSET_ID = 1;
  private static final int __MEMRATE_ISSET_ID = 2;
  private static final int __CLIENTCOUNT_ISSET_ID = 3;
  private static final int __AVGRESPONSE_ISSET_ID = 4;
  private static final int __AVGTHROUGHPUT_ISSET_ID = 5;
  private static final int __HEALTHYPOINT_ISSET_ID = 6;
  private static final int __TRANSACTIONCOUNT_ISSET_ID = 7;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ONLINE, new org.apache.thrift.meta_data.FieldMetaData("online", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.CPU_RATE, new org.apache.thrift.meta_data.FieldMetaData("cpuRate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MEM_RATE, new org.apache.thrift.meta_data.FieldMetaData("memRate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CLIENT_COUNT, new org.apache.thrift.meta_data.FieldMetaData("clientCount", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AVG_RESPONSE, new org.apache.thrift.meta_data.FieldMetaData("avgResponse", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.AVG_THROUGHPUT, new org.apache.thrift.meta_data.FieldMetaData("avgThroughput", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.HEALTHY_POINT, new org.apache.thrift.meta_data.FieldMetaData("healthyPoint", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TRANSACTION_COUNT, new org.apache.thrift.meta_data.FieldMetaData("transactionCount", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DasServerStatus.class, metaDataMap);
  }

  public DasServerStatus() {
  }

  public DasServerStatus(
    boolean online,
    int cpuRate,
    int memRate,
    int clientCount,
    long avgResponse,
    long avgThroughput,
    int healthyPoint,
    int transactionCount)
  {
    this();
    this.online = online;
    setOnlineIsSet(true);
    this.cpuRate = cpuRate;
    setCpuRateIsSet(true);
    this.memRate = memRate;
    setMemRateIsSet(true);
    this.clientCount = clientCount;
    setClientCountIsSet(true);
    this.avgResponse = avgResponse;
    setAvgResponseIsSet(true);
    this.avgThroughput = avgThroughput;
    setAvgThroughputIsSet(true);
    this.healthyPoint = healthyPoint;
    setHealthyPointIsSet(true);
    this.transactionCount = transactionCount;
    setTransactionCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DasServerStatus(DasServerStatus other) {
    __isset_bitfield = other.__isset_bitfield;
    this.online = other.online;
    this.cpuRate = other.cpuRate;
    this.memRate = other.memRate;
    this.clientCount = other.clientCount;
    this.avgResponse = other.avgResponse;
    this.avgThroughput = other.avgThroughput;
    this.healthyPoint = other.healthyPoint;
    this.transactionCount = other.transactionCount;
  }

  public DasServerStatus deepCopy() {
    return new DasServerStatus(this);
  }

  @Override
  public void clear() {
    setOnlineIsSet(false);
    this.online = false;
    setCpuRateIsSet(false);
    this.cpuRate = 0;
    setMemRateIsSet(false);
    this.memRate = 0;
    setClientCountIsSet(false);
    this.clientCount = 0;
    setAvgResponseIsSet(false);
    this.avgResponse = 0;
    setAvgThroughputIsSet(false);
    this.avgThroughput = 0;
    setHealthyPointIsSet(false);
    this.healthyPoint = 0;
    setTransactionCountIsSet(false);
    this.transactionCount = 0;
  }

  public boolean isOnline() {
    return this.online;
  }

  public DasServerStatus setOnline(boolean online) {
    this.online = online;
    setOnlineIsSet(true);
    return this;
  }

  public void unsetOnline() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ONLINE_ISSET_ID);
  }

  /** Returns true if field online is set (has been assigned a value) and false otherwise */
  public boolean isSetOnline() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ONLINE_ISSET_ID);
  }

  public void setOnlineIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ONLINE_ISSET_ID, value);
  }

  public int getCpuRate() {
    return this.cpuRate;
  }

  public DasServerStatus setCpuRate(int cpuRate) {
    this.cpuRate = cpuRate;
    setCpuRateIsSet(true);
    return this;
  }

  public void unsetCpuRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CPURATE_ISSET_ID);
  }

  /** Returns true if field cpuRate is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CPURATE_ISSET_ID);
  }

  public void setCpuRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CPURATE_ISSET_ID, value);
  }

  public int getMemRate() {
    return this.memRate;
  }

  public DasServerStatus setMemRate(int memRate) {
    this.memRate = memRate;
    setMemRateIsSet(true);
    return this;
  }

  public void unsetMemRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MEMRATE_ISSET_ID);
  }

  /** Returns true if field memRate is set (has been assigned a value) and false otherwise */
  public boolean isSetMemRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MEMRATE_ISSET_ID);
  }

  public void setMemRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MEMRATE_ISSET_ID, value);
  }

  public int getClientCount() {
    return this.clientCount;
  }

  public DasServerStatus setClientCount(int clientCount) {
    this.clientCount = clientCount;
    setClientCountIsSet(true);
    return this;
  }

  public void unsetClientCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CLIENTCOUNT_ISSET_ID);
  }

  /** Returns true if field clientCount is set (has been assigned a value) and false otherwise */
  public boolean isSetClientCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CLIENTCOUNT_ISSET_ID);
  }

  public void setClientCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CLIENTCOUNT_ISSET_ID, value);
  }

  public long getAvgResponse() {
    return this.avgResponse;
  }

  public DasServerStatus setAvgResponse(long avgResponse) {
    this.avgResponse = avgResponse;
    setAvgResponseIsSet(true);
    return this;
  }

  public void unsetAvgResponse() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AVGRESPONSE_ISSET_ID);
  }

  /** Returns true if field avgResponse is set (has been assigned a value) and false otherwise */
  public boolean isSetAvgResponse() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AVGRESPONSE_ISSET_ID);
  }

  public void setAvgResponseIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AVGRESPONSE_ISSET_ID, value);
  }

  public long getAvgThroughput() {
    return this.avgThroughput;
  }

  public DasServerStatus setAvgThroughput(long avgThroughput) {
    this.avgThroughput = avgThroughput;
    setAvgThroughputIsSet(true);
    return this;
  }

  public void unsetAvgThroughput() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AVGTHROUGHPUT_ISSET_ID);
  }

  /** Returns true if field avgThroughput is set (has been assigned a value) and false otherwise */
  public boolean isSetAvgThroughput() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AVGTHROUGHPUT_ISSET_ID);
  }

  public void setAvgThroughputIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AVGTHROUGHPUT_ISSET_ID, value);
  }

  public int getHealthyPoint() {
    return this.healthyPoint;
  }

  public DasServerStatus setHealthyPoint(int healthyPoint) {
    this.healthyPoint = healthyPoint;
    setHealthyPointIsSet(true);
    return this;
  }

  public void unsetHealthyPoint() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __HEALTHYPOINT_ISSET_ID);
  }

  /** Returns true if field healthyPoint is set (has been assigned a value) and false otherwise */
  public boolean isSetHealthyPoint() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __HEALTHYPOINT_ISSET_ID);
  }

  public void setHealthyPointIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __HEALTHYPOINT_ISSET_ID, value);
  }

  public int getTransactionCount() {
    return this.transactionCount;
  }

  public DasServerStatus setTransactionCount(int transactionCount) {
    this.transactionCount = transactionCount;
    setTransactionCountIsSet(true);
    return this;
  }

  public void unsetTransactionCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TRANSACTIONCOUNT_ISSET_ID);
  }

  /** Returns true if field transactionCount is set (has been assigned a value) and false otherwise */
  public boolean isSetTransactionCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TRANSACTIONCOUNT_ISSET_ID);
  }

  public void setTransactionCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TRANSACTIONCOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ONLINE:
      if (value == null) {
        unsetOnline();
      } else {
        setOnline((java.lang.Boolean)value);
      }
      break;

    case CPU_RATE:
      if (value == null) {
        unsetCpuRate();
      } else {
        setCpuRate((java.lang.Integer)value);
      }
      break;

    case MEM_RATE:
      if (value == null) {
        unsetMemRate();
      } else {
        setMemRate((java.lang.Integer)value);
      }
      break;

    case CLIENT_COUNT:
      if (value == null) {
        unsetClientCount();
      } else {
        setClientCount((java.lang.Integer)value);
      }
      break;

    case AVG_RESPONSE:
      if (value == null) {
        unsetAvgResponse();
      } else {
        setAvgResponse((java.lang.Long)value);
      }
      break;

    case AVG_THROUGHPUT:
      if (value == null) {
        unsetAvgThroughput();
      } else {
        setAvgThroughput((java.lang.Long)value);
      }
      break;

    case HEALTHY_POINT:
      if (value == null) {
        unsetHealthyPoint();
      } else {
        setHealthyPoint((java.lang.Integer)value);
      }
      break;

    case TRANSACTION_COUNT:
      if (value == null) {
        unsetTransactionCount();
      } else {
        setTransactionCount((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ONLINE:
      return isOnline();

    case CPU_RATE:
      return getCpuRate();

    case MEM_RATE:
      return getMemRate();

    case CLIENT_COUNT:
      return getClientCount();

    case AVG_RESPONSE:
      return getAvgResponse();

    case AVG_THROUGHPUT:
      return getAvgThroughput();

    case HEALTHY_POINT:
      return getHealthyPoint();

    case TRANSACTION_COUNT:
      return getTransactionCount();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ONLINE:
      return isSetOnline();
    case CPU_RATE:
      return isSetCpuRate();
    case MEM_RATE:
      return isSetMemRate();
    case CLIENT_COUNT:
      return isSetClientCount();
    case AVG_RESPONSE:
      return isSetAvgResponse();
    case AVG_THROUGHPUT:
      return isSetAvgThroughput();
    case HEALTHY_POINT:
      return isSetHealthyPoint();
    case TRANSACTION_COUNT:
      return isSetTransactionCount();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof DasServerStatus)
      return this.equals((DasServerStatus)that);
    return false;
  }

  public boolean equals(DasServerStatus that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_online = true;
    boolean that_present_online = true;
    if (this_present_online || that_present_online) {
      if (!(this_present_online && that_present_online))
        return false;
      if (this.online != that.online)
        return false;
    }

    boolean this_present_cpuRate = true;
    boolean that_present_cpuRate = true;
    if (this_present_cpuRate || that_present_cpuRate) {
      if (!(this_present_cpuRate && that_present_cpuRate))
        return false;
      if (this.cpuRate != that.cpuRate)
        return false;
    }

    boolean this_present_memRate = true;
    boolean that_present_memRate = true;
    if (this_present_memRate || that_present_memRate) {
      if (!(this_present_memRate && that_present_memRate))
        return false;
      if (this.memRate != that.memRate)
        return false;
    }

    boolean this_present_clientCount = true;
    boolean that_present_clientCount = true;
    if (this_present_clientCount || that_present_clientCount) {
      if (!(this_present_clientCount && that_present_clientCount))
        return false;
      if (this.clientCount != that.clientCount)
        return false;
    }

    boolean this_present_avgResponse = true;
    boolean that_present_avgResponse = true;
    if (this_present_avgResponse || that_present_avgResponse) {
      if (!(this_present_avgResponse && that_present_avgResponse))
        return false;
      if (this.avgResponse != that.avgResponse)
        return false;
    }

    boolean this_present_avgThroughput = true;
    boolean that_present_avgThroughput = true;
    if (this_present_avgThroughput || that_present_avgThroughput) {
      if (!(this_present_avgThroughput && that_present_avgThroughput))
        return false;
      if (this.avgThroughput != that.avgThroughput)
        return false;
    }

    boolean this_present_healthyPoint = true;
    boolean that_present_healthyPoint = true;
    if (this_present_healthyPoint || that_present_healthyPoint) {
      if (!(this_present_healthyPoint && that_present_healthyPoint))
        return false;
      if (this.healthyPoint != that.healthyPoint)
        return false;
    }

    boolean this_present_transactionCount = true;
    boolean that_present_transactionCount = true;
    if (this_present_transactionCount || that_present_transactionCount) {
      if (!(this_present_transactionCount && that_present_transactionCount))
        return false;
      if (this.transactionCount != that.transactionCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((online) ? 131071 : 524287);

    hashCode = hashCode * 8191 + cpuRate;

    hashCode = hashCode * 8191 + memRate;

    hashCode = hashCode * 8191 + clientCount;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(avgResponse);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(avgThroughput);

    hashCode = hashCode * 8191 + healthyPoint;

    hashCode = hashCode * 8191 + transactionCount;

    return hashCode;
  }

  @Override
  public int compareTo(DasServerStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetOnline()).compareTo(other.isSetOnline());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOnline()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.online, other.online);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCpuRate()).compareTo(other.isSetCpuRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuRate, other.cpuRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMemRate()).compareTo(other.isSetMemRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memRate, other.memRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetClientCount()).compareTo(other.isSetClientCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClientCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clientCount, other.clientCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAvgResponse()).compareTo(other.isSetAvgResponse());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAvgResponse()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.avgResponse, other.avgResponse);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAvgThroughput()).compareTo(other.isSetAvgThroughput());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAvgThroughput()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.avgThroughput, other.avgThroughput);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetHealthyPoint()).compareTo(other.isSetHealthyPoint());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHealthyPoint()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.healthyPoint, other.healthyPoint);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTransactionCount()).compareTo(other.isSetTransactionCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTransactionCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transactionCount, other.transactionCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("DasServerStatus(");
    boolean first = true;

    sb.append("online:");
    sb.append(this.online);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuRate:");
    sb.append(this.cpuRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("memRate:");
    sb.append(this.memRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("clientCount:");
    sb.append(this.clientCount);
    first = false;
    if (!first) sb.append(", ");
    sb.append("avgResponse:");
    sb.append(this.avgResponse);
    first = false;
    if (!first) sb.append(", ");
    sb.append("avgThroughput:");
    sb.append(this.avgThroughput);
    first = false;
    if (!first) sb.append(", ");
    sb.append("healthyPoint:");
    sb.append(this.healthyPoint);
    first = false;
    if (!first) sb.append(", ");
    sb.append("transactionCount:");
    sb.append(this.transactionCount);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'online' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'cpuRate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'memRate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'clientCount' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'avgResponse' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'avgThroughput' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'healthyPoint' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'transactionCount' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DasServerStatusStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DasServerStatusStandardScheme getScheme() {
      return new DasServerStatusStandardScheme();
    }
  }

  private static class DasServerStatusStandardScheme extends org.apache.thrift.scheme.StandardScheme<DasServerStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DasServerStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ONLINE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.online = iprot.readBool();
              struct.setOnlineIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CPU_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.cpuRate = iprot.readI32();
              struct.setCpuRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MEM_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.memRate = iprot.readI32();
              struct.setMemRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CLIENT_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.clientCount = iprot.readI32();
              struct.setClientCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // AVG_RESPONSE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.avgResponse = iprot.readI64();
              struct.setAvgResponseIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // AVG_THROUGHPUT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.avgThroughput = iprot.readI64();
              struct.setAvgThroughputIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // HEALTHY_POINT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.healthyPoint = iprot.readI32();
              struct.setHealthyPointIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // TRANSACTION_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.transactionCount = iprot.readI32();
              struct.setTransactionCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetOnline()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'online' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCpuRate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'cpuRate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetMemRate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'memRate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetClientCount()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'clientCount' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAvgResponse()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'avgResponse' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAvgThroughput()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'avgThroughput' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetHealthyPoint()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'healthyPoint' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetTransactionCount()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'transactionCount' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DasServerStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ONLINE_FIELD_DESC);
      oprot.writeBool(struct.online);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CPU_RATE_FIELD_DESC);
      oprot.writeI32(struct.cpuRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MEM_RATE_FIELD_DESC);
      oprot.writeI32(struct.memRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CLIENT_COUNT_FIELD_DESC);
      oprot.writeI32(struct.clientCount);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AVG_RESPONSE_FIELD_DESC);
      oprot.writeI64(struct.avgResponse);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AVG_THROUGHPUT_FIELD_DESC);
      oprot.writeI64(struct.avgThroughput);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HEALTHY_POINT_FIELD_DESC);
      oprot.writeI32(struct.healthyPoint);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TRANSACTION_COUNT_FIELD_DESC);
      oprot.writeI32(struct.transactionCount);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DasServerStatusTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DasServerStatusTupleScheme getScheme() {
      return new DasServerStatusTupleScheme();
    }
  }

  private static class DasServerStatusTupleScheme extends org.apache.thrift.scheme.TupleScheme<DasServerStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DasServerStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeBool(struct.online);
      oprot.writeI32(struct.cpuRate);
      oprot.writeI32(struct.memRate);
      oprot.writeI32(struct.clientCount);
      oprot.writeI64(struct.avgResponse);
      oprot.writeI64(struct.avgThroughput);
      oprot.writeI32(struct.healthyPoint);
      oprot.writeI32(struct.transactionCount);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DasServerStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.online = iprot.readBool();
      struct.setOnlineIsSet(true);
      struct.cpuRate = iprot.readI32();
      struct.setCpuRateIsSet(true);
      struct.memRate = iprot.readI32();
      struct.setMemRateIsSet(true);
      struct.clientCount = iprot.readI32();
      struct.setClientCountIsSet(true);
      struct.avgResponse = iprot.readI64();
      struct.setAvgResponseIsSet(true);
      struct.avgThroughput = iprot.readI64();
      struct.setAvgThroughputIsSet(true);
      struct.healthyPoint = iprot.readI32();
      struct.setHealthyPointIsSet(true);
      struct.transactionCount = iprot.readI32();
      struct.setTransactionCountIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

