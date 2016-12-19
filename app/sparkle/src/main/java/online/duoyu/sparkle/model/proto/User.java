// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/model/model.proto at 12:1
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
import java.util.List;

import okio.ByteString;

public final class User extends Message<User, User.Builder> {
  public static final ProtoAdapter<User> ADAPTER = new ProtoAdapter_User();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_USER_ID = "";

  public static final String DEFAULT_NICKNAME = "";

  public static final String DEFAULT_EMAIL = "";

  public static final String DEFAULT_AVATAR = "";

  public static final String DEFAULT_REGION = "";

  public static final String DEFAULT_INTRODUCE = "";

  public static final Integer DEFAULT_FOLLOWING_NUM = 0;

  public static final Integer DEFAULT_FOLLOWER_NUM = 0;

  public static final Integer DEFAULT_LIKED_NUM = 0;

  public static final Integer DEFAULT_PUBLISHED_NUM = 0;

  public static final Integer DEFAULT_CORRECTED_NUM = 0;

  public static final Relationship DEFAULT_RELATIONSHIP = Relationship.NOT_FOLLOW;

  public static final Integer DEFAULT_NUMBER = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String user_id;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String nickname;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String email;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String avatar;

  @WireField(
      tag = 5,
      adapter = "online.duoyu.sparkle.model.proto.Language#ADAPTER",
      label = WireField.Label.REPEATED)
  public final List<Language> native_languages;

  @WireField(
      tag = 6,
      adapter = "online.duoyu.sparkle.model.proto.Language#ADAPTER",
      label = WireField.Label.REPEATED)
  public final List<Language> target_languages;

  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String region;

  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#STRING")
  public final String introduce;

  @WireField(
      tag = 9,
      adapter = "com.squareup.wire.ProtoAdapter#INT32")
  public final Integer following_num;

  @WireField(
      tag = 10,
      adapter = "com.squareup.wire.ProtoAdapter#INT32")
  public final Integer follower_num;

  @WireField(
      tag = 11,
      adapter = "com.squareup.wire.ProtoAdapter#INT32")
  public final Integer liked_num;

  @WireField(
      tag = 12,
      adapter = "com.squareup.wire.ProtoAdapter#INT32")
  public final Integer published_num;

  @WireField(
      tag = 13,
      adapter = "com.squareup.wire.ProtoAdapter#INT32")
  public final Integer corrected_num;

  @WireField(
      tag = 14,
      adapter = "online.duoyu.sparkle.model.proto.User$Relationship#ADAPTER")
  public final Relationship relationship;

  @WireField(
      tag = 15,
      adapter = "com.squareup.wire.ProtoAdapter#INT32")
  public final Integer number;

  @WireField(
      tag = 16,
      adapter = "online.duoyu.sparkle.model.proto.Happening#ADAPTER",
      label = WireField.Label.REPEATED)
  public final List<Happening> happenings;

  public User(String user_id, String nickname, String email, String avatar, List<Language> native_languages, List<Language> target_languages, String region, String introduce, Integer following_num, Integer follower_num, Integer liked_num, Integer published_num, Integer corrected_num, Relationship relationship, Integer number, List<Happening> happenings) {
    this(user_id, nickname, email, avatar, native_languages, target_languages, region, introduce, following_num, follower_num, liked_num, published_num, corrected_num, relationship, number, happenings, ByteString.EMPTY);
  }

