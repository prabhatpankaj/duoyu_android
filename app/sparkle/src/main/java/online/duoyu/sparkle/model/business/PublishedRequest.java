// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/diary.proto at 18:1
package online.duoyu.sparkle.model.business;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;
import online.duoyu.sparkle.model.proto.Cursor;

public final class PublishedRequest extends Message<PublishedRequest, PublishedRequest.Builder> {
  public static final ProtoAdapter<PublishedRequest> ADAPTER = new ProtoAdapter_PublishedRequest();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "online.duoyu.sparkle.model.proto.Cursor#ADAPTER"
  )
  public final Cursor cursor;

  public PublishedRequest(Cursor cursor) {
    this(cursor, ByteString.EMPTY);
  }

  public PublishedRequest(Cursor cursor, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.cursor = cursor;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.cursor = cursor;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PublishedRequest)) return false;
    PublishedRequest o = (PublishedRequest) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(cursor, o.cursor);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (cursor != null ? cursor.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (cursor != null) builder.append(", cursor=").append(cursor);
    return builder.replace(0, 2, "PublishedRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<PublishedRequest, Builder> {
    public Cursor cursor;

    public Builder() {
    }

    public Builder cursor(Cursor cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public PublishedRequest build() {
      return new PublishedRequest(cursor, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_PublishedRequest extends ProtoAdapter<PublishedRequest> {
    ProtoAdapter_PublishedRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, PublishedRequest.class);
    }

    @Override
    public int encodedSize(PublishedRequest value) {
      return (value.cursor != null ? Cursor.ADAPTER.encodedSizeWithTag(1, value.cursor) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, PublishedRequest value) throws IOException {
      if (value.cursor != null) Cursor.ADAPTER.encodeWithTag(writer, 1, value.cursor);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public PublishedRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.cursor(Cursor.ADAPTER.decode(reader)); break;
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
    public PublishedRequest redact(PublishedRequest value) {
      Builder builder = value.newBuilder();
      if (builder.cursor != null) builder.cursor = Cursor.ADAPTER.redact(builder.cursor);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
