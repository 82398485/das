/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ppdai.das.service;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2020-11-04")
public class DasBatchUpdateBuilder implements org.apache.thrift.TBase<DasBatchUpdateBuilder, DasBatchUpdateBuilder._Fields>, java.io.Serializable, Cloneable, Comparable<DasBatchUpdateBuilder> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DasBatchUpdateBuilder");

  private static final org.apache.thrift.protocol.TField STATEMENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("statements", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField VALUES_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("valuesList", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField HINTS_FIELD_DESC = new org.apache.thrift.protocol.TField("hints", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DasBatchUpdateBuilderStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DasBatchUpdateBuilderTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<String> statements; // optional
  public @org.apache.thrift.annotation.Nullable java.util.List<String> valuesList; // optional
  public @org.apache.thrift.annotation.Nullable String hints; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATEMENTS((short)1, "statements"),
    VALUES_LIST((short)2, "valuesList"),
    HINTS((short)3, "hints");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

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
        case 1: // STATEMENTS
          return STATEMENTS;
        case 2: // VALUES_LIST
          return VALUES_LIST;
        case 3: // HINTS
          return HINTS;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.STATEMENTS,_Fields.VALUES_LIST,_Fields.HINTS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATEMENTS, new org.apache.thrift.meta_data.FieldMetaData("statements", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.VALUES_LIST, new org.apache.thrift.meta_data.FieldMetaData("valuesList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.HINTS, new org.apache.thrift.meta_data.FieldMetaData("hints", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DasBatchUpdateBuilder.class, metaDataMap);
  }

  public DasBatchUpdateBuilder() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DasBatchUpdateBuilder(DasBatchUpdateBuilder other) {
    if (other.isSetStatements()) {
      java.util.List<String> __this__statements = new java.util.ArrayList<String>(other.statements);
      this.statements = __this__statements;
    }
    if (other.isSetValuesList()) {
      java.util.List<String> __this__valuesList = new java.util.ArrayList<String>(other.valuesList);
      this.valuesList = __this__valuesList;
    }
    if (other.isSetHints()) {
      this.hints = other.hints;
    }
  }

  public DasBatchUpdateBuilder deepCopy() {
    return new DasBatchUpdateBuilder(this);
  }

  @Override
  public void clear() {
    this.statements = null;
    this.valuesList = null;
    this.hints = null;
  }

  public int getStatementsSize() {
    return (this.statements == null) ? 0 : this.statements.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<String> getStatementsIterator() {
    return (this.statements == null) ? null : this.statements.iterator();
  }

  public void addToStatements(String elem) {
    if (this.statements == null) {
      this.statements = new java.util.ArrayList<String>();
    }
    this.statements.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<String> getStatements() {
    return this.statements;
  }

  public DasBatchUpdateBuilder setStatements(@org.apache.thrift.annotation.Nullable java.util.List<String> statements) {
    this.statements = statements;
    return this;
  }

  public void unsetStatements() {
    this.statements = null;
  }

  /** Returns true if field statements is set (has been assigned a value) and false otherwise */
  public boolean isSetStatements() {
    return this.statements != null;
  }

  public void setStatementsIsSet(boolean value) {
    if (!value) {
      this.statements = null;
    }
  }

  public int getValuesListSize() {
    return (this.valuesList == null) ? 0 : this.valuesList.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<String> getValuesListIterator() {
    return (this.valuesList == null) ? null : this.valuesList.iterator();
  }

  public void addToValuesList(String elem) {
    if (this.valuesList == null) {
      this.valuesList = new java.util.ArrayList<String>();
    }
    this.valuesList.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<String> getValuesList() {
    return this.valuesList;
  }

  public DasBatchUpdateBuilder setValuesList(@org.apache.thrift.annotation.Nullable java.util.List<String> valuesList) {
    this.valuesList = valuesList;
    return this;
  }

  public void unsetValuesList() {
    this.valuesList = null;
  }

  /** Returns true if field valuesList is set (has been assigned a value) and false otherwise */
  public boolean isSetValuesList() {
    return this.valuesList != null;
  }

  public void setValuesListIsSet(boolean value) {
    if (!value) {
      this.valuesList = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public String getHints() {
    return this.hints;
  }

  public DasBatchUpdateBuilder setHints(@org.apache.thrift.annotation.Nullable String hints) {
    this.hints = hints;
    return this;
  }

  public void unsetHints() {
    this.hints = null;
  }

  /** Returns true if field hints is set (has been assigned a value) and false otherwise */
  public boolean isSetHints() {
    return this.hints != null;
  }

  public void setHintsIsSet(boolean value) {
    if (!value) {
      this.hints = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case STATEMENTS:
      if (value == null) {
        unsetStatements();
      } else {
        setStatements((java.util.List<String>)value);
      }
      break;

    case VALUES_LIST:
      if (value == null) {
        unsetValuesList();
      } else {
        setValuesList((java.util.List<String>)value);
      }
      break;

    case HINTS:
      if (value == null) {
        unsetHints();
      } else {
        setHints((String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATEMENTS:
      return getStatements();

    case VALUES_LIST:
      return getValuesList();

    case HINTS:
      return getHints();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATEMENTS:
      return isSetStatements();
    case VALUES_LIST:
      return isSetValuesList();
    case HINTS:
      return isSetHints();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DasBatchUpdateBuilder)
      return this.equals((DasBatchUpdateBuilder)that);
    return false;
  }

  public boolean equals(DasBatchUpdateBuilder that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_statements = true && this.isSetStatements();
    boolean that_present_statements = true && that.isSetStatements();
    if (this_present_statements || that_present_statements) {
      if (!(this_present_statements && that_present_statements))
        return false;
      if (!this.statements.equals(that.statements))
        return false;
    }

    boolean this_present_valuesList = true && this.isSetValuesList();
    boolean that_present_valuesList = true && that.isSetValuesList();
    if (this_present_valuesList || that_present_valuesList) {
      if (!(this_present_valuesList && that_present_valuesList))
        return false;
      if (!this.valuesList.equals(that.valuesList))
        return false;
    }

    boolean this_present_hints = true && this.isSetHints();
    boolean that_present_hints = true && that.isSetHints();
    if (this_present_hints || that_present_hints) {
      if (!(this_present_hints && that_present_hints))
        return false;
      if (!this.hints.equals(that.hints))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatements()) ? 131071 : 524287);
    if (isSetStatements())
      hashCode = hashCode * 8191 + statements.hashCode();

    hashCode = hashCode * 8191 + ((isSetValuesList()) ? 131071 : 524287);
    if (isSetValuesList())
      hashCode = hashCode * 8191 + valuesList.hashCode();

    hashCode = hashCode * 8191 + ((isSetHints()) ? 131071 : 524287);
    if (isSetHints())
      hashCode = hashCode * 8191 + hints.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(DasBatchUpdateBuilder other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStatements()).compareTo(other.isSetStatements());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatements()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statements, other.statements);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValuesList()).compareTo(other.isSetValuesList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValuesList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.valuesList, other.valuesList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHints()).compareTo(other.isSetHints());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHints()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hints, other.hints);
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
  public String toString() {
    StringBuilder sb = new StringBuilder("DasBatchUpdateBuilder(");
    boolean first = true;

    if (isSetStatements()) {
      sb.append("statements:");
      if (this.statements == null) {
        sb.append("null");
      } else {
        sb.append(this.statements);
      }
      first = false;
    }
    if (isSetValuesList()) {
      if (!first) sb.append(", ");
      sb.append("valuesList:");
      if (this.valuesList == null) {
        sb.append("null");
      } else {
        sb.append(this.valuesList);
      }
      first = false;
    }
    if (isSetHints()) {
      if (!first) sb.append(", ");
      sb.append("hints:");
      if (this.hints == null) {
        sb.append("null");
      } else {
        sb.append(this.hints);
      }
      first = false;
    }
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DasBatchUpdateBuilderStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DasBatchUpdateBuilderStandardScheme getScheme() {
      return new DasBatchUpdateBuilderStandardScheme();
    }
  }

  private static class DasBatchUpdateBuilderStandardScheme extends org.apache.thrift.scheme.StandardScheme<DasBatchUpdateBuilder> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DasBatchUpdateBuilder struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATEMENTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list94 = iprot.readListBegin();
                struct.statements = new java.util.ArrayList<String>(_list94.size);
                @org.apache.thrift.annotation.Nullable String _elem95;
                for (int _i96 = 0; _i96 < _list94.size; ++_i96)
                {
                  _elem95 = iprot.readString();
                  struct.statements.add(_elem95);
                }
                iprot.readListEnd();
              }
              struct.setStatementsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VALUES_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list97 = iprot.readListBegin();
                struct.valuesList = new java.util.ArrayList<String>(_list97.size);
                @org.apache.thrift.annotation.Nullable String _elem98;
                for (int _i99 = 0; _i99 < _list97.size; ++_i99)
                {
                  _elem98 = iprot.readString();
                  struct.valuesList.add(_elem98);
                }
                iprot.readListEnd();
              }
              struct.setValuesListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HINTS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.hints = iprot.readString();
              struct.setHintsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DasBatchUpdateBuilder struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.statements != null) {
        if (struct.isSetStatements()) {
          oprot.writeFieldBegin(STATEMENTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.statements.size()));
            for (String _iter100 : struct.statements)
            {
              oprot.writeString(_iter100);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.valuesList != null) {
        if (struct.isSetValuesList()) {
          oprot.writeFieldBegin(VALUES_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.valuesList.size()));
            for (String _iter101 : struct.valuesList)
            {
              oprot.writeString(_iter101);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.hints != null) {
        if (struct.isSetHints()) {
          oprot.writeFieldBegin(HINTS_FIELD_DESC);
          oprot.writeString(struct.hints);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DasBatchUpdateBuilderTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DasBatchUpdateBuilderTupleScheme getScheme() {
      return new DasBatchUpdateBuilderTupleScheme();
    }
  }

  private static class DasBatchUpdateBuilderTupleScheme extends org.apache.thrift.scheme.TupleScheme<DasBatchUpdateBuilder> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DasBatchUpdateBuilder struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatements()) {
        optionals.set(0);
      }
      if (struct.isSetValuesList()) {
        optionals.set(1);
      }
      if (struct.isSetHints()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatements()) {
        {
          oprot.writeI32(struct.statements.size());
          for (String _iter102 : struct.statements)
          {
            oprot.writeString(_iter102);
          }
        }
      }
      if (struct.isSetValuesList()) {
        {
          oprot.writeI32(struct.valuesList.size());
          for (String _iter103 : struct.valuesList)
          {
            oprot.writeString(_iter103);
          }
        }
      }
      if (struct.isSetHints()) {
        oprot.writeString(struct.hints);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DasBatchUpdateBuilder struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list104 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.statements = new java.util.ArrayList<String>(_list104.size);
          @org.apache.thrift.annotation.Nullable String _elem105;
          for (int _i106 = 0; _i106 < _list104.size; ++_i106)
          {
            _elem105 = iprot.readString();
            struct.statements.add(_elem105);
          }
        }
        struct.setStatementsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list107 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.valuesList = new java.util.ArrayList<String>(_list107.size);
          @org.apache.thrift.annotation.Nullable String _elem108;
          for (int _i109 = 0; _i109 < _list107.size; ++_i109)
          {
            _elem108 = iprot.readString();
            struct.valuesList.add(_elem108);
          }
        }
        struct.setValuesListIsSet(true);
      }
      if (incoming.get(2)) {
        struct.hints = iprot.readString();
        struct.setHintsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

