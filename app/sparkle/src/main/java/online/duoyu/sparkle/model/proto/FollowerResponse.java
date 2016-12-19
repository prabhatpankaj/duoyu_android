// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/user.proto at 63:1
package online.duoyu.sparkle.model.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

import java.io.IOException;
import java.util.List;

import okio.ByteString;

public final class FollowerResponse extends Message<FollowerResponse, FollowerResponse.Builder> {
  public static final ProtoAdapter<FollowerResponse> ADAPTER = new ProtoAdapter_FollowerResponse();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "online.duoyu.sparkle.model.proto.User#ADAPTER",
      label = WireField.Label.REPEATED)
  public final List<User> users;

  @WireField(
      tag = 2,
      adapter = "online.duoyu.sparkle.model.proto.Cursor#ADAPTER")
  public final Cursor cursor;

  public FollowerResponse(List<User> users, Cursor cursor) {
    this(users, cursor, ByteString.EMPTY);
  }

  public FollowerResponse(List<User> users, Cursor cursor, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.users = Internal.immutableCopyOf("users", users);
    this.cursor = cursor;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.users = Internal.copyOf("users", users);
    builder.cursor = cursor;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof FollowerResponse)) return false;
    FollowerResponse o = (FollowerResponse) other;
    return unknownFields().equals(o.unknownFields()) && users.equals(o.users) && Internal.equals(cursor, o.cursor);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + users.hashCode();
      result = result * 37 + (cursor != null ? cursor.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (!users.isEmpty()) builder.append(", users=").append(users);
    if (cursor != null) builder.append(", cursor=").append(cursor);
    return builder.replace(0, 2, "FollowerResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<FollowerResponse, Builder> {
    public List<User> users;

    public Cursor cursor;

    public Builder() {
      users = Internal.newMutableList();
    }

    public Builder users(List<User> users) {
      Internal.checkElementsNotNull(users);
      this.users = users;
      return this;
    }

    public Builder cursor(Cursor cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public FollowerResponse build() {
      return new FollowerResponse(users, cursor, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_FollowerResponse extends ProtoAdapter<FollowerResponse> {
    ProtoAdapter_FollowerResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, FollowerResponse.class);
    }

    @Override
    public int encodedSize(FollowerResponse value) {
      return User.ADAPTER.asRepeated().encodedSizeWithTag(1, value.users) + (value.cursor != null ? Cursor.ADAPTER.encodedSizeWithTag(2, value.cursor) : 0) + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, FollowerResponse value) throws IOException {
      User.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.users);
      if (value.cursor != null) Cursor.ADAPTER.encodeWithTag(writer, 2, value.cursor);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public FollowerResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1; ) {
        switch (tag) {
          case 1:
            builder.users.add(User.ADAPTER.decode(reader));
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
    public FollowerResponse redact(FollowerResponse value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.users, User.ADAPTER);
      if (builder.cursor != null) builder.cursor = Cursor.ADAPTER.redact(builder.cursor);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
