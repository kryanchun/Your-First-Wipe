package com.example.android.your_first_swipe;

import android.support.v4.util.CircularArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.your_first_swipe.data.CreditContract.CreditEntry;

public class MainActivity extends AppCompatActivity {

    private Spinner firstSpinner, creditSpinner, purposeSpinner;
    private Button submitButton;

    public static int firstStatus = CreditEntry.SELECT;
    public static int scoreStatus = CreditEntry.SELECT;
    public static int purposeStatus = CreditEntry.SELECT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsOnFirstSpinner();
        addItemsOnCreditSpinner();
        addItemsOnPurposeSpinner();
        addListenerOnSpinnerItemSelection();
    }

    // First Spinner asking if the application is for the first credit card
    public void addItemsOnFirstSpinner(){
        firstSpinner = (Spinner) findViewById(R.id.first_spinner);
        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource
                (this, R.array.yes_or_no, R.layout.my_spinner_textview);
        firstAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        firstSpinner.setAdapter(firstAdapter);
    }

    //Second Spinner asking about applicant's credit background
    public void addItemsOnCreditSpinner(){
        creditSpinner = (Spinner) findViewById(R.id.credit_score_spinner);
        ArrayAdapter<CharSequence> creditAdapter = ArrayAdapter.createFromResource
                (this, R.array.credit_score_array, R.layout.my_spinner_textview);
        creditAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        creditSpinner.setAdapter(creditAdapter);
    }

    //Third Spinner asking the main purpose of credit card
    public void addItemsOnPurposeSpinner(){
        purposeSpinner = (Spinner) findViewById(R.id.purpose_spinner);
        ArrayAdapter<CharSequence> purposeAdapter = ArrayAdapter.createFromResource
                (this, R.array.purpose_array, R.layout.my_spinner_textview);
        purposeAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        purposeSpinner.setAdapter(purposeAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        firstSpinner = (Spinner) findViewById(R.id.first_spinner);
        creditSpinner = (Spinner) findViewById(R.id.credit_score_spinner);
        purposeSpinner = (Spinner) findViewById(R.id.purpose_spinner);

        firstSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        creditSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        purposeSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

}