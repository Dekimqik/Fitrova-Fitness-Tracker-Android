package com.fitness.fitrova.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.model.FTLog;

import java.util.ArrayList;

/**
 * Created by JGS on 7/13/2018.
 */

public class LogAdapter extends ArrayAdapter<FTLog> {

    private static class ViewHolder {
        ImageView ivImage;
        TextView tvContent, tvTime, tvNumber;
    }

    private Context context;
    private ArrayList<FTLog> data;

    public LogAdapter(Context context, int resourceId, ArrayList<FTLog> items) {
        super(context, resourceId, items);
        this.context = context;
        this.data = items;
    }

    public FTLog getItem(int position) {

        return this.getItem(position);
    }

    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        final LogAdapter.ViewHolder holder;

        if (v == null) {

            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.log_row, null);

            holder = new LogAdapter.ViewHolder();

            holder.ivImage = (ImageView)v.findViewById(R.id.ivImage);
            holder.tvContent = (TextView) v.findViewById(R.id.tvContent);
            holder.tvTime = (TextView) v.findViewById(R.id.tvTime);
            holder.tvNumber = (TextView) v.findViewById(R.id.tvNumber);

            v.setTag(holder);

        }  else {
            holder=(LogAdapter.ViewHolder)v.getTag();
        }

        if(data.size() > 0) {
            holder.ivImage.setImageResource(R.drawable.exercise);
            holder.tvContent.setText(data.get(position).content);
            holder.tvTime.setText(data.get(position).time);
            holder.tvNumber.setText(String.valueOf(data.get(position).number));
        }

        return v;
    }
}
