package com.fitness.fitrova.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.fitness.fitrova.R;
import com.toxsl.volley.Request;
import com.toxsl.volley.VolleyError;
import com.toxsl.volley.toolbox.SyncEventListner;

import org.json.JSONObject;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTEnterPinActivity extends FTBaseActivity implements SyncEventListner {

    AppCompatEditText etPin;
    ImageView ivPincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftenterpin);

        ivPincode = (ImageView)findViewById(R.id.ivPincode);
        etPin = (AppCompatEditText) findViewById(R.id.etPin);

        etPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ivPincode.setVisibility(View.GONE);
                enterPinCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void enterPinCheck() {
        if(etPin.getText().length() == 4){
            Intent intent = new Intent(FTEnterPinActivity.this, FTMainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onSyncStart() {

    }

    @Override
    public void onSyncFinish() {

    }

    @Override
    public void onSyncFailure(VolleyError error, Request mRequest) {

    }

    @Override
    public void onSyncSuccess(String controller, String action, boolean status, JSONObject jsonObject) {

    }
}
