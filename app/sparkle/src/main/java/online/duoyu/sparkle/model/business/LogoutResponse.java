// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/account.proto at 28:1
package online.duoyu.sparkle.model.business;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class LogoutResponse extends Message<LogoutResponse, LogoutResponse.Builder> {
  public static final ProtoAdapter<LogoutResponse> ADAPTER = new ProtoAdapter_LogoutResponse();

  private static final long serialVersionUID = 0L;

  public LogoutResponse() {
    this(ByteString.EMPTY);
  }

  public LogoutResponse(ByteString unknownFields) {
    super(ADAPTER, unknownFields);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof LogoutResponse;
  }

  @Override
  public int hashCode() {
    return unknownFields().hashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    return builder.replace(0, 2, "LogoutResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<LogoutResponse, Builder> {
    public Builder() {
    }

    @Override
    public LogoutResponse build() {
      return new LogoutResponse(super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_LogoutResponse extends ProtoAdapter<LogoutResponse> {
    ProtoAdapter_LogoutResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, LogoutResponse.class);
    }

    @Override
    public int encodedSize(LogoutResponse value) {
      return value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, LogoutResponse value) throws IOException {
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public LogoutResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
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
    public LogoutResponse redact(LogoutResponse value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
