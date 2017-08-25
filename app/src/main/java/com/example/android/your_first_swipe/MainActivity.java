package com.example.android.your_first_swipe;

import android.support.v4.util.CircularArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.your_first_swipe.data.CreditContract.CreditEntry;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    private Spinner firstSpinner, creditSpinner, purposeSpinner;
    private CheckBox firstCheckBox, scoreCheckBox, purposeCheckBox;
    private Button submitButton;

    public static int firstStatus = CreditEntry.SELECT;
    public static int scoreStatus = CreditEntry.SELECT;
    public static int purposeStatus = CreditEntry.SELECT;

    public static boolean firstCheckBoxStatus = false;
    public static boolean scoreCheckBoxStatus = false;
    public static boolean purposeCheckBoxStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsOnFirstSpinner();
        addItemsOnCreditSpinner();
        addItemsOnPurposeSpinner();
        addListenerOnSpinnerItemSelection();
        checkBoxControl();
    }

    // First Spinner asking if the application is for the first credit card
    private void addItemsOnFirstSpinner(){
        firstSpinner = (Spinner) findViewById(R.id.first_spinner);
        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource
                (this, R.array.yes_or_no, R.layout.my_spinner_textview);
        firstAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        firstSpinner.setAdapter(firstAdapter);
    }

    //Second Spinner asking about applicant's credit background
    private void addItemsOnCreditSpinner(){
        creditSpinner = (Spinner) findViewById(R.id.credit_score_spinner);
        ArrayAdapter<CharSequence> creditAdapter = ArrayAdapter.createFromResource
                (this, R.array.credit_score_array, R.layout.my_spinner_textview);
        creditAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        creditSpinner.setAdapter(creditAdapter);
    }

    //Third Spinner asking the main purpose of credit card
    private void addItemsOnPurposeSpinner(){
        purposeSpinner = (Spinner) findViewById(R.id.purpose_spinner);
        ArrayAdapter<CharSequence> purposeAdapter = ArrayAdapter.createFromResource
                (this, R.array.purpose_array, R.layout.my_spinner_textview);
        purposeAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        purposeSpinner.setAdapter(purposeAdapter);
    }

    private void addListenerOnSpinnerItemSelection() {
        firstSpinner = (Spinner) findViewById(R.id.first_spinner);
        creditSpinner = (Spinner) findViewById(R.id.credit_score_spinner);
        purposeSpinner = (Spinner) findViewById(R.id.purpose_spinner);

        firstSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        creditSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        purposeSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private void displayChecked(){
        if (firstCheckBoxStatus){
            Toast.makeText(this,"On",Toast.LENGTH_SHORT).show();}
        else {
            Toast.makeText(this,"Off",Toast.LENGTH_SHORT).show();}
        }

    private void checkBoxControl() {
        firstCheckBox = (CheckBox) findViewById(R.id.first_checkbox);
        scoreCheckBox = (CheckBox) findViewById(R.id.score_checkbox);
        purposeCheckBox = (CheckBox) findViewById(R.id.purpose_checkbox);

        if (firstCheckBoxStatus)
            firstCheckBox.setChecked(true);

        if (scoreCheckBoxStatus)
            scoreCheckBox.setChecked(true);

        if (purposeCheckBoxStatus)
            purposeCheckBox.setChecked(true);
    }
}