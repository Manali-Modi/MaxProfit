package com.example.maxprofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maxprofit.R;
import com.example.maxprofit.model.ShareDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etAmount;
    TextView txtMaxProfit;
    List<ShareDetail> allShare = new ArrayList<>();
    List<ShareDetail> resultShares = new ArrayList<>();
    double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addItemsToList();
        setProfitOnOne();
        sortAllShareAsPerProfit();
    }

    private void sortAllShareAsPerProfit() {
        Collections.sort(allShare, (c1, c2) -> Double.compare(c2.getProfitOnOne(), c1.getProfitOnOne()));
    }


    private void setProfitOnOne() {
        for (ShareDetail share: allShare){
            share.setProfitOnOne(share.getSellValue()-share.getBuyValue());
        }
    }

    private void addItemsToList() {
        allShare.add(new ShareDetail("Applo Tyre", 216.50, 217.40));
        allShare.add(new ShareDetail("TATA Power", 104.10, 104.30));
        allShare.add(new ShareDetail("ITC", 218.45, 219.25));
        allShare.add(new ShareDetail("PowerGrid", 214.10, 216.20));
    }

    private void initView() {
        etAmount = findViewById(R.id.et_amount);
        txtMaxProfit = findViewById(R.id.txt_max_profit);
    }

    @SuppressLint("DefaultLocale")
    public void calculateMaxProfit(View view) {
        etAmount.clearFocus();
        txtMaxProfit.setText("");
        resultShares.clear();
        if(etAmount.getText().length()==0){
            Toast.makeText(this,"Enter Amount First",Toast.LENGTH_SHORT).show();
        }
        else {
            amount = Double.parseDouble(etAmount.getText().toString());
            for(int i=0; i<allShare.size(); i++){
                addResultShares(i);
            }
            double maxProfit =0;
            for(int i=0; i<resultShares.size(); i++){
                maxProfit += resultShares.get(i).getProfitOnOne();
            }
            txtMaxProfit.append("\nMaximum Profit: " + String.format("%.2f", maxProfit));
        }

    }

    private void addResultShares(int index){
        int count = 0;
        while (amount>allShare.get(index).getBuyValue()) {
            resultShares.add(allShare.get(index));
            amount -= allShare.get(index).getBuyValue();
            count++;
        }
        txtMaxProfit.append(allShare.get(index).getCompanyName() + " -> " + count + "\n");
    }
}