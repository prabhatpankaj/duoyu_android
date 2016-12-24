// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/model/model.proto at 97:1
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
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Notification extends Message<Notification, Notification.Builder> {
  public static final ProtoAdapter<Notification> ADAPTER = new ProtoAdapter_Notification();

  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_DATE = 0L;

  public static final String DEFAULT_WHICH = "";

  public static final Type DEFAULT_WHICH_TYPE = Type.DIARY;

  public static final Event DEFAULT_EVENT = Event.LIKE_MY_ARTICLE;

  public static final Boolean DEFAULT_UNREAD = false;

  public static final String DEFAULT_TITLE = "";

  @WireField(
      tag = 1,
      adapter = "online.duoyu.sparkle.model.proto.User#ADAPTER"
  )
  public final User user;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT64"
  )
  public final Long date;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String which;

  @WireField(
      tag = 4,
      adapter = "online.duoyu.sparkle.model.proto.Notification$Type#ADAPTER"
  )
  public final Type which_type;

  @WireField(
      tag = 5,
      adapter = "online.duoyu.sparkle.model.proto.Notification$Event#ADAPTER"
  )
  public final Event event;

  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean unread;

  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String title;

  public Notification(User user, Long date, String which, Type which_type, Event event, Boolean unread, String title) {
    this(user, date, which, which_type, event, unread, title, ByteString.EMPTY);
  }

  public Notification(User user, Long date, String which, Type which_type, Event event, Boolean unread, String title, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.user = user;
    this.date = date;
    this.which = which;
    this.which_type = which_type;
    this.event = event;
    this.unread = unread;
    this.title = title;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.user = user;
    builder.date = date;
    builder.which = which;
    builder.which_type = which_type;
    builder.event = event;
    builder.unread = unread;
    builder.title = title;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Notification)) return false;
    Notification o = (Notification) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(user, o.user)
        && Internal.equals(date, o.date)
        && Internal.equals(which, o.which)
        && Internal.equals(which_type, o.which_type)
        && Internal.equals(event, o.event)
        && Internal.equals(unread, o.unread)
        && Internal.equals(title, o.title);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (user != null ? user.hashCode() : 0);
      result = result * 37 + (date != null ? date.hashCode() : 0);
      result = result * 37 + (which != null ? which.hashCode() : 0);
      result = result * 37 + (which_type != null ? which_type.hashCode() : 0);
      result = result * 37 + (event != null ? event.hashCode() : 0);
      result = result * 37 + (unread != null ? unread.hashCode() : 0);
      result = result * 37 + (title != null ? title.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (user != null) builder.append(", user=").append(user);
    if (date != null) builder.append(", date=").append(date);
    if (which != null) builder.append(", which=").append(which);
    if (which_type != null) builder.append(", which_type=").append(which_type);
    if (event != null) builder.append(", event=").append(event);
    if (unread != null) builder.append(", unread=").append(unread);
    if (title != null) builder.append(", title=").append(title);
    return builder.replace(0, 2, "Notification{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Notification, Builder> {
    public User user;

    public Long date;

    public String which;

    public Type which_type;

    public Event event;

    public Boolean unread;

    public String title;

    public Builder() {
    }

    public Builder user(User user) {
      this.user = user;
      return this;
    }

    public Builder date(Long date) {
      this.date = date;
      return this;
    }

    public Builder which(String which) {
      this.which = which;
      return this;
    }

    public Builder which_type(Type which_type) {
      this.which_type = which_type;
      return this;
    }

    public Builder event(Event event) {
      this.event = event;
      return this;
    }

    public Builder unread(Boolean unread) {
      this.unread = unread;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    @Override
    public Notification build() {
      return new Notification(user, date, which, which_type, event, unread, title, super.buildUnknownFields());
    }
  }

  public enum Event implements WireEnum {
    LIKE_MY_ARTICLE(0),

    COMMENT_MY_ARTICLE(1),

    CORRECT_ATTENTION_DIARY(2),

    FOLLOW_ME(3),

    PUBLISH_DIARY(4);

    public static final ProtoAdapter<Event> ADAPTER = ProtoAdapter.newEnumAdapter(Event.class);

    private final int value;

    Event(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Event fromValue(int value) {
      switch (value) {
        case 0: return LIKE_MY_ARTICLE;
        case 1: return COMMENT_MY_ARTICLE;
        case 2: return CORRECT_ATTENTION_DIARY;
        case 3: return FOLLOW_ME;
        case 4: return PUBLISH_DIARY;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  public enum Type implements WireEnum {
    DIARY(0),

    CORRECT(1),

    COMMENT(2);

    public static final ProtoAdapter<Type> ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);

    private final int value;

    Type(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Type fromValue(int value) {
      switch (value) {
        case 0: return DIARY;
        case 1: return CORRECT;
        case 2: return COMMENT;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_Notification extends ProtoAdapter<Notification> {
    ProtoAdapter_Notification() {
      super(FieldEncoding.LENGTH_DELIMITED, Notification.class);
    }

    @Override
    public int encodedSize(Notification value) {
      return (value.user != null ? User.ADAPTER.encodedSizeWithTag(1, value.user) : 0)
          + (value.date != null ? ProtoAdapter.INT64.encodedSizeWithTag(2, value.date) : 0)
          + (value.which != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value.which) : 0)
          + (value.which_type != null ? Type.ADAPTER.encodedSizeWithTag(4, value.which_type) : 0)
          + (value.event != null ? Event.ADAPTER.encodedSizeWithTag(5, value.event) : 0)
          + (value.unread != null ? ProtoAdapter.BOOL.encodedSizeWithTag(6, value.unread) : 0)
          + (value.title != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, value.title) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Notification value) throws IOException {
      if (value.user != null) User.ADAPTER.encodeWithTag(writer, 1, value.user);
      if (value.date != null) ProtoAdapter.INT64.encodeWithTag(writer, 2, value.date);
      if (value.which != null) ProtoAdapter.STRING.encodeWithTag(writer, 3, value.which);
      if (value.which_type != null) Type.ADAPTER.encodeWithTag(writer, 4, value.which_type);
      if (value.event != null) Event.ADAPTER.encodeWithTag(writer, 5, value.event);
      if (value.unread != null) ProtoAdapter.BOOL.encodeWithTag(writer, 6, value.unread);
      if (value.title != null) ProtoAdapter.STRING.encodeWithTag(writer, 7, value.title);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Notification decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.user(User.ADAPTER.decode(reader)); break;
          case 2: builder.date(ProtoAdapter.INT64.decode(reader)); break;
          case 3: builder.which(ProtoAdapter.STRING.decode(reader)); break;
          case 4: {
            try {
              builder.which_type(Type.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 5: {
            try {
              builder.event(Event.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 6: builder.unread(ProtoAdapter.BOOL.decode(reader)); break;
          case 7: builder.title(ProtoAdapter.STRING.decode(reader)); break;
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
    public Notification redact(Notification value) {
      Builder builder = value.newBuilder();
      if (builder.user != null) builder.user = User.ADAPTER.redact(builder.user);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
