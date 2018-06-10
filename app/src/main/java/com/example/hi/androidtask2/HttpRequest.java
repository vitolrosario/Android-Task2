package com.example.hi.androidtask2;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;

import cz.msebera.android.httpclient.entity.mime.Header;

public class HttpRequest {

    private static final String BASE_URL = "https://api.twitter.com/1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static JSONArray get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Object result = client.get(url, params, responseHandler);
        return  (JSONArray) result;
    }


    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

}
