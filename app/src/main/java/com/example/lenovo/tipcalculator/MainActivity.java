package com.example.lenovo.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount;
    private EditText peopleNumber;
    private SeekBar tipPercentage;
    private TextView result1;
    private TextView result2;
    private TextView tipPercentLabel;
    private Button calculateTips;


    private int tipPercentValue = 0;
    private int tipsForNumberOfPeople = 0;
    double bill ,people,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount = (EditText) findViewById(R.id.bill_value);
        peopleNumber = (EditText) findViewById(R.id.numberOfPeople);
        tipPercentage = (SeekBar) findViewById(R.id.tipPercentage);
        result1 = (TextView) findViewById(R.id.tipResult);
        result2 = (TextView) findViewById(R.id.toPayResult);
        tipPercentLabel = (TextView) findViewById(R.id.percentLabel);


        tipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try{

                tipPercentValue = progress;

                double totalBill = Double.parseDouble(billAmount.getText().toString());
                double totalPeople =Double.parseDouble((peopleNumber.getText().toString()));

                double percentTip = (totalBill * tipPercentValue / 100)/totalPeople;
                double billTotalAmount = percentTip * totalPeople;

                if(totalBill == 0){
                    Toast.makeText(getApplicationContext(), "You inputted zero!", Toast.LENGTH_SHORT).show();
                }else if (totalPeople == 0){
                    Toast.makeText(getApplicationContext(), "You inputted zero!", Toast.LENGTH_SHORT).show();
                }else if (totalPeople == 0 && totalBill == 0) {
                    Toast.makeText(getApplicationContext(), "You inputted zero!", Toast.LENGTH_SHORT).show();
                }else {
                    result2.setText(String.valueOf(String.format("%.2f", billTotalAmount)));
                    result1.setText(String.valueOf(String.format("%.2f", percentTip)));

                }
            }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "INVALID!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipPercentLabel.setText("" + seekBar.getProgress() + "%");
            }
        });


        peopleNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        billAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        }
    }




