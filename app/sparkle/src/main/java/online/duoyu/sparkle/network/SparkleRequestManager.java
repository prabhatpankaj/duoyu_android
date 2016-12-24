package online.duoyu.sparkle.network;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.AuthFailureError;
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
import online.duoyu.sparkle.model.business.CurrentRequest;
import online.duoyu.sparkle.model.business.FollowingUserPublishedDiariesRequest;
import online.duoyu.sparkle.model.business.LoginRequest;
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
  private Map<String, String> mAdditionHeaders;

  public SparkleRequestManager(Context context) {
    super(context);
    mCacheConfig = new RequestManager.CacheConfig(true, DEFAULT_TTL, DEFAULT_SOFT_TTL);
    mAdditionHeaders = new HashMap<>();
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
      mAdditionHeaders.put(key, value);
    }
  }

  public <T extends Message> SparkleRequest<T>
  newSparkleRequest(ApiType apiType, Map<String, String> body, Class<T> clazz,
                    Response.Listener<T> listener, Response.ErrorListener errorListener) {
    return newSparkleRequest(getUrl(apiType), Request.Method.POST,
        buildBody(apiType, body), clazz, listener, errorListener);
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
        headers.put(Const.KEY_COOKIE, convertCookies(buildCookie()));
        headers.put(Const.USER_AGENT, Const.USER_AGENT_VALUE);
        if (SparkleApplication.getInstance().getAccountManager().isSignIn()) {
          headers.put(Const.KEY_AUTHORIZATION,
              SparkleApplication.getInstance().getAccountManager().getToken());
        }
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
      case FOLLOW_USER_DIARY:
        return Const.API_DIARY_FOLLOW_USER_PUBLISHED;
      case CURRENT_USER:
        return Const.API_CURRENT_USER;
      case LOGIN:
        return Const.API_LOGIN;
      default:
        throw new IllegalStateException("Unknown api type:" + apiType.name());
    }
  }

  private byte[] buildBody(ApiType apiType, Map<String, String> params) {
    ByteString content = null;
    switch (apiType) {
      case FOLLOW_USER_DIARY:
        FollowingUserPublishedDiariesRequest followingUserPublishedDiariesRequest =
            new FollowingUserPublishedDiariesRequest.Builder()
                .cursor(new Cursor.Builder().limit(20).build()).build();
        content = ByteString.of(FollowingUserPublishedDiariesRequest
            .ADAPTER.encode(followingUserPublishedDiariesRequest));
        break;
      case CURRENT_USER:
        CurrentRequest currentRequest = new CurrentRequest.Builder().build();
        content = ByteString.of(CurrentRequest.ADAPTER.encode(currentRequest));
        break;
      case LOGIN:
        LoginRequest loginRequest = new LoginRequest.Builder()
            .email(params.get(Const.KEY_EMAIL))
            .password(SparkleUtils.getPrehashedPassword(params.get(Const.KEY_PASSWORD)))
            .build();
        content = ByteString.of(LoginRequest.ADAPTER.encode(loginRequest));
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
    Map<String, String> cookies = new HashMap<>(mAdditionHeaders);
    return cookies;
  }
}
