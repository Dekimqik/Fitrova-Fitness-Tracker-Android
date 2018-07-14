package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fitness.fitrova.R;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTDoExcerciseFragment extends FTBaseFragment {

    ImageView ivTitle, ivImage;
    TextView tvTime, tvStart, tvStop, tvFinish;

    static FTDoExcerciseFragment instance;
    public static FTDoExcerciseFragment getInstance() {
        if (instance == null)
            instance = new FTDoExcerciseFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_do_exercise, container, false);

        ivTitle = (ImageView)rootView.findViewById(R.id.ivTitle);
        ivImage = (ImageView)rootView.findViewById(R.id.ivImage);

        tvTime = (TextView)rootView.findViewById(R.id.tvTime);
        tvTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        tvStart = (TextView)rootView.findViewById(R.id.tvStart);
        tvStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        tvStop = (TextView)rootView.findViewById(R.id.tvStop);
        tvStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        tvFinish = (TextView)rootView.findViewById(R.id.tvFinish);
        tvFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }
}
