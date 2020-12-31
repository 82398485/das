/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ppdai.das.service;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2020-12-30")
public class DasCallBuilder implements org.apache.thrift.TBase<DasCallBuilder, DasCallBuilder._Fields>, java.io.Serializable, Cloneable, Comparable<DasCallBuilder> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DasCallBuilder");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField("parameters", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField CALL_BY_INDEX_FIELD_DESC = new org.apache.thrift.protocol.TField("callByIndex", org.apache.thrift.protocol.TType.BOOL, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DasCallBuilderStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DasCallBuilderTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String name; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<DasParameter> parameters; // optional
  public boolean callByIndex; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    PARAMETERS((short)2, "parameters"),
    CALL_BY_INDEX((short)3, "callByIndex");

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
        case 1: // NAME
          return NAME;
        case 2: // PARAMETERS
          return PARAMETERS;
        case 3: // CALL_BY_INDEX
          return CALL_BY_INDEX;
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
  private static final int __CALLBYINDEX_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PARAMETERS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARAMETERS, new org.apache.thrift.meta_data.FieldMetaData("parameters", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "DasParameter"))));
    tmpMap.put(_Fields.CALL_BY_INDEX, new org.apache.thrift.meta_data.FieldMetaData("callByIndex", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DasCallBuilder.class, metaDataMap);
  }

  public DasCallBuilder() {
  }

  public DasCallBuilder(
    java.lang.String name,
    boolean callByIndex)
  {
    this();
    this.name = name;
    this.callByIndex = callByIndex;
    setCallByIndexIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DasCallBuilder(DasCallBuilder other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetParameters()) {
      java.util.List<DasParameter> __this__parameters = new java.util.ArrayList<DasParameter>(other.parameters.size());
      for (DasParameter other_element : other.parameters) {
        __this__parameters.add(new DasParameter(other_element));
      }
      this.parameters = __this__parameters;
    }
    this.callByIndex = other.callByIndex;
  }

  public DasCallBuilder deepCopy() {
    return new DasCallBuilder(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.parameters = null;
    setCallByIndexIsSet(false);
    this.callByIndex = false;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getName() {
    return this.name;
  }

  public DasCallBuilder setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getParametersSize() {
    return (this.parameters == null) ? 0 : this.parameters.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<DasParameter> getParametersIterator() {
    return (this.parameters == null) ? null : this.parameters.iterator();
  }

  public void addToParameters(DasParameter elem) {
    if (this.parameters == null) {
      this.parameters = new java.util.ArrayList<DasParameter>();
    }
    this.parameters.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<DasParameter> getParameters() {
    return this.parameters;
  }

  public DasCallBuilder setParameters(@org.apache.thrift.annotation.Nullable java.util.List<DasParameter> parameters) {
    this.parameters = parameters;
    return this;
  }

  public void unsetParameters() {
    this.parameters = null;
  }

  /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
  public boolean isSetParameters() {
    return this.parameters != null;
  }

  public void setParametersIsSet(boolean value) {
    if (!value) {
      this.parameters = null;
    }
  }

  public boolean isCallByIndex() {
    return this.callByIndex;
  }

  public DasCallBuilder setCallByIndex(boolean callByIndex) {
    this.callByIndex = callByIndex;
    setCallByIndexIsSet(true);
    return this;
  }

  public void unsetCallByIndex() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CALLBYINDEX_ISSET_ID);
  }

  /** Returns true if field callByIndex is set (has been assigned a value) and false otherwise */
  public boolean isSetCallByIndex() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CALLBYINDEX_ISSET_ID);
  }

  public void setCallByIndexIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CALLBYINDEX_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case PARAMETERS:
      if (value == null) {
        unsetParameters();
      } else {
        setParameters((java.util.List<DasParameter>)value);
      }
      break;

    case CALL_BY_INDEX:
      if (value == null) {
        unsetCallByIndex();
      } else {
        setCallByIndex((java.lang.Boolean)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case PARAMETERS:
      return getParameters();

    case CALL_BY_INDEX:
      return isCallByIndex();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case PARAMETERS:
      return isSetParameters();
    case CALL_BY_INDEX:
      return isSetCallByIndex();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof DasCallBuilder)
      return this.equals((DasCallBuilder)that);
    return false;
  }

  public boolean equals(DasCallBuilder that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_parameters = true && this.isSetParameters();
    boolean that_present_parameters = true && that.isSetParameters();
    if (this_present_parameters || that_present_parameters) {
      if (!(this_present_parameters && that_present_parameters))
        return false;
      if (!this.parameters.equals(that.parameters))
        return false;
    }

    boolean this_present_callByIndex = true;
    boolean that_present_callByIndex = true;
    if (this_present_callByIndex || that_present_callByIndex) {
      if (!(this_present_callByIndex && that_present_callByIndex))
        return false;
      if (this.callByIndex != that.callByIndex)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
    if (isSetParameters())
      hashCode = hashCode * 8191 + parameters.hashCode();

    hashCode = hashCode * 8191 + ((callByIndex) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(DasCallBuilder other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetParameters()).compareTo(other.isSetParameters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParameters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCallByIndex()).compareTo(other.isSetCallByIndex());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCallByIndex()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.callByIndex, other.callByIndex);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("DasCallBuilder(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (isSetParameters()) {
      if (!first) sb.append(", ");
      sb.append("parameters:");
      if (this.parameters == null) {
        sb.append("null");
      } else {
        sb.append(this.parameters);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("callByIndex:");
    sb.append(this.callByIndex);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class DasCallBuilderStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DasCallBuilderStandardScheme getScheme() {
      return new DasCallBuilderStandardScheme();
    }
  }

  private static class DasCallBuilderStandardScheme extends org.apache.thrift.scheme.StandardScheme<DasCallBuilder> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DasCallBuilder struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARAMETERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list86 = iprot.readListBegin();
                struct.parameters = new java.util.ArrayList<DasParameter>(_list86.size);
                @org.apache.thrift.annotation.Nullable DasParameter _elem87;
                for (int _i88 = 0; _i88 < _list86.size; ++_i88)
                {
                  _elem87 = new DasParameter();
                  _elem87.read(iprot);
                  struct.parameters.add(_elem87);
                }
                iprot.readListEnd();
              }
              struct.setParametersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CALL_BY_INDEX
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.callByIndex = iprot.readBool();
              struct.setCallByIndexIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DasCallBuilder struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.parameters != null) {
        if (struct.isSetParameters()) {
          oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.parameters.size()));
            for (DasParameter _iter89 : struct.parameters)
            {
              _iter89.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(CALL_BY_INDEX_FIELD_DESC);
      oprot.writeBool(struct.callByIndex);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DasCallBuilderTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DasCallBuilderTupleScheme getScheme() {
      return new DasCallBuilderTupleScheme();
    }
  }

  private static class DasCallBuilderTupleScheme extends org.apache.thrift.scheme.TupleScheme<DasCallBuilder> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DasCallBuilder struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetParameters()) {
        optionals.set(1);
      }
      if (struct.isSetCallByIndex()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetParameters()) {
        {
          oprot.writeI32(struct.parameters.size());
          for (DasParameter _iter90 : struct.parameters)
          {
            _iter90.write(oprot);
          }
        }
      }
      if (struct.isSetCallByIndex()) {
        oprot.writeBool(struct.callByIndex);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DasCallBuilder struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list91 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.parameters = new java.util.ArrayList<DasParameter>(_list91.size);
          @org.apache.thrift.annotation.Nullable DasParameter _elem92;
          for (int _i93 = 0; _i93 < _list91.size; ++_i93)
          {
            _elem92 = new DasParameter();
            _elem92.read(iprot);
            struct.parameters.add(_elem92);
          }
        }
        struct.setParametersIsSet(true);
      }
      if (incoming.get(2)) {
        struct.callByIndex = iprot.readBool();
        struct.setCallByIndexIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

