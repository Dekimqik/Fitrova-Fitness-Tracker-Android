package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.fitness.fitrova.R;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTSendBalanceFragment extends FTBaseFragment {

    AppCompatEditText etWalletAddress, etAmount;
    RelativeLayout rlConfirm;

    static FTSendBalanceFragment instnace;

    public static FTSendBalanceFragment getInstnace(){
        if (instnace == null){
            instnace = new FTSendBalanceFragment();
        }
        return instnace;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sendbalance, container, false);

        instnace = this;

        etWalletAddress = (AppCompatEditText)rootView.findViewById(R.id.etWalletAddress);
        etAmount = (AppCompatEditText)rootView.findViewById(R.id.etAmount);

        rlConfirm = (RelativeLayout)rootView.findViewById(R.id.rlConfirm);
        rlConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        return rootView;
    }
}
