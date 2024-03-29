// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RpcResponse.proto

package com.xchb.xrpc.common.proto;

public final class RpcResponseProto {
  private RpcResponseProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RpcResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.xchb.xrpc.common.proto.RpcResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    java.lang.String getId();
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    com.google.protobuf.ByteString
        getIdBytes();

    /**
     * <code>string data = 2;</code>
     * @return The data.
     */
    java.lang.String getData();
    /**
     * <code>string data = 2;</code>
     * @return The bytes for data.
     */
    com.google.protobuf.ByteString
        getDataBytes();

    /**
     * <code>string dataType = 3;</code>
     * @return The dataType.
     */
    java.lang.String getDataType();
    /**
     * <code>string dataType = 3;</code>
     * @return The bytes for dataType.
     */
    com.google.protobuf.ByteString
        getDataTypeBytes();
  }
  /**
   * Protobuf type {@code com.xchb.xrpc.common.proto.RpcResponse}
   */
  public static final class RpcResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.xchb.xrpc.common.proto.RpcResponse)
      RpcResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use RpcResponse.newBuilder() to construct.
    private RpcResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RpcResponse() {
      id_ = "";
      data_ = "";
      dataType_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new RpcResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RpcResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              id_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              data_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              dataType_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xchb.xrpc.common.proto.RpcResponseProto.internal_static_com_xchb_xrpc_common_proto_RpcResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xchb.xrpc.common.proto.RpcResponseProto.internal_static_com_xchb_xrpc_common_proto_RpcResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.class, com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATA_FIELD_NUMBER = 2;
    private volatile java.lang.Object data_;
    /**
     * <code>string data = 2;</code>
     * @return The data.
     */
    @java.lang.Override
    public java.lang.String getData() {
      java.lang.Object ref = data_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        data_ = s;
        return s;
      }
    }
    /**
     * <code>string data = 2;</code>
     * @return The bytes for data.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDataBytes() {
      java.lang.Object ref = data_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATATYPE_FIELD_NUMBER = 3;
    private volatile java.lang.Object dataType_;
    /**
     * <code>string dataType = 3;</code>
     * @return The dataType.
     */
    @java.lang.Override
    public java.lang.String getDataType() {
      java.lang.Object ref = dataType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dataType_ = s;
        return s;
      }
    }
    /**
     * <code>string dataType = 3;</code>
     * @return The bytes for dataType.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDataTypeBytes() {
      java.lang.Object ref = dataType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dataType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      if (!getDataBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, data_);
      }
      if (!getDataTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dataType_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      if (!getDataBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, data_);
      }
      if (!getDataTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dataType_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse)) {
        return super.equals(obj);
      }
      com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse other = (com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse) obj;

      if (!getId()
          .equals(other.getId())) return false;
      if (!getData()
          .equals(other.getData())) return false;
      if (!getDataType()
          .equals(other.getDataType())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId().hashCode();
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
      hash = (37 * hash) + DATATYPE_FIELD_NUMBER;
      hash = (53 * hash) + getDataType().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.xchb.xrpc.common.proto.RpcResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.xchb.xrpc.common.proto.RpcResponse)
        com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.xchb.xrpc.common.proto.RpcResponseProto.internal_static_com_xchb_xrpc_common_proto_RpcResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.xchb.xrpc.common.proto.RpcResponseProto.internal_static_com_xchb_xrpc_common_proto_RpcResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.class, com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.Builder.class);
      }

      // Construct using com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = "";

        data_ = "";

        dataType_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.xchb.xrpc.common.proto.RpcResponseProto.internal_static_com_xchb_xrpc_common_proto_RpcResponse_descriptor;
      }

      @java.lang.Override
      public com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse getDefaultInstanceForType() {
        return com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse build() {
        com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse buildPartial() {
        com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse result = new com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse(this);
        result.id_ = id_;
        result.data_ = data_;
        result.dataType_ = dataType_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse) {
          return mergeFrom((com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse other) {
        if (other == com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse.getDefaultInstance()) return this;
        if (!other.getId().isEmpty()) {
          id_ = other.id_;
          onChanged();
        }
        if (!other.getData().isEmpty()) {
          data_ = other.data_;
          onChanged();
        }
        if (!other.getDataType().isEmpty()) {
          dataType_ = other.dataType_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object id_ = "";
      /**
       * <code>string id = 1;</code>
       * @return The id.
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       * @return The bytes for id.
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearId() {
        
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       * @param value The bytes for id to set.
       * @return This builder for chaining.
       */
      public Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        id_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object data_ = "";
      /**
       * <code>string data = 2;</code>
       * @return The data.
       */
      public java.lang.String getData() {
        java.lang.Object ref = data_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          data_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string data = 2;</code>
       * @return The bytes for data.
       */
      public com.google.protobuf.ByteString
          getDataBytes() {
        java.lang.Object ref = data_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          data_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string data = 2;</code>
       * @param value The data to set.
       * @return This builder for chaining.
       */
      public Builder setData(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string data = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearData() {
        
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }
      /**
       * <code>string data = 2;</code>
       * @param value The bytes for data to set.
       * @return This builder for chaining.
       */
      public Builder setDataBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        data_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object dataType_ = "";
      /**
       * <code>string dataType = 3;</code>
       * @return The dataType.
       */
      public java.lang.String getDataType() {
        java.lang.Object ref = dataType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dataType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dataType = 3;</code>
       * @return The bytes for dataType.
       */
      public com.google.protobuf.ByteString
          getDataTypeBytes() {
        java.lang.Object ref = dataType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          dataType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dataType = 3;</code>
       * @param value The dataType to set.
       * @return This builder for chaining.
       */
      public Builder setDataType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        dataType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dataType = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearDataType() {
        
        dataType_ = getDefaultInstance().getDataType();
        onChanged();
        return this;
      }
      /**
       * <code>string dataType = 3;</code>
       * @param value The bytes for dataType to set.
       * @return This builder for chaining.
       */
      public Builder setDataTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        dataType_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.xchb.xrpc.common.proto.RpcResponse)
    }

    // @@protoc_insertion_point(class_scope:com.xchb.xrpc.common.proto.RpcResponse)
    private static final com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse();
    }

    public static com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RpcResponse>
        PARSER = new com.google.protobuf.AbstractParser<RpcResponse>() {
      @java.lang.Override
      public RpcResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RpcResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RpcResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RpcResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.xchb.xrpc.common.proto.RpcResponseProto.RpcResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xchb_xrpc_common_proto_RpcResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xchb_xrpc_common_proto_RpcResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021RpcResponse.proto\022\032com.xchb.xrpc.commo" +
      "n.proto\"9\n\013RpcResponse\022\n\n\002id\030\001 \001(\t\022\014\n\004da" +
      "ta\030\002 \001(\t\022\020\n\010dataType\030\003 \001(\tB\022B\020RpcRespons" +
      "eProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_xchb_xrpc_common_proto_RpcResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_xchb_xrpc_common_proto_RpcResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xchb_xrpc_common_proto_RpcResponse_descriptor,
        new java.lang.String[] { "Id", "Data", "DataType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
