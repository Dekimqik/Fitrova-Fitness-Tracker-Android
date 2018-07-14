package com.fitness.fitrova.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.model.FTTransaction;

import java.util.ArrayList;

/**
 * Created by JGS on 7/13/2018.
 */

public class TransactionCommonAdapter extends ArrayAdapter<FTTransaction> {

    private static class ViewHolder {
        private TextView tvTime, tvTransaction, tvAmount;
    }

    private Context context;
    private ArrayList<FTTransaction> data;

    public TransactionCommonAdapter(Context context, int resourceId, ArrayList<FTTransaction> items) {

        super(context, resourceId, items);
        this.context = context;
        this.data = items;
    }

    public FTTransaction getItem(int position) {

        return this.getItem(position);
    }

    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        final ViewHolder holder;

        if (v == null) {

            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.transaction_row, null);

            holder = new ViewHolder();

            holder.tvTime = (TextView) v.findViewById(R.id.tvTime);
            holder.tvTransaction = (TextView) v.findViewById(R.id.tvTransaction);
            holder.tvAmount = (TextView) v.findViewById(R.id.tvAmount);

            v.setTag(holder);

        }  else {
            holder=(ViewHolder)v.getTag();
        }

        if(data.size() > 0) {
            holder.tvTime.setText(data.get(position).datetime);
            holder.tvTransaction.setText(data.get(position).transactionContent);
            holder.tvAmount.setText(String.valueOf(data.get(position).amount));
        }

        return v;
    }
}
