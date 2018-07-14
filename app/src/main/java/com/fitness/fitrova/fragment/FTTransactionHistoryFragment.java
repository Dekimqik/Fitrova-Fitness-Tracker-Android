package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.adapter.TransactionAdapter;
import com.fitness.fitrova.adapter.TransactionCommonAdapter;
import com.fitness.fitrova.model.FTTransaction;
import java.util.ArrayList;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTTransactionHistoryFragment extends FTBaseFragment {

    static FTTransactionHistoryFragment instance;
    //RecyclerView rvHistory;
    ListView rvHistory;
    ArrayList<FTTransaction> trasactionList = new ArrayList<>();
    //TransactionAdapter adapter;
    TransactionCommonAdapter adapter;

    public static FTTransactionHistoryFragment getInstance() {
        if (instance == null)
            instance = new FTTransactionHistoryFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        //rvHistory = (RecyclerView)rootView.findViewById(R.id.rvHistory);
        rvHistory = (ListView)rootView.findViewById(R.id.rvHistory);
        loadData();
        return rootView;
    }

    private void loadData(){

        for (int i = 0; i < 14; i++) {

            FTTransaction data = new FTTransaction();

            data.datetime = "30 Minutes Ago";

            if (i % 2 == 0)
                data.transactionContent = "RECEIVED";
            else
                data.transactionContent = "SENT";
            data.amount = 0.1345;

            trasactionList.add(data);
        }

        adapter = new TransactionCommonAdapter(this.getContext(), R.layout.transaction_row, this.trasactionList);
        this.rvHistory.setAdapter(adapter);
    }
}
