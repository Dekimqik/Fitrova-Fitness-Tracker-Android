package com.fitness.fitrova.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.adapter.GridExerciseAdapter;
import com.fitness.fitrova.model.FTExercise;

import java.util.ArrayList;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTExerciseFragment extends FTBaseFragment {

    GridView gvExercise;
    ArrayList<FTExercise> exercisesList = new ArrayList<>();

    static FTExerciseFragment instance;

    public static FTExerciseFragment getInstance() {
        if (instance == null)
            instance = new FTExerciseFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise, container, false);
        gvExercise = (GridView)rootView.findViewById(R.id.gvExercise);

        loadData();
        return rootView;
    }

    private void loadData() {

        for (int i = 0; i < 15; i++) {
            FTExercise obj = new FTExercise();
            obj.icon = "exercise";
            obj.content = "Chest";
            exercisesList.add(obj);
        }

        GridExerciseAdapter adapter	= new GridExerciseAdapter(
                this.getContext(),
                R.layout.exercise_grid_item,
                exercisesList);

        this.gvExercise.setAdapter(adapter);
    }
}
