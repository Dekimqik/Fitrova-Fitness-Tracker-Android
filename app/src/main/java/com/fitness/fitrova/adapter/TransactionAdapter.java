package com.fitness.fitrova.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.fitness.fitrova.R;
import com.fitness.fitrova.model.FTTransaction;
import com.fitness.fitrova.viewholder.TransactionHolder;

import java.util.ArrayList;

/**
 * Created by JGS on 7/13/2018.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionHolder> {

    private ArrayList<FTTransaction> mList = null;
    //private final AdapterView.OnItemClickListener mListener;

    public TransactionAdapter(ArrayList<FTTransaction> itemList){
        mList = itemList;
        //mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public TransactionHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_row, null);
        TransactionHolder holder = new TransactionHolder(layoutView);

        return holder;
    }

    @Override
    public void onBindViewHolder(TransactionHolder holder, final int position) {
        holder.tvTime.setText(mList.get(position).datetime);
        holder.tvTransaction.setText(mList.get(position).transactionContent);
        holder.tvAmount.setText(String.valueOf(mList.get(position).amount));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
