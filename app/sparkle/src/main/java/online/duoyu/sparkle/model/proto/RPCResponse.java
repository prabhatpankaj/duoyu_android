// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/rpc.proto at 12:1
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
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class RPCResponse extends Message<RPCResponse, RPCResponse.Builder> {
  public static final ProtoAdapter<RPCResponse> ADAPTER = new ProtoAdapter_RPCResponse();

  private static final long serialVersionUID = 0L;

  public static final ByteString DEFAULT_SESSION_ID = ByteString.EMPTY;

  public static final Boolean DEFAULT_SUCCESS = false;

  public static final Reason DEFAULT_REASON = Reason.OK;

  public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#BYTES"
  )
  public final ByteString session_id;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean success;

  @WireField(
      tag = 3,
      adapter = "online.duoyu.sparkle.model.proto.RPCResponse$Reason#ADAPTER"
  )
  public final Reason reason;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#BYTES"
  )
  public final ByteString content;

  public RPCResponse(ByteString session_id, Boolean success, Reason reason, ByteString content) {
    this(session_id, success, reason, content, ByteString.EMPTY);
  }

  public RPCResponse(ByteString session_id, Boolean success, Reason reason, ByteString content, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.session_id = session_id;
    this.success = success;
    this.reason = reason;
    this.content = content;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.session_id = session_id;
    builder.success = success;
    builder.reason = reason;
    builder.content = content;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof RPCResponse)) return false;
    RPCResponse o = (RPCResponse) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(session_id, o.session_id)
        && Internal.equals(success, o.success)
        && Internal.equals(reason, o.reason)
        && Internal.equals(content, o.content);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (session_id != null ? session_id.hashCode() : 0);
      result = result * 37 + (success != null ? success.hashCode() : 0);
      result = result * 37 + (reason != null ? reason.hashCode() : 0);
      result = result * 37 + (content != null ? content.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (session_id != null) builder.append(", session_id=").append(session_id);
    if (success != null) builder.append(", success=").append(success);
    if (reason != null) builder.append(", reason=").append(reason);
    if (content != null) builder.append(", content=").append(content);
    return builder.replace(0, 2, "RPCResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<RPCResponse, Builder> {
    public ByteString session_id;

    public Boolean success;

    public Reason reason;

    public ByteString content;

    public Builder() {
    }

    public Builder session_id(ByteString session_id) {
      this.session_id = session_id;
      return this;
    }

    public Builder success(Boolean success) {
      this.success = success;
      return this;
    }

    public Builder reason(Reason reason) {
      this.reason = reason;
      return this;
    }

    public Builder content(ByteString content) {
      this.content = content;
      return this;
    }

    @Override
    public RPCResponse build() {
      return new RPCResponse(session_id, success, reason, content, super.buildUnknownFields());
    }
  }

  public enum Reason implements WireEnum {
    OK(0),

    BAD_REQUEST(10);

    public static final ProtoAdapter<Reason> ADAPTER = ProtoAdapter.newEnumAdapter(Reason.class);

    private final int value;

    Reason(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Reason fromValue(int value) {
      switch (value) {
        case 0: return OK;
        case 10: return BAD_REQUEST;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_RPCResponse extends ProtoAdapter<RPCResponse> {
    ProtoAdapter_RPCResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, RPCResponse.class);
    }

    @Override
    public int encodedSize(RPCResponse value) {
      return (value.session_id != null ? ProtoAdapter.BYTES.encodedSizeWithTag(1, value.session_id) : 0)
          + (value.success != null ? ProtoAdapter.BOOL.encodedSizeWithTag(2, value.success) : 0)
          + (value.reason != null ? Reason.ADAPTER.encodedSizeWithTag(3, value.reason) : 0)
          + (value.content != null ? ProtoAdapter.BYTES.encodedSizeWithTag(4, value.content) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, RPCResponse value) throws IOException {
      if (value.session_id != null) ProtoAdapter.BYTES.encodeWithTag(writer, 1, value.session_id);
      if (value.success != null) ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.success);
      if (value.reason != null) Reason.ADAPTER.encodeWithTag(writer, 3, value.reason);
      if (value.content != null) ProtoAdapter.BYTES.encodeWithTag(writer, 4, value.content);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public RPCResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.session_id(ProtoAdapter.BYTES.decode(reader)); break;
          case 2: builder.success(ProtoAdapter.BOOL.decode(reader)); break;
          case 3: {
            try {
              builder.reason(Reason.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 4: builder.content(ProtoAdapter.BYTES.decode(reader)); break;
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
    public RPCResponse redact(RPCResponse value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
