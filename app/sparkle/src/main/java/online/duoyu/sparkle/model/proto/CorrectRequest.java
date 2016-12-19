// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/correct.proto at 29:1
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

public final class CorrectRequest extends Message<CorrectRequest, CorrectRequest.Builder> {
  public static final ProtoAdapter<CorrectRequest> ADAPTER = new ProtoAdapter_CorrectRequest();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "online.duoyu.sparkle.model.proto.Correct#ADAPTER")
  public final Correct correct;

  public CorrectRequest(Correct correct) {
    this(correct, ByteString.EMPTY);
  }

  public CorrectRequest(Correct correct, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.correct = correct;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.correct = correct;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof CorrectRequest)) return false;
    CorrectRequest o = (CorrectRequest) other;
    return unknownFields().equals(o.unknownFields()) && Internal.equals(correct, o.correct);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (correct != null ? correct.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (correct != null) builder.append(", correct=").append(correct);
    return builder.replace(0, 2, "CorrectRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<CorrectRequest, Builder> {
    public Correct correct;

    public Builder() {
    }

    public Builder correct(Correct correct) {
      this.correct = correct;
      return this;
    }

    @Override
    public CorrectRequest build() {
      return new CorrectRequest(correct, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_CorrectRequest extends ProtoAdapter<CorrectRequest> {
    ProtoAdapter_CorrectRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, CorrectRequest.class);
    }

    @Override
    public int encodedSize(CorrectRequest value) {
      return (value.correct != null ? Correct.ADAPTER.encodedSizeWithTag(1, value.correct) : 0) + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, CorrectRequest value) throws IOException {
      if (value.correct != null) Correct.ADAPTER.encodeWithTag(writer, 1, value.correct);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public CorrectRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1; ) {
        switch (tag) {
          case 1:
            builder.correct(Correct.ADAPTER.decode(reader));
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
    public CorrectRequest redact(CorrectRequest value) {
      Builder builder = value.newBuilder();
      if (builder.correct != null) builder.correct = Correct.ADAPTER.redact(builder.correct);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}