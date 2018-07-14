package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fitness.fitrova.R;
import com.fitness.fitrova.activity.FTMainActivity;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTWalletFragment extends FTBaseFragment {

    ProgressBar progressBalance;
    TextView tvBalance;
    TextView btnSendBalance, btnTransactionHistory;

    private static FTWalletFragment instance;

    public static FTWalletFragment getInstance() {

        if (instance == null) {
            instance = new FTWalletFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_wallet, container, false);

        instance = this;

        progressBalance = (ProgressBar)rootView.findViewById(R.id.progressBalance);
        tvBalance = (TextView)rootView.findViewById(R.id.tvBalance);

        btnSendBalance = (TextView)rootView.findViewById(R.id.btnSendBalance);
        btnSendBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FTMainActivity.getInstance().sendBalance();
            }
        });

        btnTransactionHistory = (TextView)rootView.findViewById(R.id.btnTransactionHistory);
        btnTransactionHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FTMainActivity.getInstance().transactionHistory();
            }
        });

        return rootView;
    }
}
