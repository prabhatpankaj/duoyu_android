// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: models/proto/business/notify.proto at 19:1
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
import java.util.List;
import okio.ByteString;
import online.duoyu.sparkle.model.proto.Notification;

public final class MarkAsReadNotificationRequest extends Message<MarkAsReadNotificationRequest, MarkAsReadNotificationRequest.Builder> {
  public static final ProtoAdapter<MarkAsReadNotificationRequest> ADAPTER = new ProtoAdapter_MarkAsReadNotificationRequest();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "online.duoyu.sparkle.model.proto.Notification$Event#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Notification.Event> events;

  public MarkAsReadNotificationRequest(List<Notification.Event> events) {
    this(events, ByteString.EMPTY);
  }

  public MarkAsReadNotificationRequest(List<Notification.Event> events, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.events = Internal.immutableCopyOf("events", events);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.events = Internal.copyOf("events", events);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof MarkAsReadNotificationRequest)) return false;
    MarkAsReadNotificationRequest o = (MarkAsReadNotificationRequest) other;
    return unknownFields().equals(o.unknownFields())
        && events.equals(o.events);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + events.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (!events.isEmpty()) builder.append(", events=").append(events);
    return builder.replace(0, 2, "MarkAsReadNotificationRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<MarkAsReadNotificationRequest, Builder> {
    public List<Notification.Event> events;

    public Builder() {
      events = Internal.newMutableList();
    }

    public Builder events(List<Notification.Event> events) {
      Internal.checkElementsNotNull(events);
      this.events = events;
      return this;
    }

    @Override
    public MarkAsReadNotificationRequest build() {
      return new MarkAsReadNotificationRequest(events, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_MarkAsReadNotificationRequest extends ProtoAdapter<MarkAsReadNotificationRequest> {
    ProtoAdapter_MarkAsReadNotificationRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, MarkAsReadNotificationRequest.class);
    }

    @Override
    public int encodedSize(MarkAsReadNotificationRequest value) {
      return Notification.Event.ADAPTER.asRepeated().encodedSizeWithTag(1, value.events)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, MarkAsReadNotificationRequest value) throws IOException {
      Notification.Event.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.events);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public MarkAsReadNotificationRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: {
            try {
              builder.events.add(Notification.Event.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
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
    public MarkAsReadNotificationRequest redact(MarkAsReadNotificationRequest value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