  public User(String user_id, String nickname, String email, String avatar, List<Language> native_languages, List<Language> target_languages, String region, String introduce, Integer following_num, Integer follower_num, Integer liked_num, Integer published_num, Integer corrected_num, Relationship relationship, Integer number, List<Happening> happenings, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.user_id = user_id;
    this.nickname = nickname;
    this.email = email;
    this.avatar = avatar;
    this.native_languages = Internal.immutableCopyOf("native_languages", native_languages);
    this.target_languages = Internal.immutableCopyOf("target_languages", target_languages);
    this.region = region;
    this.introduce = introduce;
    this.following_num = following_num;
    this.follower_num = follower_num;
    this.liked_num = liked_num;
    this.published_num = published_num;
    this.corrected_num = corrected_num;
    this.relationship = relationship;
    this.number = number;
    this.happenings = Internal.immutableCopyOf("happenings", happenings);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.user_id = user_id;
    builder.nickname = nickname;
    builder.email = email;
    builder.avatar = avatar;
    builder.native_languages = Internal.copyOf("native_languages", native_languages);
    builder.target_languages = Internal.copyOf("target_languages", target_languages);
    builder.region = region;
    builder.introduce = introduce;
    builder.following_num = following_num;
    builder.follower_num = follower_num;
    builder.liked_num = liked_num;
    builder.published_num = published_num;
    builder.corrected_num = corrected_num;
    builder.relationship = relationship;
    builder.number = number;
    builder.happenings = Internal.copyOf("happenings", happenings);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof User)) return false;
    User o = (User) other;
    return unknownFields().equals(o.unknownFields()) && Internal.equals(user_id, o.user_id) && Internal.equals(nickname, o.nickname) && Internal.equals(email, o.email) && Internal.equals(avatar, o.avatar) && native_languages.equals(o.native_languages) && target_languages.equals(o.target_languages) && Internal.equals(region, o.region) && Internal.equals(introduce, o.introduce) && Internal.equals(following_num, o.following_num) && Internal.equals(follower_num, o.follower_num) && Internal.equals(liked_num, o.liked_num) && Internal.equals(published_num, o.published_num) && Internal.equals(corrected_num, o.corrected_num) && Internal.equals(relationship, o.relationship) && Internal.equals(number, o.number) && happenings.equals(o.happenings);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (user_id != null ? user_id.hashCode() : 0);
      result = result * 37 + (nickname != null ? nickname.hashCode() : 0);
      result = result * 37 + (email != null ? email.hashCode() : 0);
      result = result * 37 + (avatar != null ? avatar.hashCode() : 0);
      result = result * 37 + native_languages.hashCode();
      result = result * 37 + target_languages.hashCode();
      result = result * 37 + (region != null ? region.hashCode() : 0);
      result = result * 37 + (introduce != null ? introduce.hashCode() : 0);
      result = result * 37 + (following_num != null ? following_num.hashCode() : 0);
      result = result * 37 + (follower_num != null ? follower_num.hashCode() : 0);
      result = result * 37 + (liked_num != null ? liked_num.hashCode() : 0);
      result = result * 37 + (published_num != null ? published_num.hashCode() : 0);
      result = result * 37 + (corrected_num != null ? corrected_num.hashCode() : 0);
      result = result * 37 + (relationship != null ? relationship.hashCode() : 0);
      result = result * 37 + (number != null ? number.hashCode() : 0);
      result = result * 37 + happenings.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (user_id != null) builder.append(", user_id=").append(user_id);
    if (nickname != null) builder.append(", nickname=").append(nickname);
    if (email != null) builder.append(", email=").append(email);
    if (avatar != null) builder.append(", avatar=").append(avatar);
    if (!native_languages.isEmpty()) builder.append(", native_languages=").append(native_languages);
    if (!target_languages.isEmpty()) builder.append(", target_languages=").append(target_languages);
    if (region != null) builder.append(", region=").append(region);
    if (introduce != null) builder.append(", introduce=").append(introduce);
    if (following_num != null) builder.append(", following_num=").append(following_num);
    if (follower_num != null) builder.append(", follower_num=").append(follower_num);
    if (liked_num != null) builder.append(", liked_num=").append(liked_num);
    if (published_num != null) builder.append(", published_num=").append(published_num);
    if (corrected_num != null) builder.append(", corrected_num=").append(corrected_num);
    if (relationship != null) builder.append(", relationship=").append(relationship);
    if (number != null) builder.append(", number=").append(number);
    if (!happenings.isEmpty()) builder.append(", happenings=").append(happenings);
    return builder.replace(0, 2, "User{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<User, Builder> {
    public String user_id;

    public String nickname;

    public String email;

    public String avatar;

    public List<Language> native_languages;

    public List<Language> target_languages;

    public String region;

    public String introduce;

    public Integer following_num;

    public Integer follower_num;

    public Integer liked_num;

    public Integer published_num;

    public Integer corrected_num;

    public Relationship relationship;

    public Integer number;

    public List<Happening> happenings;

    public Builder() {
      native_languages = Internal.newMutableList();
      target_languages = Internal.newMutableList();
      happenings = Internal.newMutableList();
    }

    public Builder user_id(String user_id) {
      this.user_id = user_id;
      return this;
    }

    public Builder nickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder avatar(String avatar) {
      this.avatar = avatar;
      return this;
    }

    public Builder native_languages(List<Language> native_languages) {
      Internal.checkElementsNotNull(native_languages);
      this.native_languages = native_languages;
      return this;
    }

    public Builder target_languages(List<Language> target_languages) {
      Internal.checkElementsNotNull(target_languages);
      this.target_languages = target_languages;
      return this;
    }

    public Builder region(String region) {
      this.region = region;
      return this;
    }

    public Builder introduce(String introduce) {
      this.introduce = introduce;
      return this;
    }

    public Builder following_num(Integer following_num) {
      this.following_num = following_num;
      return this;
    }

    public Builder follower_num(Integer follower_num) {
      this.follower_num = follower_num;
      return this;
    }

    public Builder liked_num(Integer liked_num) {
      this.liked_num = liked_num;
      return this;
    }

    public Builder published_num(Integer published_num) {
      this.published_num = published_num;
      return this;
    }

    public Builder corrected_num(Integer corrected_num) {
      this.corrected_num = corrected_num;
      return this;
    }

    public Builder relationship(Relationship relationship) {
      this.relationship = relationship;
      return this;
    }

    public Builder number(Integer number) {
      this.number = number;
      return this;
    }

    public Builder happenings(List<Happening> happenings) {
      Internal.checkElementsNotNull(happenings);
      this.happenings = happenings;
      return this;
    }

    @Override
    public User build() {
      return new User(user_id, nickname, email, avatar, native_languages, target_languages, region, introduce, following_num, follower_num, liked_num, published_num, corrected_num, relationship, number, happenings, super.buildUnknownFields());
    }
  }

  public enum Relationship implements WireEnum {
    NOT_FOLLOW(0),

    FOLLOWING(1),

    FOLLOWER(2),

    EACH_FOLLOW(3),

    SELF(4);

    public static final ProtoAdapter<Relationship> ADAPTER = ProtoAdapter.newEnumAdapter(Relationship.class);

    private final int value;

    Relationship(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Relationship fromValue(int value) {
      switch (value) {
        case 0:
          return NOT_FOLLOW;
        case 1:
          return FOLLOWING;
        case 2:
          return FOLLOWER;
        case 3:
          return EACH_FOLLOW;
        case 4:
          return SELF;
        default:
          return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_User extends ProtoAdapter<User> {
    ProtoAdapter_User() {
      super(FieldEncoding.LENGTH_DELIMITED, User.class);
    }

    @Override
    public int encodedSize(User value) {
      return (value.user_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.user_id) : 0) + (value.nickname != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value.nickname) : 0) + (value.email != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value.email) : 0) + (value.avatar != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value.avatar) : 0) + Language.ADAPTER.asRepeated().encodedSizeWithTag(5, value.native_languages) + Language.ADAPTER.asRepeated().encodedSizeWithTag(6, value.target_languages) + (value.region != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, value.region) : 0) + (value.introduce != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, value.introduce) : 0) + (value.following_num != null ? ProtoAdapter.INT32.encodedSizeWithTag(9, value.following_num) : 0) + (value.follower_num != null ? ProtoAdapter.INT32.encodedSizeWithTag(10, value.follower_num) : 0) + (value.liked_num != null ? ProtoAdapter.INT32.encodedSizeWithTag(11, value.liked_num) : 0) + (value.published_num != null ? ProtoAdapter.INT32.encodedSizeWithTag(12, value.published_num) : 0) + (value.corrected_num != null ? ProtoAdapter.INT32.encodedSizeWithTag(13, value.corrected_num) : 0) + (value.relationship != null ? Relationship.ADAPTER.encodedSizeWithTag(14, value.relationship) : 0) + (value.number != null ? ProtoAdapter.INT32.encodedSizeWithTag(15, value.number) : 0) + Happening.ADAPTER.asRepeated().encodedSizeWithTag(16, value.happenings) + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, User value) throws IOException {
      if (value.user_id != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.user_id);
      if (value.nickname != null) ProtoAdapter.STRING.encodeWithTag(writer, 2, value.nickname);
      if (value.email != null) ProtoAdapter.STRING.encodeWithTag(writer, 3, value.email);
      if (value.avatar != null) ProtoAdapter.STRING.encodeWithTag(writer, 4, value.avatar);
      Language.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.native_languages);
      Language.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.target_languages);
      if (value.region != null) ProtoAdapter.STRING.encodeWithTag(writer, 7, value.region);
      if (value.introduce != null) ProtoAdapter.STRING.encodeWithTag(writer, 8, value.introduce);
      if (value.following_num != null)
        ProtoAdapter.INT32.encodeWithTag(writer, 9, value.following_num);
      if (value.follower_num != null)
        ProtoAdapter.INT32.encodeWithTag(writer, 10, value.follower_num);
      if (value.liked_num != null) ProtoAdapter.INT32.encodeWithTag(writer, 11, value.liked_num);
      if (value.published_num != null)
        ProtoAdapter.INT32.encodeWithTag(writer, 12, value.published_num);
      if (value.corrected_num != null)
        ProtoAdapter.INT32.encodeWithTag(writer, 13, value.corrected_num);
      if (value.relationship != null)
        Relationship.ADAPTER.encodeWithTag(writer, 14, value.relationship);
      if (value.number != null) ProtoAdapter.INT32.encodeWithTag(writer, 15, value.number);
      Happening.ADAPTER.asRepeated().encodeWithTag(writer, 16, value.happenings);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public User decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1; ) {
        switch (tag) {
          case 1:
            builder.user_id(ProtoAdapter.STRING.decode(reader));
            break;
          case 2:
            builder.nickname(ProtoAdapter.STRING.decode(reader));
            break;
          case 3:
            builder.email(ProtoAdapter.STRING.decode(reader));
            break;
          case 4:
            builder.avatar(ProtoAdapter.STRING.decode(reader));
            break;
          case 5: {
            try {
              builder.native_languages.add(Language.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 6: {
            try {
              builder.target_languages.add(Language.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 7:
            builder.region(ProtoAdapter.STRING.decode(reader));
            break;
          case 8:
            builder.introduce(ProtoAdapter.STRING.decode(reader));
            break;
          case 9:
            builder.following_num(ProtoAdapter.INT32.decode(reader));
            break;
          case 10:
            builder.follower_num(ProtoAdapter.INT32.decode(reader));
            break;
          case 11:
            builder.liked_num(ProtoAdapter.INT32.decode(reader));
            break;
          case 12:
            builder.published_num(ProtoAdapter.INT32.decode(reader));
            break;
          case 13:
            builder.corrected_num(ProtoAdapter.INT32.decode(reader));
            break;
          case 14: {
            try {
              builder.relationship(Relationship.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 15:
            builder.number(ProtoAdapter.INT32.decode(reader));
            break;
          case 16:
            builder.happenings.add(Happening.ADAPTER.decode(reader));
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
    public User redact(User value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.happenings, Happening.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
