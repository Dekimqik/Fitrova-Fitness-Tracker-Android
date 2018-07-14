package com.fitness.fitrova.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fitness.fitrova.R;
import com.fitness.fitrova.utils.Utils;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTBaseFragment extends Fragment {

    protected static String         TAG;
    private ProgressDialog mProgressDlg;

    public FTBaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = getClass().getSimpleName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ftbase, container, false);
    }

    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showProgress(String title) {
        mProgressDlg = Utils.openNewDialog(getActivity(), title, false, false);
    }

    protected void dismissProgress() {
        try {
            if (mProgressDlg != null && mProgressDlg.isShowing())
                mProgressDlg.dismiss();
        } catch (Exception e) {}
    }
}
