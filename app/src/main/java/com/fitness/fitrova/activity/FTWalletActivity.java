package com.fitness.fitrova.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.RelativeLayout;

import com.fitness.fitrova.R;
import com.toxsl.volley.Request;
import com.toxsl.volley.VolleyError;
import com.toxsl.volley.toolbox.SyncEventListner;

import org.json.JSONObject;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTWalletActivity extends FTBaseActivity implements SyncEventListner {

    AppCompatEditText etWalletAddress;
    RelativeLayout rlConfirm;

    public static FTWalletActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftwalletconfirm);

        self = this;

        etWalletAddress = (AppCompatEditText)findViewById(R.id.etWalletAddress);

        rlConfirm = (RelativeLayout)findViewById(R.id.rlConfirm);
        rlConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FTWalletActivity.this, FTEnterPinActivity.class);
                startActivity(intent);

                self.finish();
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
