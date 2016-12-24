// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/diary.proto at 36:1
package online.duoyu.sparkle.model.business;

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
import online.duoyu.sparkle.model.proto.Diary;

public final class DiaryResponse extends Message<DiaryResponse, DiaryResponse.Builder> {
  public static final ProtoAdapter<DiaryResponse> ADAPTER = new ProtoAdapter_DiaryResponse();

  private static final long serialVersionUID = 0L;

  public static final Boolean DEFAULT_SUCCESS = false;

  public static final Errno DEFAULT_ERRNO = Errno.NOT_FOUND_DIARY;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean success;

  @WireField(
      tag = 2,
      adapter = "online.duoyu.sparkle.model.business.DiaryResponse$Errno#ADAPTER"
  )
  public final Errno errno;

  @WireField(
      tag = 3,
      adapter = "online.duoyu.sparkle.model.proto.Diary#ADAPTER"
  )
  public final Diary diary;

  public DiaryResponse(Boolean success, Errno errno, Diary diary) {
    this(success, errno, diary, ByteString.EMPTY);
  }

  public DiaryResponse(Boolean success, Errno errno, Diary diary, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.success = success;
    this.errno = errno;
    this.diary = diary;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.success = success;
    builder.errno = errno;
    builder.diary = diary;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof DiaryResponse)) return false;
    DiaryResponse o = (DiaryResponse) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(success, o.success)
        && Internal.equals(errno, o.errno)
        && Internal.equals(diary, o.diary);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (success != null ? success.hashCode() : 0);
      result = result * 37 + (errno != null ? errno.hashCode() : 0);
      result = result * 37 + (diary != null ? diary.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (success != null) builder.append(", success=").append(success);
    if (errno != null) builder.append(", errno=").append(errno);
    if (diary != null) builder.append(", diary=").append(diary);
    return builder.replace(0, 2, "DiaryResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<DiaryResponse, Builder> {
    public Boolean success;

    public Errno errno;

    public Diary diary;

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

    public Builder diary(Diary diary) {
      this.diary = diary;
      return this;
    }

    @Override
    public DiaryResponse build() {
      return new DiaryResponse(success, errno, diary, super.buildUnknownFields());
    }
  }

  public enum Errno implements WireEnum {
    NOT_FOUND_DIARY(0),

    INVALID_INFO(1);

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
        case 0: return NOT_FOUND_DIARY;
        case 1: return INVALID_INFO;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_DiaryResponse extends ProtoAdapter<DiaryResponse> {
    ProtoAdapter_DiaryResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, DiaryResponse.class);
    }

    @Override
    public int encodedSize(DiaryResponse value) {
      return (value.success != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, value.success) : 0)
          + (value.errno != null ? Errno.ADAPTER.encodedSizeWithTag(2, value.errno) : 0)
          + (value.diary != null ? Diary.ADAPTER.encodedSizeWithTag(3, value.diary) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, DiaryResponse value) throws IOException {
      if (value.success != null) ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.success);
      if (value.errno != null) Errno.ADAPTER.encodeWithTag(writer, 2, value.errno);
      if (value.diary != null) Diary.ADAPTER.encodeWithTag(writer, 3, value.diary);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public DiaryResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.success(ProtoAdapter.BOOL.decode(reader)); break;
          case 2: {
            try {
              builder.errno(Errno.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 3: builder.diary(Diary.ADAPTER.decode(reader)); break;
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
    public DiaryResponse redact(DiaryResponse value) {
      Builder builder = value.newBuilder();
      if (builder.diary != null) builder.diary = Diary.ADAPTER.redact(builder.diary);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
