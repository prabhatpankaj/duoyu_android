// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/account.proto at 54:1
package online.duoyu.sparkle.model.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

import java.io.IOException;

import okio.ByteString;

public final class EmailVerifyRequest extends Message<EmailVerifyRequest, EmailVerifyRequest.Builder> {
  public static final ProtoAdapter<EmailVerifyRequest> ADAPTER = new ProtoAdapter_EmailVerifyRequest();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_EMAIL = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String email;

  public EmailVerifyRequest(String email) {
    this(email, ByteString.EMPTY);
  }

  public EmailVerifyRequest(String email, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.email = email;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.email = email;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof EmailVerifyRequest)) return false;
    EmailVerifyRequest o = (EmailVerifyRequest) other;
    return unknownFields().equals(o.unknownFields()) && Internal.equals(email, o.email);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (email != null ? email.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (email != null) builder.append(", email=").append(email);
    return builder.replace(0, 2, "EmailVerifyRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<EmailVerifyRequest, Builder> {
    public String email;

    public Builder() {
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    @Override
    public EmailVerifyRequest build() {
      return new EmailVerifyRequest(email, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_EmailVerifyRequest extends ProtoAdapter<EmailVerifyRequest> {
    ProtoAdapter_EmailVerifyRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, EmailVerifyRequest.class);
    }

    @Override
    public int encodedSize(EmailVerifyRequest value) {
      return (value.email != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.email) : 0) + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, EmailVerifyRequest value) throws IOException {
      if (value.email != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.email);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public EmailVerifyRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1; ) {
        switch (tag) {
          case 1:
            builder.email(ProtoAdapter.STRING.decode(reader));
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
    public EmailVerifyRequest redact(EmailVerifyRequest value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
