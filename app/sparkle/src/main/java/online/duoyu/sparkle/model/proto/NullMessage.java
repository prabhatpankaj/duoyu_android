// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/common.proto at 19:1
package online.duoyu.sparkle.model.proto;

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

public final class NullMessage extends Message<NullMessage, NullMessage.Builder> {
  public static final ProtoAdapter<NullMessage> ADAPTER = new ProtoAdapter_NullMessage();

  private static final long serialVersionUID = 0L;

  public NullMessage() {
    this(ByteString.EMPTY);
  }

  public NullMessage(ByteString unknownFields) {
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
    return other instanceof NullMessage;
  }

  @Override
  public int hashCode() {
    return unknownFields().hashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    return builder.replace(0, 2, "NullMessage{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<NullMessage, Builder> {
    public Builder() {
    }

    @Override
    public NullMessage build() {
      return new NullMessage(super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_NullMessage extends ProtoAdapter<NullMessage> {
    ProtoAdapter_NullMessage() {
      super(FieldEncoding.LENGTH_DELIMITED, NullMessage.class);
    }

    @Override
    public int encodedSize(NullMessage value) {
      return value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, NullMessage value) throws IOException {
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public NullMessage decode(ProtoReader reader) throws IOException {
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
    public NullMessage redact(NullMessage value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
