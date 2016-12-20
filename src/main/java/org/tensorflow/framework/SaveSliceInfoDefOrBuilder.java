// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/framework/variable.proto

package org.tensorflow.framework;

public interface SaveSliceInfoDefOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.SaveSliceInfoDef)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Name of the full variable of which this is a slice.
   * </pre>
   *
   * <code>optional string full_name = 1;</code>
   */
  java.lang.String getFullName();
  /**
   * <pre>
   * Name of the full variable of which this is a slice.
   * </pre>
   *
   * <code>optional string full_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getFullNameBytes();

  /**
   * <pre>
   * Shape of the full variable.
   * </pre>
   *
   * <code>repeated int64 full_shape = 2;</code>
   */
  java.util.List<java.lang.Long> getFullShapeList();
  /**
   * <pre>
   * Shape of the full variable.
   * </pre>
   *
   * <code>repeated int64 full_shape = 2;</code>
   */
  int getFullShapeCount();
  /**
   * <pre>
   * Shape of the full variable.
   * </pre>
   *
   * <code>repeated int64 full_shape = 2;</code>
   */
  long getFullShape(int index);

  /**
   * <pre>
   * Offset of this variable into the full variable.
   * </pre>
   *
   * <code>repeated int64 var_offset = 3;</code>
   */
  java.util.List<java.lang.Long> getVarOffsetList();
  /**
   * <pre>
   * Offset of this variable into the full variable.
   * </pre>
   *
   * <code>repeated int64 var_offset = 3;</code>
   */
  int getVarOffsetCount();
  /**
   * <pre>
   * Offset of this variable into the full variable.
   * </pre>
   *
   * <code>repeated int64 var_offset = 3;</code>
   */
  long getVarOffset(int index);

  /**
   * <pre>
   * Shape of this variable.
   * </pre>
   *
   * <code>repeated int64 var_shape = 4;</code>
   */
  java.util.List<java.lang.Long> getVarShapeList();
  /**
   * <pre>
   * Shape of this variable.
   * </pre>
   *
   * <code>repeated int64 var_shape = 4;</code>
   */
  int getVarShapeCount();
  /**
   * <pre>
   * Shape of this variable.
   * </pre>
   *
   * <code>repeated int64 var_shape = 4;</code>
   */
  long getVarShape(int index);
}
