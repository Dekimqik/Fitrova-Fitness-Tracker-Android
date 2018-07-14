package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fitness.fitrova.R;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTAboutFragment extends FTBaseFragment {

    TextView tvAbout1, tvAbout2, tvAbout3, tvAbout4, tvAbout5;

    static FTAboutFragment instance;
    public static FTAboutFragment getInstance() {
        if (instance == null)
            instance = new FTAboutFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        tvAbout1 = (TextView)rootView.findViewById(R.id.tvAbout1);
        tvAbout2 = (TextView)rootView.findViewById(R.id.tvAbout2);
        tvAbout3 = (TextView)rootView.findViewById(R.id.tvAbout3);
        tvAbout4 = (TextView)rootView.findViewById(R.id.tvAbout4);
        tvAbout5 = (TextView)rootView.findViewById(R.id.tvAbout5);

        tvAbout1.setText("Why do you love Fitrova?");
        tvAbout2.setText("We help you achieve your Fitness goals quicker & easier throught our easy to use app");
        tvAbout3.setText("Enjoy Fitness and life with Fitrova.");
        tvAbout4.setText("Offical Website:www.Fitrova.com");
        tvAbout5.setText("Fitrova Fitness Tracker is brought to you by twilx.");

        return rootView;
    }
}
