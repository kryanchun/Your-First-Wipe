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
                        MainActivity.firstCheckBoxStatus = false;
                        break;
                    case "Yes.":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.YES;
                        MainActivity.firstCheckBoxStatus = true;
                        break;
                    case "No":
                        makeToast(parent,pos);
                        MainActivity.firstStatus = CreditEntry.NO;
                        MainActivity.firstCheckBoxStatus = true;
                        break;
                }
            case R.id.credit_score_spinner:
                switch (parent.getItemAtPosition(pos).toString()){
                    case "SELECT":
                        MainActivity.scoreCheckBoxStatus = false;
                        break;
                    case "Yes. Excellent (750 & above)":
                        MainActivity.scoreStatus = CreditEntry.EXCELLENT;
                        MainActivity.scoreCheckBoxStatus = true;
                        makeToast(parent,pos);
                        break;
                    case "Yes. Good (700-749)":
                        makeToast(parent,pos);
                        MainActivity.scoreStatus = CreditEntry.GOOD;
                        MainActivity.scoreCheckBoxStatus = true;
                        break;
                    case "Yes. Fair (650-699)":
                        makeToast(parent,pos);
                        MainActivity.scoreStatus = CreditEntry.FAIR;
                        MainActivity.scoreCheckBoxStatus = true;
                        break;
                    case "Yes. Poor (649 & below)":
                        makeToast(parent,pos);
                        MainActivity.scoreStatus = CreditEntry.POOR;
                        MainActivity.scoreCheckBoxStatus = true;
                        break;
                    case "No.":
                        makeToast(parent,pos);
                        MainActivity.scoreStatus = CreditEntry.DONTKNOW;
                        MainActivity.scoreCheckBoxStatus = true;
                        break;
                }
            case R.id.purpose_spinner:
                switch (parent.getItemAtPosition(pos).toString()){
                    case "SELECT":
                        MainActivity.purposeCheckBoxStatus = false;
                        break;
                    case "Credit Building":
                        makeToast(parent,pos);
                        MainActivity.purposeStatus = CreditEntry.CREDITBUILD;
                        MainActivity.purposeCheckBoxStatus = true;
                        break;
                    case "Reward/Benefits":
                        makeToast(parent,pos);
                        MainActivity.purposeStatus = CreditEntry.REWARDS;
                        MainActivity.purposeCheckBoxStatus = true;
                        break;
                    case "No specific purpose":
                        makeToast(parent,pos);
                        MainActivity.purposeStatus = CreditEntry.NOPURPOSE;
                        MainActivity.purposeCheckBoxStatus = true;
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
                "OnItemSelectedListener : " +parent.getItemAtPosition(pos).toString() + MainActivity.scoreCheckBoxStatus,
                Toast.LENGTH_SHORT).show();
    }
}