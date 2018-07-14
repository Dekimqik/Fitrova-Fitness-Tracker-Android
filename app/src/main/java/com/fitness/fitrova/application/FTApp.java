package com.fitness.fitrova.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.fitness.fitrova.model.FTConst;
import com.fitness.fitrova.utils.TinyDB;
import com.toxsl.volley.toolbox.SyncManager;

import org.json.JSONObject;

/**
 * Created by lion on 4/6/16.
 */
public class FTApp extends Application {

    public static SyncManager syncManager;

    public static final String TAG = FTApp.class.getSimpleName();
    public static JSONObject userInfo;
    public static JSONObject userDetail;

    private static FTApp mApp;
    public static FTApp getInstance() {

        if (mApp == null) {
            throw new IllegalStateException();
        }

        return mApp;
    }

    public FTApp() {
        mApp = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        syncManager = SyncManager.getInstance(this, false);
        syncManager.setBaseUrl(FTConst.SERVER_REMOTE_URL, "");

        try {
            TinyDB tinyDB = new TinyDB(this);
            JSONObject data = (JSONObject)tinyDB.getObject(FTConst.KEY_USER_INFO, JSONObject.class);

            userInfo = data;

        }catch (NullPointerException e) {
            Log.e(TAG, "User info doesn't exist");
        }
    }

    @Override
    public void onTerminate() {

        super.onTerminate();
    }

    public void removeUserInfo() {
        userInfo = null;
        TinyDB tinyDB = new TinyDB(this);
        tinyDB.remove(FTConst.KEY_USER_INFO);
    }

    public static SharedPreferences getPreference(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs;
    }

    public static SharedPreferences.Editor getPreferenceEditor(Context context) {
        return getPreference(context).edit();
    }
}
