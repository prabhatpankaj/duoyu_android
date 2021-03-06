package online.duoyu.sparkle.network;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.squareup.wire.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.littlekey.base.utils.CollectionUtils;
import me.littlekey.network.ImageManager;
import me.littlekey.network.NameValuePair;
import me.littlekey.network.RequestManager;
import okio.ByteString;
import online.duoyu.sparkle.SparkleApplication;
import online.duoyu.sparkle.model.business.AttendingRequest;
import online.duoyu.sparkle.model.business.CorrectsRequest;
import online.duoyu.sparkle.model.business.FollowerRequest;
import online.duoyu.sparkle.model.business.FollowingUserPublishedDiariesRequest;
import online.duoyu.sparkle.model.business.GetCommentsByDiaryIdRequest;
import online.duoyu.sparkle.model.business.GetCorrectByDiaryIdRequest;
import online.duoyu.sparkle.model.business.GetCorrectsByDiaryIdRequest;
import online.duoyu.sparkle.model.business.GetCorrectsByUserIdRequest;
import online.duoyu.sparkle.model.business.GetPublishedByUserIdRequest;
import online.duoyu.sparkle.model.business.GetTimelineByUserIdRequest;
import online.duoyu.sparkle.model.business.LoginRequest;
import online.duoyu.sparkle.model.business.PublishedRequest;
import online.duoyu.sparkle.model.business.RecentRequest;
import online.duoyu.sparkle.model.proto.Cursor;
import online.duoyu.sparkle.model.proto.RPCRequest;
import online.duoyu.sparkle.utils.Const;
import online.duoyu.sparkle.utils.PreferenceUtils;
import online.duoyu.sparkle.utils.SparkleUtils;

/**
 * Created by littlekey on 12/19/16.
 */

public class SparkleRequestManager extends RequestManager {
  private static final long DEFAULT_TTL = 7 * 24 * 60 * 60 * 1000; // 7 days
  private static final long DEFAULT_SOFT_TTL = 5 * 60 * 1000; // 5 minutes
  private final RequestManager.CacheConfig mCacheConfig;
  private Map<String, String> mAdditionCookies;

  public SparkleRequestManager(Context context) {
    super(context);
    mCacheConfig = new RequestManager.CacheConfig(true, DEFAULT_TTL, DEFAULT_SOFT_TTL);
    mAdditionCookies = new HashMap<>();
    SparkleApplication.getInstance().getImageManager().setHeaderCallback(
        new ImageManager.HeaderCallback() {

      @Override
      public List<NameValuePair> getHeaders() {
        List<NameValuePair> headers = new ArrayList<>();
        headers.add(new NameValuePair(Const.KEY_COOKIE, convertCookies(buildCookie())));
        return headers;
      }
    });
  }

