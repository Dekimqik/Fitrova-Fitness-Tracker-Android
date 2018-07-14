package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fitness.fitrova.R;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTProfileFragment extends FTBaseFragment {

    ImageView ivProfile;
    TextView tvName, tvEmail;
    AppCompatEditText etWalletAddress;
    RelativeLayout rlChange;

    static FTProfileFragment instance;
    public static FTProfileFragment getInstance(){
        if(instance == null)
            instance = new FTProfileFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_myprofile, container, false);

        ivProfile = (ImageView)rootView.findViewById(R.id.ivProfile);
        tvName = (TextView)rootView.findViewById(R.id.tvName);
        tvEmail = (TextView)rootView.findViewById(R.id.tvEmail);
        etWalletAddress = (AppCompatEditText)rootView.findViewById(R.id.etWalletAddress);
        rlChange = (RelativeLayout)rootView.findViewById(R.id.rlChange);
        rlChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        return rootView;
    }
}
