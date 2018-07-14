package com.fitness.fitrova.model;

import org.json.JSONObject;

/**
 * Created by JGS on 6/2/2018.
 */

public class FTUser {

    public String uid;
    public String user_email;
    public String user_name;
    public String user_password;
    public String user_photo;

    public FTUser() {}

    public FTUser(JSONObject userinfo) {

        uid = userinfo.optString("uid");

        if (userinfo.optString("user_email") != null) {
            user_email = userinfo.optString("user_email");
        } else {
            user_email = "";
        }

        if (userinfo.optString("user_name") != null) {
            user_name = userinfo.optString("user_name");
        } else {
            user_name = "";
        }
    }
}
