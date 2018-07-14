package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.adapter.LogAdapter;
import com.fitness.fitrova.model.FTLog;

import java.util.ArrayList;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTLogFragment extends FTBaseFragment {

    ListView rvLog;
    ArrayList<FTLog> loglist = new ArrayList<>();

    static FTLogFragment instance;

    public static FTLogFragment getInstance() {
        if (instance == null)
            instance = new FTLogFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_log, container, false);
        rvLog = (ListView)rootView.findViewById(R.id.rvLog);

        loadData();

        return rootView;
    }

    private void loadData() {
        for(int i =0; i<15; i++){
            FTLog obj = new FTLog();
            obj.content = "Chest";
            obj.number = 24;
            obj.time = "25:45";

            loglist.add(obj);
        }

        LogAdapter adapter = new LogAdapter(this.getContext(), R.layout.log_row, this.loglist);
        this.rvLog.setAdapter(adapter);
    }
}
