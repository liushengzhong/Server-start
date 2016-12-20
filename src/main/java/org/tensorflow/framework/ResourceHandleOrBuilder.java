// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/framework/resource_handle.proto

package org.tensorflow.framework;

public interface ResourceHandleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.ResourceHandle)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Unique name for the device containing the resource.
   * </pre>
   *
   * <code>optional string device = 1;</code>
   */
  java.lang.String getDevice();
  /**
   * <pre>
   * Unique name for the device containing the resource.
   * </pre>
   *
   * <code>optional string device = 1;</code>
   */
  com.google.protobuf.ByteString
      getDeviceBytes();

  /**
   * <pre>
   * Container in which this resource is placed.
   * </pre>
   *
   * <code>optional string container = 2;</code>
   */
  java.lang.String getContainer();
  /**
   * <pre>
   * Container in which this resource is placed.
   * </pre>
   *
   * <code>optional string container = 2;</code>
   */
  com.google.protobuf.ByteString
      getContainerBytes();

  /**
   * <pre>
   * Unique name of this resource.
   * </pre>
   *
   * <code>optional string name = 3;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * Unique name of this resource.
   * </pre>
   *
   * <code>optional string name = 3;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * Hash code for the type of the resource. Is only valid in the same device
   * and in the same execution.
   * </pre>
   *
   * <code>optional uint64 hash_code = 4;</code>
   */
  long getHashCode();

  /**
   * <pre>
   * For debug-only, the name of the type pointed to by this handle, if
   * available.
   * </pre>
   *
   * <code>optional string maybe_type_name = 5;</code>
   */
  java.lang.String getMaybeTypeName();
  /**
   * <pre>
   * For debug-only, the name of the type pointed to by this handle, if
   * available.
   * </pre>
   *
   * <code>optional string maybe_type_name = 5;</code>
   */
  com.google.protobuf.ByteString
      getMaybeTypeNameBytes();
}
