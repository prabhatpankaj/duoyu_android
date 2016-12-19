// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/common.proto at 11:1
package online.duoyu.sparkle.model.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Cursor extends Message<Cursor, Cursor.Builder> {
  public static final ProtoAdapter<Cursor> ADAPTER = new ProtoAdapter_Cursor();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_TIMESTAMP = 0;

  public static final Integer DEFAULT_OFFSET = 0;

  public static final Integer DEFAULT_PAGE = 0;

  public static final Integer DEFAULT_LIMIT = 0;

  public static final Boolean DEFAULT_HAS_MORE = false;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer timestamp;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer offset;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer page;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer limit;

  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean has_more;

  public Cursor(Integer timestamp, Integer offset, Integer page, Integer limit, Boolean has_more) {
    this(timestamp, offset, page, limit, has_more, ByteString.EMPTY);
  }

  public Cursor(Integer timestamp, Integer offset, Integer page, Integer limit, Boolean has_more, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.timestamp = timestamp;
    this.offset = offset;
    this.page = page;
    this.limit = limit;
    this.has_more = has_more;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.timestamp = timestamp;
    builder.offset = offset;
    builder.page = page;
    builder.limit = limit;
    builder.has_more = has_more;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Cursor)) return false;
    Cursor o = (Cursor) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(timestamp, o.timestamp)
        && Internal.equals(offset, o.offset)
        && Internal.equals(page, o.page)
        && Internal.equals(limit, o.limit)
        && Internal.equals(has_more, o.has_more);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (timestamp != null ? timestamp.hashCode() : 0);
      result = result * 37 + (offset != null ? offset.hashCode() : 0);
      result = result * 37 + (page != null ? page.hashCode() : 0);
      result = result * 37 + (limit != null ? limit.hashCode() : 0);
      result = result * 37 + (has_more != null ? has_more.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (timestamp != null) builder.append(", timestamp=").append(timestamp);
    if (offset != null) builder.append(", offset=").append(offset);
    if (page != null) builder.append(", page=").append(page);
    if (limit != null) builder.append(", limit=").append(limit);
    if (has_more != null) builder.append(", has_more=").append(has_more);
    return builder.replace(0, 2, "Cursor{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Cursor, Builder> {
    public Integer timestamp;

    public Integer offset;

    public Integer page;

    public Integer limit;

    public Boolean has_more;

    public Builder() {
    }

    public Builder timestamp(Integer timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder offset(Integer offset) {
      this.offset = offset;
      return this;
    }

    public Builder page(Integer page) {
      this.page = page;
      return this;
    }

    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

    public Builder has_more(Boolean has_more) {
      this.has_more = has_more;
      return this;
    }

    @Override
    public Cursor build() {
      return new Cursor(timestamp, offset, page, limit, has_more, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Cursor extends ProtoAdapter<Cursor> {
    ProtoAdapter_Cursor() {
      super(FieldEncoding.LENGTH_DELIMITED, Cursor.class);
    }

    @Override
    public int encodedSize(Cursor value) {
      return (value.timestamp != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, value.timestamp) : 0)
          + (value.offset != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, value.offset) : 0)
          + (value.page != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, value.page) : 0)
          + (value.limit != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, value.limit) : 0)
          + (value.has_more != null ? ProtoAdapter.BOOL.encodedSizeWithTag(5, value.has_more) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Cursor value) throws IOException {
      if (value.timestamp != null) ProtoAdapter.INT32.encodeWithTag(writer, 1, value.timestamp);
      if (value.offset != null) ProtoAdapter.INT32.encodeWithTag(writer, 2, value.offset);
      if (value.page != null) ProtoAdapter.INT32.encodeWithTag(writer, 3, value.page);
      if (value.limit != null) ProtoAdapter.INT32.encodeWithTag(writer, 4, value.limit);
      if (value.has_more != null) ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.has_more);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Cursor decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.timestamp(ProtoAdapter.INT32.decode(reader)); break;
          case 2: builder.offset(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.page(ProtoAdapter.INT32.decode(reader)); break;
          case 4: builder.limit(ProtoAdapter.INT32.decode(reader)); break;
          case 5: builder.has_more(ProtoAdapter.BOOL.decode(reader)); break;
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
    public Cursor redact(Cursor value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
