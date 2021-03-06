// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/model.proto at 8:1
package online.duoyu.sparkle.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import java.util.Map;

import okio.ByteString;
import online.duoyu.sparkle.model.proto.Action;
import online.duoyu.sparkle.model.proto.Comment;
import online.duoyu.sparkle.model.proto.Correct;
import online.duoyu.sparkle.model.proto.Count;
import online.duoyu.sparkle.model.proto.Diary;
import online.duoyu.sparkle.model.proto.Flag;
import online.duoyu.sparkle.model.proto.Happening;
import online.duoyu.sparkle.model.proto.Notification;
import online.duoyu.sparkle.model.proto.User;

public final class Model extends Message<Model, Model.Builder> implements Parcelable {
  public static final ProtoAdapter<Model> ADAPTER = new ProtoAdapter_Model();

  public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
    @Override
    public Model createFromParcel(Parcel source) {
      try {
        return Model.ADAPTER.decode(source.createByteArray());
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

    @Override
    public Model[] newArray(int size) {
      return new Model[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeByteArray(encode());
  }

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_IDENTITY = "";

  public static final String DEFAULT_TOKEN = "";

  public static final Type DEFAULT_TYPE = Type.NONE;

  public static final Template DEFAULT_TEMPLATE = Template.UNSUPPORTED;

  public static final String DEFAULT_TITLE = "";

  public static final String DEFAULT_SUBTITLE = "";

  public static final String DEFAULT_LANGUAGE = "";

  public static final String DEFAULT_DESCRIPTION = "";

  public static final String DEFAULT_URL = "";

  public static final String DEFAULT_COVER = "";

  public static final Long DEFAULT_DATE = 0L;

  public static final String DEFAULT_MONTH = "";

  public static final String DEFAULT_DAY = "";

  public static final String DEFAULT_WEEK = "";

  public static final String DEFAULT_EMAIL = "";

  public static final String DEFAULT_CORRECT_SENTENCE = "";

  public static final String DEFAULT_ORIGIN_SENTENCE = "";

  public static final Integer DEFAULT_EVENT = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String identity;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String token;

  @WireField(
      tag = 3,
      adapter = "online.duoyu.sparkle.model.proto.Model$Type#ADAPTER"
  )
  public final Type type;

  @WireField(
      tag = 4,
      adapter = "online.duoyu.sparkle.model.proto.Model$Template#ADAPTER"
  )
  public final Template template;

  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String title;

  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String subtitle;

  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String language;

  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String description;

  @WireField(
      tag = 9,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String url;

  @WireField(
      tag = 10,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String cover;

  @WireField(
      tag = 11,
      adapter = "com.squareup.wire.ProtoAdapter#INT64"
  )
  public final Long date;

  @WireField(
      tag = 12,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String month;

  @WireField(
      tag = 13,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String day;

  @WireField(
      tag = 14,
      adapter = "online.duoyu.sparkle.model.proto.User#ADAPTER"
  )
  public final User user;

  @WireField(
      tag = 15,
      adapter = "online.duoyu.sparkle.model.proto.Comment#ADAPTER"
  )
  public final Comment comment;

  @WireField(
      tag = 16,
      adapter = "online.duoyu.sparkle.model.proto.Diary#ADAPTER"
  )
  public final Diary diary;

  @WireField(
      tag = 17,
      adapter = "online.duoyu.sparkle.model.proto.Correct#ADAPTER"
  )
  public final Correct correct;

  @WireField(
      tag = 18,
      adapter = "online.duoyu.sparkle.model.proto.Happening#ADAPTER"
  )
  public final Happening happening;

  @WireField(
      tag = 19,
      adapter = "online.duoyu.sparkle.model.proto.Notification#ADAPTER"
  )
  public final Notification notification;

  @WireField(
      tag = 20,
      adapter = "online.duoyu.sparkle.model.proto.Model#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Model> subModels;

  @WireField(
      tag = 21,
      adapter = "online.duoyu.sparkle.model.proto.Model#ADAPTER"
  )
  public final Model addition;

  @WireField(
      tag = 22,
      keyAdapter = "com.squareup.wire.ProtoAdapter#INT32",
      adapter = "online.duoyu.sparkle.model.proto.Action#ADAPTER"
  )
  public final Map<Integer, Action> actions;

  @WireField(
      tag = 23,
      adapter = "online.duoyu.sparkle.model.proto.Flag#ADAPTER"
  )
  public final Flag flag;

  @WireField(
      tag = 24,
      adapter = "online.duoyu.sparkle.model.proto.Count#ADAPTER"
  )
  public final Count count;

  @WireField(
      tag = 25,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String week;

  @WireField(
      tag = 26,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String email;

  @WireField(
      tag = 27,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REPEATED
  )
  public final List<String> content;

  @WireField(
      tag = 28,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String correct_sentence;

  @WireField(
      tag = 29,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String origin_sentence;

  @WireField(
      tag = 30,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer event;

  public Model(String identity, String token, Type type, Template template, String title, String subtitle, String language, String description, String url, String cover, Long date, String month, String day, User user, Comment comment, Diary diary, Correct correct, Happening happening, Notification notification, List<Model> subModels, Model addition, Map<Integer, Action> actions, Flag flag, Count count, String week, String email, List<String> content, String correct_sentence, String origin_sentence, Integer event) {
    this(identity, token, type, template, title, subtitle, language, description, url, cover, date, month, day, user, comment, diary, correct, happening, notification, subModels, addition, actions, flag, count, week, email, content, correct_sentence, origin_sentence, event, ByteString.EMPTY);
  }

  public Model(String identity, String token, Type type, Template template, String title, String subtitle, String language, String description, String url, String cover, Long date, String month, String day, User user, Comment comment, Diary diary, Correct correct, Happening happening, Notification notification, List<Model> subModels, Model addition, Map<Integer, Action> actions, Flag flag, Count count, String week, String email, List<String> content, String correct_sentence, String origin_sentence, Integer event, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.identity = identity;
    this.token = token;
    this.type = type;
    this.template = template;
    this.title = title;
    this.subtitle = subtitle;
    this.language = language;
    this.description = description;
    this.url = url;
    this.cover = cover;
    this.date = date;
    this.month = month;
    this.day = day;
    this.user = user;
    this.comment = comment;
    this.diary = diary;
    this.correct = correct;
    this.happening = happening;
    this.notification = notification;
    this.subModels = Internal.immutableCopyOf("subModels", subModels);
    this.addition = addition;
    this.actions = Internal.immutableCopyOf("actions", actions);
    this.flag = flag;
    this.count = count;
    this.week = week;
    this.email = email;
    this.content = Internal.immutableCopyOf("content", content);
    this.correct_sentence = correct_sentence;
    this.origin_sentence = origin_sentence;
    this.event = event;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.identity = identity;
    builder.token = token;
    builder.type = type;
    builder.template = template;
    builder.title = title;
    builder.subtitle = subtitle;
    builder.language = language;
    builder.description = description;
    builder.url = url;
    builder.cover = cover;
    builder.date = date;
    builder.month = month;
    builder.day = day;
    builder.user = user;
    builder.comment = comment;
    builder.diary = diary;
    builder.correct = correct;
    builder.happening = happening;
    builder.notification = notification;
    builder.subModels = Internal.copyOf("subModels", subModels);
    builder.addition = addition;
    builder.actions = Internal.copyOf("actions", actions);
    builder.flag = flag;
    builder.count = count;
    builder.week = week;
    builder.email = email;
    builder.content = Internal.copyOf("content", content);
    builder.correct_sentence = correct_sentence;
    builder.origin_sentence = origin_sentence;
    builder.event = event;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Model)) return false;
    Model o = (Model) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(identity, o.identity)
        && Internal.equals(token, o.token)
        && Internal.equals(type, o.type)
        && Internal.equals(template, o.template)
        && Internal.equals(title, o.title)
        && Internal.equals(subtitle, o.subtitle)
        && Internal.equals(language, o.language)
        && Internal.equals(description, o.description)
        && Internal.equals(url, o.url)
        && Internal.equals(cover, o.cover)
        && Internal.equals(date, o.date)
        && Internal.equals(month, o.month)
        && Internal.equals(day, o.day)
        && Internal.equals(user, o.user)
        && Internal.equals(comment, o.comment)
        && Internal.equals(diary, o.diary)
        && Internal.equals(correct, o.correct)
        && Internal.equals(happening, o.happening)
        && Internal.equals(notification, o.notification)
        && subModels.equals(o.subModels)
        && Internal.equals(addition, o.addition)
        && actions.equals(o.actions)
        && Internal.equals(flag, o.flag)
        && Internal.equals(count, o.count)
        && Internal.equals(week, o.week)
        && Internal.equals(email, o.email)
        && content.equals(o.content)
        && Internal.equals(correct_sentence, o.correct_sentence)
        && Internal.equals(origin_sentence, o.origin_sentence)
        && Internal.equals(event, o.event);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (identity != null ? identity.hashCode() : 0);
      result = result * 37 + (token != null ? token.hashCode() : 0);
      result = result * 37 + (type != null ? type.hashCode() : 0);
      result = result * 37 + (template != null ? template.hashCode() : 0);
      result = result * 37 + (title != null ? title.hashCode() : 0);
      result = result * 37 + (subtitle != null ? subtitle.hashCode() : 0);
      result = result * 37 + (language != null ? language.hashCode() : 0);
      result = result * 37 + (description != null ? description.hashCode() : 0);
      result = result * 37 + (url != null ? url.hashCode() : 0);
      result = result * 37 + (cover != null ? cover.hashCode() : 0);
      result = result * 37 + (date != null ? date.hashCode() : 0);
      result = result * 37 + (month != null ? month.hashCode() : 0);
      result = result * 37 + (day != null ? day.hashCode() : 0);
      result = result * 37 + (user != null ? user.hashCode() : 0);
      result = result * 37 + (comment != null ? comment.hashCode() : 0);
      result = result * 37 + (diary != null ? diary.hashCode() : 0);
      result = result * 37 + (correct != null ? correct.hashCode() : 0);
      result = result * 37 + (happening != null ? happening.hashCode() : 0);
      result = result * 37 + (notification != null ? notification.hashCode() : 0);
      result = result * 37 + subModels.hashCode();
      result = result * 37 + (addition != null ? addition.hashCode() : 0);
      result = result * 37 + actions.hashCode();
      result = result * 37 + (flag != null ? flag.hashCode() : 0);
      result = result * 37 + (count != null ? count.hashCode() : 0);
      result = result * 37 + (week != null ? week.hashCode() : 0);
      result = result * 37 + (email != null ? email.hashCode() : 0);
      result = result * 37 + content.hashCode();
      result = result * 37 + (correct_sentence != null ? correct_sentence.hashCode() : 0);
      result = result * 37 + (origin_sentence != null ? origin_sentence.hashCode() : 0);
      result = result * 37 + (event != null ? event.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (identity != null) builder.append(", identity=").append(identity);
    if (token != null) builder.append(", token=").append(token);
    if (type != null) builder.append(", type=").append(type);
    if (template != null) builder.append(", template=").append(template);
    if (title != null) builder.append(", title=").append(title);
    if (subtitle != null) builder.append(", subtitle=").append(subtitle);
    if (language != null) builder.append(", language=").append(language);
    if (description != null) builder.append(", description=").append(description);
    if (url != null) builder.append(", url=").append(url);
    if (cover != null) builder.append(", cover=").append(cover);
    if (date != null) builder.append(", date=").append(date);
    if (month != null) builder.append(", month=").append(month);
    if (day != null) builder.append(", day=").append(day);
    if (user != null) builder.append(", user=").append(user);
    if (comment != null) builder.append(", comment=").append(comment);
    if (diary != null) builder.append(", diary=").append(diary);
    if (correct != null) builder.append(", correct=").append(correct);
    if (happening != null) builder.append(", happening=").append(happening);
    if (notification != null) builder.append(", notification=").append(notification);
    if (!subModels.isEmpty()) builder.append(", subModels=").append(subModels);
    if (addition != null) builder.append(", addition=").append(addition);
    if (!actions.isEmpty()) builder.append(", actions=").append(actions);
    if (flag != null) builder.append(", flag=").append(flag);
    if (count != null) builder.append(", count=").append(count);
    if (week != null) builder.append(", week=").append(week);
    if (email != null) builder.append(", email=").append(email);
    if (!content.isEmpty()) builder.append(", content=").append(content);
    if (correct_sentence != null) builder.append(", correct_sentence=").append(correct_sentence);
    if (origin_sentence != null) builder.append(", origin_sentence=").append(origin_sentence);
    if (event != null) builder.append(", event=").append(event);
    return builder.replace(0, 2, "Model{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Model, Builder> {
    public String identity;

    public String token;

    public Type type;

    public Template template;

    public String title;

    public String subtitle;

    public String language;

    public String description;

    public String url;

    public String cover;

    public Long date;

    public String month;

    public String day;

    public User user;

    public Comment comment;

    public Diary diary;

    public Correct correct;

    public Happening happening;

    public Notification notification;

    public List<Model> subModels;

    public Model addition;

    public Map<Integer, Action> actions;

    public Flag flag;

    public Count count;

    public String week;

    public String email;

    public List<String> content;

    public String correct_sentence;

    public String origin_sentence;

    public Integer event;

    public Builder() {
      subModels = Internal.newMutableList();
      actions = Internal.newMutableMap();
      content = Internal.newMutableList();
    }

    public Builder identity(String identity) {
      this.identity = identity;
      return this;
    }

    public Builder token(String token) {
      this.token = token;
      return this;
    }

    public Builder type(Type type) {
      this.type = type;
      return this;
    }

    public Builder template(Template template) {
      this.template = template;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder subtitle(String subtitle) {
      this.subtitle = subtitle;
      return this;
    }

    public Builder language(String language) {
      this.language = language;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder cover(String cover) {
      this.cover = cover;
      return this;
    }

    public Builder date(Long date) {
      this.date = date;
      return this;
    }

    public Builder month(String month) {
      this.month = month;
      return this;
    }

    public Builder day(String day) {
      this.day = day;
      return this;
    }

    public Builder user(User user) {
      this.user = user;
      return this;
    }

    public Builder comment(Comment comment) {
      this.comment = comment;
      return this;
    }

    public Builder diary(Diary diary) {
      this.diary = diary;
      return this;
    }

    public Builder correct(Correct correct) {
      this.correct = correct;
      return this;
    }

    public Builder happening(Happening happening) {
      this.happening = happening;
      return this;
    }

    public Builder notification(Notification notification) {
      this.notification = notification;
      return this;
    }

    public Builder subModels(List<Model> subModels) {
      Internal.checkElementsNotNull(subModels);
      this.subModels = subModels;
      return this;
    }

    public Builder addition(Model addition) {
      this.addition = addition;
      return this;
    }

    public Builder actions(Map<Integer, Action> actions) {
      Internal.checkElementsNotNull(actions);
      this.actions = actions;
      return this;
    }

    public Builder flag(Flag flag) {
      this.flag = flag;
      return this;
    }

    public Builder count(Count count) {
      this.count = count;
      return this;
    }

    public Builder week(String week) {
      this.week = week;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder content(List<String> content) {
      Internal.checkElementsNotNull(content);
      this.content = content;
      return this;
    }

    public Builder correct_sentence(String correct_sentence) {
      this.correct_sentence = correct_sentence;
      return this;
    }

    public Builder origin_sentence(String origin_sentence) {
      this.origin_sentence = origin_sentence;
      return this;
    }

    public Builder event(Integer event) {
      this.event = event;
      return this;
    }

    @Override
    public Model build() {
      return new Model(identity, token, type, template, title, subtitle, language, description, url, cover, date, month, day, user, comment, diary, correct, happening, notification, subModels, addition, actions, flag, count, week, email, content, correct_sentence, origin_sentence, event, super.buildUnknownFields());
    }
  }

  public enum Type implements WireEnum {
    NONE(0),

    USER(1),

    DIARY(2),

    CORRECT(3),

    COMMENT(4),

    HAPPENING(5),

    NOTIFICATION(6),

    DATE(7),

    LANGUAGE(8);

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
        case 0: return NONE;
        case 1: return USER;
        case 2: return DIARY;
        case 3: return CORRECT;
        case 4: return COMMENT;
        case 5: return HAPPENING;
        case 6: return NOTIFICATION;
        case 7: return DATE;
        case 8: return LANGUAGE;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  public enum Template implements WireEnum {
    UNSUPPORTED(0),

    DATA(1),

    HEADER(2),

    ITEM_DIARY(3),

    ITEM_MONTH(4),

    ITEM_DIARY_WITH_MONTH(5),

    ITEM_DIVIDER_HEADER(6),

    ITEM_CORRECT_SENTENCE(7),

    ITEM_CORRECT(8),

    ITEM_COMMENT(9),

    ITEM_USER(10),

    ITEM_CORRECT_WITH_ORIGIN_CONTENT_SENTENCE(11),

    ITEM_ORIGIN_SENTENCE(12),

    ITEM_DIARY_TITLE(13),

    ITEM_NOTIFICATION(14),

    ITEM_FOLLOWER(15),

    ITEM_HAPPENING(16),

    ITEM_CORRECT_WITH_DIARY(17),

    ITEM_LANGUAGE(18);

    public static final ProtoAdapter<Template> ADAPTER = ProtoAdapter.newEnumAdapter(Template.class);

    private final int value;

    Template(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Template fromValue(int value) {
      switch (value) {
        case 0: return UNSUPPORTED;
        case 1: return DATA;
        case 2: return HEADER;
        case 3: return ITEM_DIARY;
        case 4: return ITEM_MONTH;
        case 5: return ITEM_DIARY_WITH_MONTH;
        case 6: return ITEM_DIVIDER_HEADER;
        case 7: return ITEM_CORRECT_SENTENCE;
        case 8: return ITEM_CORRECT;
        case 9: return ITEM_COMMENT;
        case 10: return ITEM_USER;
        case 11: return ITEM_CORRECT_WITH_ORIGIN_CONTENT_SENTENCE;
        case 12: return ITEM_ORIGIN_SENTENCE;
        case 13: return ITEM_DIARY_TITLE;
        case 14: return ITEM_NOTIFICATION;
        case 15: return ITEM_FOLLOWER;
        case 16: return ITEM_HAPPENING;
        case 17: return ITEM_CORRECT_WITH_DIARY;
        case 18: return ITEM_LANGUAGE;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_Model extends ProtoAdapter<Model> {
    private final ProtoAdapter<Map<Integer, Action>> actions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, Action.ADAPTER);

    ProtoAdapter_Model() {
      super(FieldEncoding.LENGTH_DELIMITED, Model.class);
    }

    @Override
    public int encodedSize(Model value) {
      return (value.identity != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.identity) : 0)
          + (value.token != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value.token) : 0)
          + (value.type != null ? Type.ADAPTER.encodedSizeWithTag(3, value.type) : 0)
          + (value.template != null ? Template.ADAPTER.encodedSizeWithTag(4, value.template) : 0)
          + (value.title != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, value.title) : 0)
          + (value.subtitle != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, value.subtitle) : 0)
          + (value.language != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, value.language) : 0)
          + (value.description != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, value.description) : 0)
          + (value.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, value.url) : 0)
          + (value.cover != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, value.cover) : 0)
          + (value.date != null ? ProtoAdapter.INT64.encodedSizeWithTag(11, value.date) : 0)
          + (value.month != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, value.month) : 0)
          + (value.day != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, value.day) : 0)
          + (value.user != null ? User.ADAPTER.encodedSizeWithTag(14, value.user) : 0)
          + (value.comment != null ? Comment.ADAPTER.encodedSizeWithTag(15, value.comment) : 0)
          + (value.diary != null ? Diary.ADAPTER.encodedSizeWithTag(16, value.diary) : 0)
          + (value.correct != null ? Correct.ADAPTER.encodedSizeWithTag(17, value.correct) : 0)
          + (value.happening != null ? Happening.ADAPTER.encodedSizeWithTag(18, value.happening) : 0)
          + (value.notification != null ? Notification.ADAPTER.encodedSizeWithTag(19, value.notification) : 0)
          + Model.ADAPTER.asRepeated().encodedSizeWithTag(20, value.subModels)
          + (value.addition != null ? Model.ADAPTER.encodedSizeWithTag(21, value.addition) : 0)
          + actions.encodedSizeWithTag(22, value.actions)
          + (value.flag != null ? Flag.ADAPTER.encodedSizeWithTag(23, value.flag) : 0)
          + (value.count != null ? Count.ADAPTER.encodedSizeWithTag(24, value.count) : 0)
          + (value.week != null ? ProtoAdapter.STRING.encodedSizeWithTag(25, value.week) : 0)
          + (value.email != null ? ProtoAdapter.STRING.encodedSizeWithTag(26, value.email) : 0)
          + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(27, value.content)
          + (value.correct_sentence != null ? ProtoAdapter.STRING.encodedSizeWithTag(28, value.correct_sentence) : 0)
          + (value.origin_sentence != null ? ProtoAdapter.STRING.encodedSizeWithTag(29, value.origin_sentence) : 0)
          + (value.event != null ? ProtoAdapter.INT32.encodedSizeWithTag(30, value.event) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Model value) throws IOException {
      if (value.identity != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.identity);
      if (value.token != null) ProtoAdapter.STRING.encodeWithTag(writer, 2, value.token);
      if (value.type != null) Type.ADAPTER.encodeWithTag(writer, 3, value.type);
      if (value.template != null) Template.ADAPTER.encodeWithTag(writer, 4, value.template);
      if (value.title != null) ProtoAdapter.STRING.encodeWithTag(writer, 5, value.title);
      if (value.subtitle != null) ProtoAdapter.STRING.encodeWithTag(writer, 6, value.subtitle);
      if (value.language != null) ProtoAdapter.STRING.encodeWithTag(writer, 7, value.language);
      if (value.description != null) ProtoAdapter.STRING.encodeWithTag(writer, 8, value.description);
      if (value.url != null) ProtoAdapter.STRING.encodeWithTag(writer, 9, value.url);
      if (value.cover != null) ProtoAdapter.STRING.encodeWithTag(writer, 10, value.cover);
      if (value.date != null) ProtoAdapter.INT64.encodeWithTag(writer, 11, value.date);
      if (value.month != null) ProtoAdapter.STRING.encodeWithTag(writer, 12, value.month);
      if (value.day != null) ProtoAdapter.STRING.encodeWithTag(writer, 13, value.day);
      if (value.user != null) User.ADAPTER.encodeWithTag(writer, 14, value.user);
      if (value.comment != null) Comment.ADAPTER.encodeWithTag(writer, 15, value.comment);
      if (value.diary != null) Diary.ADAPTER.encodeWithTag(writer, 16, value.diary);
      if (value.correct != null) Correct.ADAPTER.encodeWithTag(writer, 17, value.correct);
      if (value.happening != null) Happening.ADAPTER.encodeWithTag(writer, 18, value.happening);
      if (value.notification != null) Notification.ADAPTER.encodeWithTag(writer, 19, value.notification);
      Model.ADAPTER.asRepeated().encodeWithTag(writer, 20, value.subModels);
      if (value.addition != null) Model.ADAPTER.encodeWithTag(writer, 21, value.addition);
      actions.encodeWithTag(writer, 22, value.actions);
      if (value.flag != null) Flag.ADAPTER.encodeWithTag(writer, 23, value.flag);
      if (value.count != null) Count.ADAPTER.encodeWithTag(writer, 24, value.count);
      if (value.week != null) ProtoAdapter.STRING.encodeWithTag(writer, 25, value.week);
      if (value.email != null) ProtoAdapter.STRING.encodeWithTag(writer, 26, value.email);
      ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 27, value.content);
      if (value.correct_sentence != null) ProtoAdapter.STRING.encodeWithTag(writer, 28, value.correct_sentence);
      if (value.origin_sentence != null) ProtoAdapter.STRING.encodeWithTag(writer, 29, value.origin_sentence);
      if (value.event != null) ProtoAdapter.INT32.encodeWithTag(writer, 30, value.event);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Model decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.identity(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.token(ProtoAdapter.STRING.decode(reader)); break;
          case 3: {
            try {
              builder.type(Type.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 4: {
            try {
              builder.template(Template.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 5: builder.title(ProtoAdapter.STRING.decode(reader)); break;
          case 6: builder.subtitle(ProtoAdapter.STRING.decode(reader)); break;
          case 7: builder.language(ProtoAdapter.STRING.decode(reader)); break;
          case 8: builder.description(ProtoAdapter.STRING.decode(reader)); break;
          case 9: builder.url(ProtoAdapter.STRING.decode(reader)); break;
          case 10: builder.cover(ProtoAdapter.STRING.decode(reader)); break;
          case 11: builder.date(ProtoAdapter.INT64.decode(reader)); break;
          case 12: builder.month(ProtoAdapter.STRING.decode(reader)); break;
          case 13: builder.day(ProtoAdapter.STRING.decode(reader)); break;
          case 14: builder.user(User.ADAPTER.decode(reader)); break;
          case 15: builder.comment(Comment.ADAPTER.decode(reader)); break;
          case 16: builder.diary(Diary.ADAPTER.decode(reader)); break;
          case 17: builder.correct(Correct.ADAPTER.decode(reader)); break;
          case 18: builder.happening(Happening.ADAPTER.decode(reader)); break;
          case 19: builder.notification(Notification.ADAPTER.decode(reader)); break;
          case 20: builder.subModels.add(Model.ADAPTER.decode(reader)); break;
          case 21: builder.addition(Model.ADAPTER.decode(reader)); break;
          case 22: builder.actions.putAll(actions.decode(reader)); break;
          case 23: builder.flag(Flag.ADAPTER.decode(reader)); break;
          case 24: builder.count(Count.ADAPTER.decode(reader)); break;
          case 25: builder.week(ProtoAdapter.STRING.decode(reader)); break;
          case 26: builder.email(ProtoAdapter.STRING.decode(reader)); break;
          case 27: builder.content.add(ProtoAdapter.STRING.decode(reader)); break;
          case 28: builder.correct_sentence(ProtoAdapter.STRING.decode(reader)); break;
          case 29: builder.origin_sentence(ProtoAdapter.STRING.decode(reader)); break;
          case 30: builder.event(ProtoAdapter.INT32.decode(reader)); break;
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
    public Model redact(Model value) {
      Builder builder = value.newBuilder();
      if (builder.user != null) builder.user = User.ADAPTER.redact(builder.user);
      if (builder.comment != null) builder.comment = Comment.ADAPTER.redact(builder.comment);
      if (builder.diary != null) builder.diary = Diary.ADAPTER.redact(builder.diary);
      if (builder.correct != null) builder.correct = Correct.ADAPTER.redact(builder.correct);
      if (builder.happening != null) builder.happening = Happening.ADAPTER.redact(builder.happening);
      if (builder.notification != null) builder.notification = Notification.ADAPTER.redact(builder.notification);
      Internal.redactElements(builder.subModels, Model.ADAPTER);
      if (builder.addition != null) builder.addition = Model.ADAPTER.redact(builder.addition);
      Internal.redactElements(builder.actions, Action.ADAPTER);
      if (builder.flag != null) builder.flag = Flag.ADAPTER.redact(builder.flag);
      if (builder.count != null) builder.count = Count.ADAPTER.redact(builder.count);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