  public void addCookie(String key, String value) {
    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
      switch (key) {
        case Const.KEY_S:
        case Const.KEY_LV:
        case Const.KEY_IGNEOUS:
          PreferenceUtils.setString(Const.LAST_COOKIE, key, value);
          break;
      }
      mAdditionCookies.put(key, value);
    }
  }

  public <T extends Message> SparkleRequest<T>
  newSparkleRequest(ApiType apiType, Map<String, String> body, Class<T> clazz,
                    Response.Listener<T> listener, Response.ErrorListener errorListener) {
    return newSparkleRequest(getUrl(apiType), Request.Method.POST,
        buildBody(apiType, body), clazz, listener, errorListener);
  }

  public <T extends Message> SparkleRequest<T>
  newSparkleRequest(ApiType apiType, ByteString body, Class<T> clazz,
                    Response.Listener<T> listener, Response.ErrorListener errorListener) {
    return newSparkleRequest(apiType, Request.Method.POST, body, clazz, listener, errorListener);
  }

  public <T extends Message> SparkleRequest<T>
  newSparkleRequest(ApiType apiType, int method, ByteString body, Class<T> clazz,
                    Response.Listener<T> listener, Response.ErrorListener errorListener) {
    return newSparkleRequest(getUrl(apiType), method, body, clazz, listener, errorListener);
  }

  public <T extends Message> SparkleRequest<T>
  newSparkleRequest(String url, int method, ByteString result, Class<T> clazz,
                    Response.Listener<T> listener, Response.ErrorListener errorListener) {
    return newSparkleRequest(url, method, buildBody(result), clazz, listener, errorListener);
  }

  public <T extends Message> SparkleRequest<T>
  newSparkleRequest(String url, int method, final byte[] body, Class<T> clazz,
                    Response.Listener<T> listener, Response.ErrorListener errorListener) {
    SparkleRequest<T> request = new SparkleRequest<T>(SparkleApplication.getInstance(),
        method, url, clazz, listener, errorListener, mCacheConfig) {

      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();
        Cache.Entry entry = getCacheEntry();
        if (entry != null && !TextUtils.isEmpty(entry.etag)) {
          headers.put(Const.KEY_ETAG, entry.etag);
        }
        headers.put(Const.KEY_COOKIE, convertCookies(buildCookie()));
        headers.put(Const.USER_AGENT, Const.USER_AGENT_VALUE);
        if (SparkleApplication.getInstance().getAccountManager().isSignIn()) {
          headers.put(Const.KEY_AUTHORIZATION,
              SparkleApplication.getInstance().getAccountManager().getToken());
        }
        headers.putAll(super.getHeaders());
        return headers;
      }

      @Override
      public String getBodyContentType() {
        return "application/protobuf";
      }

      @Override
      public byte[] getBody() {
        return body;
      }
    };
    request.setShouldCache(false);
    return request;
  }

  private String getUrl(ApiType apiType) {
    switch (apiType) {
      case RECENT_DIARY:
        return Const.API_DIARY_RECENT;
      case FOLLOW_USER_DIARY:
        return Const.API_DIARY_FOLLOW_USER_PUBLISHED;
      case CURRENT_USER:
        return Const.API_CURRENT_USER;
      case LOGIN:
        return Const.API_LOGIN;
      case GET_CORRECT_BY_DIARY_AND_USER:
        return Const.API_GET_CORRECT_BY_DIARY_AND_USER;
      case GET_CORRECTS_BY_DIARY:
      case GET_CORRECTS_SENTENCE_BY_DIARY:
        return Const.API_GET_CORRECTS_BY_DIARY;
      case CORRECT:
        return Const.API_CORRECT;
      case ATTENTION_DIARY:
        return Const.API_DIARY_ATTENTION;
      case UNATTENDED_DIARY:
        return Const.API_DIARY_UNATTENDED;
      case DIARY:
        return Const.API_DIARY;
      case GET_DIARY_BY_ID:
        return Const.API_GET_DIARY_BY_ID;
      case LIKE_COMMENT:
        return Const.API_LIKE_COMMENT;
      case LIKE_CORRECT:
        return Const.API_LIKE_CORRECT;
      case LIKE_DIARY:
        return Const.API_LIKE_DIARY;
      case UNLIKE_COMMENT:
        return Const.API_UNLIKE_COMMENT;
      case UNLIKE_CORRECT:
        return Const.API_UNLIKE_CORRECT;
      case UNLIKE_DIARY:
        return Const.API_UNLIKE_DIARY;
      case GET_COMMENTS_BY_DIARY:
        return Const.API_GET_COMMENTS_BY_DIARY;
      case COMMENT:
        return Const.API_COMMENT;
      case ATTENTION_NOTIFICATION:
      case LIKED_NOTIFICATION:
        return Const.API_CURRENT_USER_NOTIFICATION;
      case FOLLOWER:
        return Const.API_FOLLOWER;
      case FOLLOW:
        return Const.API_FOLLOW;
      case UNFOLLOW:
        return Const.API_UNFOLLOW;
      case GET_USER_TIMELINE:
        return Const.API_GET_USER_TIMELINE;
      case GET_USER_PUBLISHED_CORRECTS:
        return Const.API_GET_USER_PUBLISHED_CORRECTS;
      case GET_USER_PUBLISHED_DIARIES:
        return Const.API_GET_USER_PUBLISHED_DIARIES;
      case GET_USER_INFO:
        return Const.API_GET_USER_INFO;
      case MY_PUBLISHED_DIARIES:
        return Const.API_PUBLISHED_DIARIES;
      case MY_ATTENDING_DIARIES:
        return Const.API_ATTENDING_DIARIES;
      case MY_PUBLISHED_CORRECTS:
        return Const.API_PUBLISHED_CORRECTS;
      case EMAIL_VERIFY:
        return Const.API_EMAIL_VERIFY;
      case REGISTER:
        return Const.API_REGISTER;
      case CHANGE_PASSWORD:
        return Const.API_CHANGE_PASSWORD;
      default:
        throw new IllegalStateException("Unknown api type:" + apiType.name());
    }
  }

  private byte[] buildBody(ApiType apiType, Map<String, String> params) {
    ByteString content = null;
    String timestamp = params.get(Const.KEY_TIME_STAMP);
    switch (apiType) {
      case RECENT_DIARY:
        RecentRequest recentRequest = new RecentRequest.Builder()
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(RecentRequest.ADAPTER.encode(recentRequest));
        break;
      case FOLLOW_USER_DIARY:
        FollowingUserPublishedDiariesRequest followingUserPublishedDiariesRequest =
            new FollowingUserPublishedDiariesRequest.Builder()
                .cursor(new Cursor.Builder().limit(20).build()).build();
        content = ByteString.of(FollowingUserPublishedDiariesRequest
            .ADAPTER.encode(followingUserPublishedDiariesRequest));
        break;
      case CURRENT_USER:
        content = ByteString.EMPTY;
        break;
      case LOGIN:
        LoginRequest loginRequest = new LoginRequest.Builder()
            .email(params.get(Const.KEY_EMAIL))
            .password(SparkleUtils.getPrehashedPassword(params.get(Const.KEY_PASSWORD)))
            .build();
        content = ByteString.of(LoginRequest.ADAPTER.encode(loginRequest));
        break;
      case GET_CORRECT_BY_DIARY_AND_USER:
        GetCorrectByDiaryIdRequest getCorrectByDiaryIdRequest = new GetCorrectByDiaryIdRequest.Builder()
            .diary_id(params.get(Const.KEY_DIARY_IDENTITY))
            .build();
        content = ByteString.of(GetCorrectByDiaryIdRequest.ADAPTER.encode(getCorrectByDiaryIdRequest));
        break;
      case GET_CORRECTS_BY_DIARY:
      case GET_CORRECTS_SENTENCE_BY_DIARY:
        GetCorrectsByDiaryIdRequest getCorrectsByDiaryIdRequest = new GetCorrectsByDiaryIdRequest.Builder()
            .diary_id(params.get(Const.KEY_DIARY_IDENTITY))
            .build();
        content = ByteString.of(GetCorrectsByDiaryIdRequest.ADAPTER.encode(getCorrectsByDiaryIdRequest));
        break;
      case GET_COMMENTS_BY_DIARY:
        GetCommentsByDiaryIdRequest getCommentsByDiaryIdRequest = new GetCommentsByDiaryIdRequest.Builder()
            .diary_id(params.get(Const.KEY_DIARY_IDENTITY))
            .build();
        content = ByteString.of(GetCommentsByDiaryIdRequest.ADAPTER.encode(getCommentsByDiaryIdRequest));
        break;
      case FOLLOWER:
        FollowerRequest followerRequest = new FollowerRequest.Builder()
            .user_id(params.get(Const.KEY_USER_ID))
            .build();
        content = ByteString.of(FollowerRequest.ADAPTER.encode(followerRequest));
        break;
      case GET_USER_PUBLISHED_CORRECTS:
        GetCorrectsByUserIdRequest getCorrectsByUserIdRequest = new GetCorrectsByUserIdRequest.Builder()
            .user_id(params.get(Const.KEY_USER_ID))
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(GetCorrectsByUserIdRequest.ADAPTER.encode(getCorrectsByUserIdRequest));
        break;
      case GET_USER_PUBLISHED_DIARIES:
        GetPublishedByUserIdRequest getPublishedByUserIdRequest = new GetPublishedByUserIdRequest.Builder()
            .user_id(params.get(Const.KEY_USER_ID))
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(GetPublishedByUserIdRequest.ADAPTER.encode(getPublishedByUserIdRequest));
        break;
      case GET_USER_TIMELINE:
        GetTimelineByUserIdRequest getTimelineByUserIdRequest = new GetTimelineByUserIdRequest.Builder()
            .user_id(params.get(Const.KEY_USER_ID))
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(GetTimelineByUserIdRequest.ADAPTER.encode(getTimelineByUserIdRequest));
        break;
      case MY_PUBLISHED_DIARIES:
        PublishedRequest publishedRequest = new PublishedRequest.Builder()
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(PublishedRequest.ADAPTER.encode(publishedRequest));
        break;
      case MY_ATTENDING_DIARIES:
        AttendingRequest attendingRequest = new AttendingRequest.Builder()
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(AttendingRequest.ADAPTER.encode(attendingRequest));
        break;
      case MY_PUBLISHED_CORRECTS:
        CorrectsRequest correctsRequest = new CorrectsRequest.Builder()
            .cursor(timestamp != null ? new Cursor.Builder().timestamp(Long.valueOf(timestamp)).build() : null)
            .build();
        content = ByteString.of(CorrectsRequest.ADAPTER.encode(correctsRequest));
        break;
      default:
        throw new IllegalStateException("Unknown api type:" + apiType.name());
    }
    return buildBody(content);
  }

  private byte[] buildBody(ByteString content) {
    RPCRequest.Builder builder = new RPCRequest.Builder();
    builder.content(content);
    return RPCRequest.ADAPTER.encode(builder.build());
  }

  /**
   * Converts Map<String, String> to String.
   */
  public String convertCookies(Map<String, String> cookies) {
    List<String> result = new ArrayList<>();
    for (Map.Entry<String, String> cookieField : cookies.entrySet()) {
      CollectionUtils.add(result, String.format("%s=%s", cookieField.getKey(), cookieField.getValue()));
    }
    return TextUtils.join(";", result);
  }

  public Map<String, String> buildCookie() {
    Map<String, String> cookies = new HashMap<>(mAdditionCookies);
    return cookies;
  }
}
