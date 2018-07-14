package com.fitness.fitrova.model;

import org.json.JSONObject;
import java.util.Date;

/**
 * Created by JGS on 7/13/2018.
 */

public class FTTransaction {

    public String uid;
    public String datetime;
    public String transactionContent;
    public double amount;

    public FTTransaction() {}

    public FTTransaction(JSONObject transaction) {

        uid = transaction.optString("uid");

        if (transaction.optString("datetime") != null) {
            datetime = transaction.optString("datetime");
        } else {
            datetime = "";
        }

        if (transaction.optString("transactionContent") != null) {
            transactionContent = transaction.optString("transactionContent");
        } else {
            transactionContent = "";
        }

        amount = transaction.optDouble("amount");
    }
}
