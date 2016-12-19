// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/comment.proto at 29:1
package online.duoyu.sparkle.model.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

import java.io.IOException;

import okio.ByteString;

public final class CommentResponse extends Message<CommentResponse, CommentResponse.Builder> {
  public static final ProtoAdapter<CommentResponse> ADAPTER = new ProtoAdapter_CommentResponse();

  private static final long serialVersionUID = 0L;

  public static final Boolean DEFAULT_SUCCESS = false;

  public static final Errno DEFAULT_ERRNO = Errno.NOT_FOUND_COMMENT;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL")
  public final Boolean success;

  @WireField(
      tag = 2,
      adapter = "online.duoyu.sparkle.model.proto.CommentResponse$Errno#ADAPTER")
  public final Errno errno;

  @WireField(
      tag = 3,
      adapter = "online.duoyu.sparkle.model.proto.Comment#ADAPTER")
  public final Comment comment;

  public CommentResponse(Boolean success, Errno errno, Comment comment) {
    this(success, errno, comment, ByteString.EMPTY);
  }

  public CommentResponse(Boolean success, Errno errno, Comment comment, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.success = success;
    this.errno = errno;
    this.comment = comment;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.success = success;
    builder.errno = errno;
    builder.comment = comment;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof CommentResponse)) return false;
    CommentResponse o = (CommentResponse) other;
    return unknownFields().equals(o.unknownFields()) && Internal.equals(success, o.success) && Internal.equals(errno, o.errno) && Internal.equals(comment, o.comment);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (success != null ? success.hashCode() : 0);
      result = result * 37 + (errno != null ? errno.hashCode() : 0);
      result = result * 37 + (comment != null ? comment.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (success != null) builder.append(", success=").append(success);
    if (errno != null) builder.append(", errno=").append(errno);
    if (comment != null) builder.append(", comment=").append(comment);
    return builder.replace(0, 2, "CommentResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<CommentResponse, Builder> {
    public Boolean success;

    public Errno errno;

    public Comment comment;

    public Builder() {
    }

    public Builder success(Boolean success) {
      this.success = success;
      return this;
    }

    public Builder errno(Errno errno) {
      this.errno = errno;
      return this;
    }

    public Builder comment(Comment comment) {
      this.comment = comment;
      return this;
    }

    @Override
    public CommentResponse build() {
      return new CommentResponse(success, errno, comment, super.buildUnknownFields());
    }
  }

  public enum Errno implements WireEnum {
    NOT_FOUND_COMMENT(0),

    NOT_FOUND_QUOTE(1),

    NOT_FOUND_ENTIRE(2),

    INVALID_INFO(3);

    public static final ProtoAdapter<Errno> ADAPTER = ProtoAdapter.newEnumAdapter(Errno.class);

    private final int value;

    Errno(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Errno fromValue(int value) {
      switch (value) {
        case 0:
          return NOT_FOUND_COMMENT;
        case 1:
          return NOT_FOUND_QUOTE;
        case 2:
          return NOT_FOUND_ENTIRE;
        case 3:
          return INVALID_INFO;
        default:
          return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_CommentResponse extends ProtoAdapter<CommentResponse> {
    ProtoAdapter_CommentResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, CommentResponse.class);
    }

    @Override
    public int encodedSize(CommentResponse value) {
      return (value.success != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, value.success) : 0) + (value.errno != null ? Errno.ADAPTER.encodedSizeWithTag(2, value.errno) : 0) + (value.comment != null ? Comment.ADAPTER.encodedSizeWithTag(3, value.comment) : 0) + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, CommentResponse value) throws IOException {
      if (value.success != null) ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.success);
      if (value.errno != null) Errno.ADAPTER.encodeWithTag(writer, 2, value.errno);
      if (value.comment != null) Comment.ADAPTER.encodeWithTag(writer, 3, value.comment);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public CommentResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1; ) {
        switch (tag) {
          case 1:
            builder.success(ProtoAdapter.BOOL.decode(reader));
            break;
          case 2: {
            try {
              builder.errno(Errno.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 3:
            builder.comment(Comment.ADAPTER.decode(reader));
            break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public CommentResponse redact(CommentResponse value) {
      Builder builder = value.newBuilder();
      if (builder.comment != null) builder.comment = Comment.ADAPTER.redact(builder.comment);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
