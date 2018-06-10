package com.example.hi.androidtask2;
import com.loopj.android.http.*;

public class HttpRequest {

    private static final String BASE_URL = "https://api.twitter.com/1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static String get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Object result = client.get(url, params, responseHandler);
        return result.toString();
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
