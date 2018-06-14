package com.example.hi.androidtask2;

import android.util.Log;

import com.apptakk.http_request.HttpRequest;
import com.apptakk.http_request.HttpRequestTask;
import com.apptakk.http_request.HttpResponse;

import org.json.JSONObject;

public class HttpReq {

    public HttpResponse get (String url, String JSONParams)
    {
        final HttpResponse[] resp = {new HttpResponse()};
        new HttpRequestTask(
                new HttpRequest("url", HttpRequest.GET, JSONParams),//"{ \"some\": \"data\" }"),
                new HttpRequest.Handler() {
                    @Override
                    public void response(HttpResponse response) {
                        resp[0] = response;
                        if (response.code == 200) {
                            Log.d(this.getClass().toString(), "Request successful!");
                        } else {
                            Log.e(this.getClass().toString(), "Request unsuccessful: " + response);
                        }
                    }
                }).execute();
        return resp[0];
    }
}
