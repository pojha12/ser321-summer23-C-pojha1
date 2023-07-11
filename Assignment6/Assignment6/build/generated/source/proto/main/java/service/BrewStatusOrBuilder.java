// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/coffeepot.proto

package service;

public interface BrewStatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.BrewStatus)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *Minutes remaining on brew
   * </pre>
   *
   * <code>int32 minutes = 1;</code>
   * @return The minutes.
   */
  int getMinutes();

  /**
   * <pre>
   *Seconds remaining on 
   * </pre>
   *
   * <code>int32 seconds = 2;</code>
   * @return The seconds.
   */
  int getSeconds();

  /**
   * <pre>
   *Message back to user such as pot is brewed, pot is brewing, x cups remaining... etc
   * </pre>
   *
   * <code>string message = 3;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <pre>
   *Message back to user such as pot is brewed, pot is brewing, x cups remaining... etc
   * </pre>
   *
   * <code>string message = 3;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
