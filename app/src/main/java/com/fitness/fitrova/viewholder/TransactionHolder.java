package com.fitness.fitrova.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.fitness.fitrova.R;

/**
 * Created by NaSalRyo-K on 17/06/2018.
 */

public class TransactionHolder extends RecyclerView.ViewHolder{

    public TextView tvTime, tvTransaction, tvAmount;

    public TransactionHolder(View itemView) {
        super(itemView);

        tvTime = itemView.findViewById(R.id.tvTime);
        tvTransaction = itemView.findViewById(R.id.tvTransaction);
        tvAmount = itemView.findViewById(R.id.tvAmount);
    }
}
