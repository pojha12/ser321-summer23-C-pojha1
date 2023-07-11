// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/zoo.proto

package service;

/**
 * <pre>
 * REQUEST: Add an animal
 * </pre>
 *
 * Protobuf type {@code services.AddAnimalRequest}
 */
public final class AddAnimalRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.AddAnimalRequest)
    AddAnimalRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AddAnimalRequest.newBuilder() to construct.
  private AddAnimalRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddAnimalRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AddAnimalRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AddAnimalRequest(
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
            service.Animal.Builder subBuilder = null;
            if (animal_ != null) {
              subBuilder = animal_.toBuilder();
            }
            animal_ = input.readMessage(service.Animal.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(animal_);
              animal_ = subBuilder.buildPartial();
            }

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
    return service.ZooProto.internal_static_services_AddAnimalRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.ZooProto.internal_static_services_AddAnimalRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.AddAnimalRequest.class, service.AddAnimalRequest.Builder.class);
  }

  public static final int ANIMAL_FIELD_NUMBER = 1;
  private service.Animal animal_;
  /**
   * <pre>
   * Animal to add to the zoo
   * </pre>
   *
   * <code>.services.Animal animal = 1;</code>
   * @return Whether the animal field is set.
   */
  @java.lang.Override
  public boolean hasAnimal() {
    return animal_ != null;
  }
  /**
   * <pre>
   * Animal to add to the zoo
   * </pre>
   *
   * <code>.services.Animal animal = 1;</code>
   * @return The animal.
   */
  @java.lang.Override
  public service.Animal getAnimal() {
    return animal_ == null ? service.Animal.getDefaultInstance() : animal_;
  }
  /**
   * <pre>
   * Animal to add to the zoo
   * </pre>
   *
   * <code>.services.Animal animal = 1;</code>
   */
  @java.lang.Override
  public service.AnimalOrBuilder getAnimalOrBuilder() {
    return getAnimal();
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
    if (animal_ != null) {
      output.writeMessage(1, getAnimal());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (animal_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAnimal());
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
    if (!(obj instanceof service.AddAnimalRequest)) {
      return super.equals(obj);
    }
    service.AddAnimalRequest other = (service.AddAnimalRequest) obj;

    if (hasAnimal() != other.hasAnimal()) return false;
    if (hasAnimal()) {
      if (!getAnimal()
          .equals(other.getAnimal())) return false;
    }
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
    if (hasAnimal()) {
      hash = (37 * hash) + ANIMAL_FIELD_NUMBER;
      hash = (53 * hash) + getAnimal().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.AddAnimalRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.AddAnimalRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.AddAnimalRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.AddAnimalRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.AddAnimalRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.AddAnimalRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.AddAnimalRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.AddAnimalRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.AddAnimalRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.AddAnimalRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.AddAnimalRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.AddAnimalRequest parseFrom(
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
  public static Builder newBuilder(service.AddAnimalRequest prototype) {
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
   * <pre>
   * REQUEST: Add an animal
   * </pre>
   *
   * Protobuf type {@code services.AddAnimalRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.AddAnimalRequest)
      service.AddAnimalRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.ZooProto.internal_static_services_AddAnimalRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.ZooProto.internal_static_services_AddAnimalRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.AddAnimalRequest.class, service.AddAnimalRequest.Builder.class);
    }

    // Construct using service.AddAnimalRequest.newBuilder()
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
      if (animalBuilder_ == null) {
        animal_ = null;
      } else {
        animal_ = null;
        animalBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.ZooProto.internal_static_services_AddAnimalRequest_descriptor;
    }

    @java.lang.Override
    public service.AddAnimalRequest getDefaultInstanceForType() {
      return service.AddAnimalRequest.getDefaultInstance();
    }

    @java.lang.Override
    public service.AddAnimalRequest build() {
      service.AddAnimalRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.AddAnimalRequest buildPartial() {
      service.AddAnimalRequest result = new service.AddAnimalRequest(this);
      if (animalBuilder_ == null) {
        result.animal_ = animal_;
      } else {
        result.animal_ = animalBuilder_.build();
      }
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
      if (other instanceof service.AddAnimalRequest) {
        return mergeFrom((service.AddAnimalRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.AddAnimalRequest other) {
      if (other == service.AddAnimalRequest.getDefaultInstance()) return this;
      if (other.hasAnimal()) {
        mergeAnimal(other.getAnimal());
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
      service.AddAnimalRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.AddAnimalRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private service.Animal animal_;
    private com.google.protobuf.SingleFieldBuilderV3<
        service.Animal, service.Animal.Builder, service.AnimalOrBuilder> animalBuilder_;
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     * @return Whether the animal field is set.
     */
    public boolean hasAnimal() {
      return animalBuilder_ != null || animal_ != null;
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     * @return The animal.
     */
    public service.Animal getAnimal() {
      if (animalBuilder_ == null) {
        return animal_ == null ? service.Animal.getDefaultInstance() : animal_;
      } else {
        return animalBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    public Builder setAnimal(service.Animal value) {
      if (animalBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        animal_ = value;
        onChanged();
      } else {
        animalBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    public Builder setAnimal(
        service.Animal.Builder builderForValue) {
      if (animalBuilder_ == null) {
        animal_ = builderForValue.build();
        onChanged();
      } else {
        animalBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    public Builder mergeAnimal(service.Animal value) {
      if (animalBuilder_ == null) {
        if (animal_ != null) {
          animal_ =
            service.Animal.newBuilder(animal_).mergeFrom(value).buildPartial();
        } else {
          animal_ = value;
        }
        onChanged();
      } else {
        animalBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    public Builder clearAnimal() {
      if (animalBuilder_ == null) {
        animal_ = null;
        onChanged();
      } else {
        animal_ = null;
        animalBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    public service.Animal.Builder getAnimalBuilder() {
      
      onChanged();
      return getAnimalFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    public service.AnimalOrBuilder getAnimalOrBuilder() {
      if (animalBuilder_ != null) {
        return animalBuilder_.getMessageOrBuilder();
      } else {
        return animal_ == null ?
            service.Animal.getDefaultInstance() : animal_;
      }
    }
    /**
     * <pre>
     * Animal to add to the zoo
     * </pre>
     *
     * <code>.services.Animal animal = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        service.Animal, service.Animal.Builder, service.AnimalOrBuilder> 
        getAnimalFieldBuilder() {
      if (animalBuilder_ == null) {
        animalBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            service.Animal, service.Animal.Builder, service.AnimalOrBuilder>(
                getAnimal(),
                getParentForChildren(),
                isClean());
        animal_ = null;
      }
      return animalBuilder_;
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


    // @@protoc_insertion_point(builder_scope:services.AddAnimalRequest)
  }

  // @@protoc_insertion_point(class_scope:services.AddAnimalRequest)
  private static final service.AddAnimalRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.AddAnimalRequest();
  }

  public static service.AddAnimalRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddAnimalRequest>
      PARSER = new com.google.protobuf.AbstractParser<AddAnimalRequest>() {
    @java.lang.Override
    public AddAnimalRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AddAnimalRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddAnimalRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddAnimalRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.AddAnimalRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

