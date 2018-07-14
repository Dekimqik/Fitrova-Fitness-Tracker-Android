package com.fitness.fitrova.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fitness.fitrova.R;
import com.fitness.fitrova.utils.Utils;

public class FTBaseActivity extends AppCompatActivity {

    protected static String TAG;
    private ProgressDialog mProgressDlg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftbase);

        TAG = getClass().getSimpleName();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    public void finishWithoutAnimation() {
        super.finish();
    }

    public void finishRightAnimation() {
        super.finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showProgress(String title) {
        mProgressDlg = Utils.openNewDialog(this, title, false, false);
    }

    protected void dismissProgress() {
        try {
            if (mProgressDlg != null && mProgressDlg.isShowing())
                mProgressDlg.dismiss();
        } catch (Exception e) {}
    }
}
