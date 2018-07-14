package com.fitness.fitrova.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.fitness.fitrova.R;
import com.toxsl.volley.Request;
import com.toxsl.volley.VolleyError;
import com.toxsl.volley.toolbox.SyncEventListner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JGS on 7/12/2018.
 */

public class FTLoginActivity extends FTBaseActivity implements SyncEventListner {

    private AppCompatEditText etEmail;
    private AppCompatEditText etPassword;
    private RelativeLayout rlLogin, rlFacebookLogin, rlRegister;

    public static FTLoginActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftlogin);

        self = this;
        init();
    }

    private void init() {

        rlLogin = (RelativeLayout)findViewById(R.id.rlLogin);

        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), FTMainActivity.class);
                startActivity(i);
                self.finish();

            }
        });

        rlFacebookLogin = (RelativeLayout)findViewById(R.id.rlFacebookLogin);

        rlFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rlRegister = (RelativeLayout)findViewById(R.id.rlRegister);

        rlRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), FTRegisterActivity.class);
                startActivity(i);
                //self.finish();
            }
        });
    }

    @Override
    public void onSyncStart() {
        showProgress(getString(R.string.wait_message));
    }

    @Override
    public void onSyncFinish() {
        dismissProgress();
    }

    @Override
    public void onSyncFailure(VolleyError error, Request mRequest) {
        showToast(getString(R.string.failed));

    }

    @Override
    public void onSyncSuccess(String controller, String action, boolean status, JSONObject jsonObject) {
        System.out.println(jsonObject);
    }
}
