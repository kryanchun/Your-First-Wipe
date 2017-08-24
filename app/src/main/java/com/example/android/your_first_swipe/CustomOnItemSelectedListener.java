package com.example.android.your_first_swipe;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.example.android.your_first_swipe.data.CreditContract.CreditEntry;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getId()) {
            case R.id.first_spinner:
                switch (parent.getItemAtPosition(pos).toString()){
                    case "SELECT":
                        break;
                    case "Yes.":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.YES;
                        break;
                    case "No":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.NO;
                        break;
                }
            case R.id.credit_score_spinner:
                switch (parent.getItemAtPosition(pos).toString()){
                    case "SELECT":
                        break;
                    case "Yes. Excellent(750 &amp; above)":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.EXCELLENT;
                        break;
                    case "Yes. Good (700-749)":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.GOOD;
                        break;
                    case "Yes. Fair (650-699)":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.FAIR;
                        break;
                    case "Yes. Poor (649 &amp; below)":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.POOR;
                        break;
                    case "No.":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.DONTKNOW;
                        break;
                }
            case R.id.purpose_spinner:
                switch (parent.getItemAtPosition(pos).toString()){
                    case "SELECT":
                        break;
                    case "Credit Building":
                        makeToast(parent,pos);
                        break;
                    case "Reward/Benefits":
                        makeToast(parent,pos);
                        break;
                    case "No specific purpose":
                        makeToast(parent,pos);
                        break;
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(parent.getContext(), "Spinner: unselected", Toast.LENGTH_SHORT).show();
    }


    private void makeToast(AdapterView<?> parent, int pos){
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }
}