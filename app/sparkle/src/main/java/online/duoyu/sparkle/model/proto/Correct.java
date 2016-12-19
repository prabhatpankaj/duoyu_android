// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/model/model.proto at 60:1
package online.duoyu.sparkle.model.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Correct extends Message<Correct, Correct.Builder> {
  public static final ProtoAdapter<Correct> ADAPTER = new ProtoAdapter_Correct();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_CORRECT_ID = "";

  public static final String DEFAULT_CONTENT = "";

  public static final Integer DEFAULT_DATE = 0;

  public static final Integer DEFAULT_LAST_EDIT_DATE = 0;

  public static final Integer DEFAULT_LIKES = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String correct_id;

  @WireField(
      tag = 2,
      adapter = "online.duoyu.sparkle.model.proto.User#ADAPTER"
  )
  public final User author;

  @WireField(
      tag = 3,
      adapter = "online.duoyu.sparkle.model.proto.Diary#ADAPTER"
  )
  public final Diary diary;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String content;

  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer date;

  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer last_edit_date;

  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer likes;

  public Correct(String correct_id, User author, Diary diary, String content, Integer date, Integer last_edit_date, Integer likes) {
    this(correct_id, author, diary, content, date, last_edit_date, likes, ByteString.EMPTY);
  }

  public Correct(String correct_id, User author, Diary diary, String content, Integer date, Integer last_edit_date, Integer likes, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.correct_id = correct_id;
    this.author = author;
    this.diary = diary;
    this.content = content;
    this.date = date;
    this.last_edit_date = last_edit_date;
    this.likes = likes;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.correct_id = correct_id;
    builder.author = author;
    builder.diary = diary;
    builder.content = content;
    builder.date = date;
    builder.last_edit_date = last_edit_date;
    builder.likes = likes;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Correct)) return false;
    Correct o = (Correct) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(correct_id, o.correct_id)
        && Internal.equals(author, o.author)
        && Internal.equals(diary, o.diary)
        && Internal.equals(content, o.content)
        && Internal.equals(date, o.date)
        && Internal.equals(last_edit_date, o.last_edit_date)
        && Internal.equals(likes, o.likes);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (correct_id != null ? correct_id.hashCode() : 0);
      result = result * 37 + (author != null ? author.hashCode() : 0);
      result = result * 37 + (diary != null ? diary.hashCode() : 0);
      result = result * 37 + (content != null ? content.hashCode() : 0);
      result = result * 37 + (date != null ? date.hashCode() : 0);
      result = result * 37 + (last_edit_date != null ? last_edit_date.hashCode() : 0);
      result = result * 37 + (likes != null ? likes.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (correct_id != null) builder.append(", correct_id=").append(correct_id);
    if (author != null) builder.append(", author=").append(author);
    if (diary != null) builder.append(", diary=").append(diary);
    if (content != null) builder.append(", content=").append(content);
    if (date != null) builder.append(", date=").append(date);
    if (last_edit_date != null) builder.append(", last_edit_date=").append(last_edit_date);
    if (likes != null) builder.append(", likes=").append(likes);
    return builder.replace(0, 2, "Correct{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Correct, Builder> {
    public String correct_id;

    public User author;

    public Diary diary;

    public String content;

    public Integer date;

    public Integer last_edit_date;

    public Integer likes;

    public Builder() {
    }

    public Builder correct_id(String correct_id) {
      this.correct_id = correct_id;
      return this;
    }

    public Builder author(User author) {
      this.author = author;
      return this;
    }

    public Builder diary(Diary diary) {
      this.diary = diary;
      return this;
    }

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Builder date(Integer date) {
      this.date = date;
      return this;
    }

    public Builder last_edit_date(Integer last_edit_date) {
      this.last_edit_date = last_edit_date;
      return this;
    }

    public Builder likes(Integer likes) {
      this.likes = likes;
      return this;
    }

    @Override
    public Correct build() {
      return new Correct(correct_id, author, diary, content, date, last_edit_date, likes, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Correct extends ProtoAdapter<Correct> {
    ProtoAdapter_Correct() {
      super(FieldEncoding.LENGTH_DELIMITED, Correct.class);
    }

    @Override
    public int encodedSize(Correct value) {
      return (value.correct_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.correct_id) : 0)
          + (value.author != null ? User.ADAPTER.encodedSizeWithTag(2, value.author) : 0)
          + (value.diary != null ? Diary.ADAPTER.encodedSizeWithTag(3, value.diary) : 0)
          + (value.content != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value.content) : 0)
          + (value.date != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, value.date) : 0)
          + (value.last_edit_date != null ? ProtoAdapter.INT32.encodedSizeWithTag(6, value.last_edit_date) : 0)
          + (value.likes != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, value.likes) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Correct value) throws IOException {
      if (value.correct_id != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.correct_id);
      if (value.author != null) User.ADAPTER.encodeWithTag(writer, 2, value.author);
      if (value.diary != null) Diary.ADAPTER.encodeWithTag(writer, 3, value.diary);
      if (value.content != null) ProtoAdapter.STRING.encodeWithTag(writer, 4, value.content);
      if (value.date != null) ProtoAdapter.INT32.encodeWithTag(writer, 5, value.date);
      if (value.last_edit_date != null) ProtoAdapter.INT32.encodeWithTag(writer, 6, value.last_edit_date);
      if (value.likes != null) ProtoAdapter.INT32.encodeWithTag(writer, 7, value.likes);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Correct decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.correct_id(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.author(User.ADAPTER.decode(reader)); break;
          case 3: builder.diary(Diary.ADAPTER.decode(reader)); break;
          case 4: builder.content(ProtoAdapter.STRING.decode(reader)); break;
          case 5: builder.date(ProtoAdapter.INT32.decode(reader)); break;
          case 6: builder.last_edit_date(ProtoAdapter.INT32.decode(reader)); break;
          case 7: builder.likes(ProtoAdapter.INT32.decode(reader)); break;
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
    public Correct redact(Correct value) {
      Builder builder = value.newBuilder();
      if (builder.author != null) builder.author = User.ADAPTER.redact(builder.author);
      if (builder.diary != null) builder.diary = Diary.ADAPTER.redact(builder.diary);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
