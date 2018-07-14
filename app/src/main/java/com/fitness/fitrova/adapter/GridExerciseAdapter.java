package com.fitness.fitrova.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.model.FTExercise;

import java.util.ArrayList;

public class GridExerciseAdapter extends ArrayAdapter<FTExercise> {

    public static class ViewHolder {
        private ImageView ivImage;
        public TextView tvName;
    }

    private Context context;
    private ArrayList<FTExercise> data;

    public GridExerciseAdapter(Context context, int resourceId, ArrayList<FTExercise> items) {

        super(context, resourceId, items);
        this.context = context;
        this.data = items;
    }

    public FTExercise getItem(int position) {
        return this.getItem(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        final ViewHolder holder;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.exercise_grid_item, null);

            holder = new ViewHolder();
            holder.ivImage = (ImageView) v.findViewById(R.id.ivImage);
            holder.tvName = (TextView) v.findViewById(R.id.tvName);

            v.setTag(holder);
        }  else {
            holder=(ViewHolder)v.getTag();
        }

        try
           {
            if(data.size() > 0) {

                final FTExercise exercise = data.get(position);
                holder.tvName.setText(data.get(position).content);
                holder.ivImage.setImageResource(R.drawable.exercise);
            }
        }
        catch (Exception e) {

        }

        return v;
    }
}
