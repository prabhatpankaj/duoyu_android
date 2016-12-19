// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/correct.proto at 19:1
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

public final class GetCorrectsByDiaryIdRequest extends Message<GetCorrectsByDiaryIdRequest, GetCorrectsByDiaryIdRequest.Builder> {
  public static final ProtoAdapter<GetCorrectsByDiaryIdRequest> ADAPTER = new ProtoAdapter_GetCorrectsByDiaryIdRequest();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_DIARY_ID = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String diary_id;

  @WireField(
      tag = 2,
      adapter = "online.duoyu.sparkle.model.proto.Cursor#ADAPTER")
  public final Cursor cursor;

  public GetCorrectsByDiaryIdRequest(String diary_id, Cursor cursor) {
    this(diary_id, cursor, ByteString.EMPTY);
  }

  public GetCorrectsByDiaryIdRequest(String diary_id, Cursor cursor, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.diary_id = diary_id;
    this.cursor = cursor;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.diary_id = diary_id;
    builder.cursor = cursor;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof GetCorrectsByDiaryIdRequest)) return false;
    GetCorrectsByDiaryIdRequest o = (GetCorrectsByDiaryIdRequest) other;
    return unknownFields().equals(o.unknownFields()) && Internal.equals(diary_id, o.diary_id) && Internal.equals(cursor, o.cursor);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (diary_id != null ? diary_id.hashCode() : 0);
      result = result * 37 + (cursor != null ? cursor.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (diary_id != null) builder.append(", diary_id=").append(diary_id);
    if (cursor != null) builder.append(", cursor=").append(cursor);
    return builder.replace(0, 2, "GetCorrectsByDiaryIdRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<GetCorrectsByDiaryIdRequest, Builder> {
    public String diary_id;

    public Cursor cursor;

    public Builder() {
    }

    public Builder diary_id(String diary_id) {
      this.diary_id = diary_id;
      return this;
    }

    public Builder cursor(Cursor cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public GetCorrectsByDiaryIdRequest build() {
      return new GetCorrectsByDiaryIdRequest(diary_id, cursor, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_GetCorrectsByDiaryIdRequest extends ProtoAdapter<GetCorrectsByDiaryIdRequest> {
    ProtoAdapter_GetCorrectsByDiaryIdRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, GetCorrectsByDiaryIdRequest.class);
    }

    @Override
    public int encodedSize(GetCorrectsByDiaryIdRequest value) {
      return (value.diary_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.diary_id) : 0) + (value.cursor != null ? Cursor.ADAPTER.encodedSizeWithTag(2, value.cursor) : 0) + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, GetCorrectsByDiaryIdRequest value) throws IOException {
      if (value.diary_id != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.diary_id);
      if (value.cursor != null) Cursor.ADAPTER.encodeWithTag(writer, 2, value.cursor);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public GetCorrectsByDiaryIdRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1; ) {
        switch (tag) {
          case 1:
            builder.diary_id(ProtoAdapter.STRING.decode(reader));
            break;
          case 2:
            builder.cursor(Cursor.ADAPTER.decode(reader));
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
    public GetCorrectsByDiaryIdRequest redact(GetCorrectsByDiaryIdRequest value) {
      Builder builder = value.newBuilder();
      if (builder.cursor != null) builder.cursor = Cursor.ADAPTER.redact(builder.cursor);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}