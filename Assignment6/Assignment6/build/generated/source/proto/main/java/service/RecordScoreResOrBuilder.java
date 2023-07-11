// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/golf.proto

package service;

public interface RecordScoreResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.RecordScoreRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  boolean getIsSuccess();

  /**
   * <pre>
   * Example "You set the new course record | You didn't set the course record"
   * </pre>
   *
   * <code>string message = 3;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <pre>
   * Example "You set the new course record | You didn't set the course record"
   * </pre>
   *
   * <code>string message = 3;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <pre>
   * Error message, a String of your choice to show what went wrong if an error occurred isSuccess would then be false
   * </pre>
   *
   * <code>string error = 5;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <pre>
   * Error message, a String of your choice to show what went wrong if an error occurred isSuccess would then be false
   * </pre>
   *
   * <code>string error = 5;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}
