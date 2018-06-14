package com.example.hi.androidtask2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequestModel {

    private JSONArray array;
    private JSONObject obj;

    public JSONArray getArray ()
    {
        return array;
    }

    public void setArray (JSONArray jsonarray)
    {
        array = jsonarray;
    }

    public JSONObject getObj ()
    {
        return obj;
    }

    public void setObj (JSONObject jsonobj)
    {
        obj = jsonobj;
    }


}
