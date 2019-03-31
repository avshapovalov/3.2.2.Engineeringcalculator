package com.example.engineeringcalculator;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    Button btOne, btTwo, btThree, btFour, btFive;
    Button btSix, btSeven, btEight, btNine, btZero;
    Button btPlus, btMinus, btMulti, btDiv, btEqual, btClear, btPercent,btChangeSign;
    TextView tvResult;
    Button changeCalkType;
    FrameLayout simplCalk, engeneeringCalk;
    int operand1, operand2, flagAction;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplCalk = (FrameLayout) findViewById(R.id.framesimplecalk);
        engeneeringCalk = (FrameLayout) findViewById(R.id.frameengeneeringcalk);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            simplCalk.setVisibility(View.VISIBLE);
            engeneeringCalk.setVisibility(View.GONE);
        }

        changeCalkType = (Button) findViewById(R.id.btn_changecalk);

        btOne = (Button) findViewById(R.id.btn_1);
        btTwo = (Button) findViewById(R.id.btn_2);
        btThree = (Button) findViewById(R.id.btn_3);
        btFour = (Button) findViewById(R.id.btn_4);
        btFive = (Button) findViewById(R.id.btn_5);
        btSix = (Button) findViewById(R.id.btn_6);
        btSeven = (Button) findViewById(R.id.btn_7);
        btEight = (Button) findViewById(R.id.btn_8);
        btNine = (Button) findViewById(R.id.btn_9);
        btZero = (Button) findViewById(R.id.btn_0);
        btPlus = (Button) findViewById(R.id.btn_plus);
        btMinus = (Button) findViewById(R.id.btn_minus);
        btMulti = (Button) findViewById(R.id.btn_X);
        btDiv = (Button) findViewById(R.id.btn_div);
        btEqual = (Button) findViewById(R.id.btn_equal);
        btClear = (Button) findViewById(R.id.btn_C);
        tvResult = (TextView) findViewById(R.id.display);
        btPercent = (Button) findViewById(R.id.btn_percent);
        btChangeSign = (Button) findViewById(R.id.btn_change_sign);

        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btFour.setOnClickListener(this);
        btFive.setOnClickListener(this);
        btSix.setOnClickListener(this);
        btSeven.setOnClickListener(this);
        btEight.setOnClickListener(this);
        btNine.setOnClickListener(this);
        btZero.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btMulti.setOnClickListener(this);
        btDiv.setOnClickListener(this);
        btClear.setOnClickListener(this);
        btEqual.setOnClickListener(this);
        btPercent.setOnClickListener(this);
        btChangeSign.setOnClickListener(this);
        changeCalkType.setOnClickListener(this);

        operand1 = 0;
        operand2 = 0;
        result = 0;
        flagAction = 0;

        tvResult.setText(Integer.toString(operand1));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_1:
                ClickNumber(1);
                break;
            case R.id.btn_2:
                ClickNumber(2);
                break;
            case R.id.btn_3:
                ClickNumber(3);
                break;
            case R.id.btn_4:
                ClickNumber(4);
                break;
            case R.id.btn_5:
                ClickNumber(5);
                break;
            case R.id.btn_6:
                ClickNumber(6);
                break;
            case R.id.btn_7:
                ClickNumber(7);
                break;
            case R.id.btn_8:
                ClickNumber(8);
                break;
            case R.id.btn_9:
                ClickNumber(9);
                break;
            case R.id.btn_0:
                ClickNumber(0);
                break;
            case R.id.btn_changecalk:
                if (simplCalk.getVisibility() == View.GONE) {
                    simplCalk.setVisibility(View.VISIBLE);
                    engeneeringCalk.setVisibility(View.GONE);
                } else {
                    simplCalk.setVisibility(View.GONE);
                    engeneeringCalk.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_change_sign:
                ChangeSign();
                break;
            case R.id.btn_plus:
                if(flagAction == 0) flagAction = 1;
                break;
            case R.id.btn_minus:
                if(flagAction == 0) flagAction = 2;
                break;
            case R.id.btn_X:
                if(flagAction == 0) flagAction = 3;
                break;
            case R.id.btn_div:
                if(flagAction == 0) flagAction = 4;
                break;
            case R.id.btn_percent:
                if(flagAction == 0) flagAction = 5;
                break;
            case R.id.btn_equal:
                switch(flagAction){
                    case 1:
                        result = operand1 + operand2;
                        break;
                    case 2:
                        result = operand1 - operand2;
                        break;
                    case 3:
                        result = operand1 * operand2;
                        break;
                    case 4:
                        result =(double) operand1 / (double) operand2;
                        break;
                    case 5:
                        result = ((double) operand1 * (double) operand2) / 100;
                        break;
                    default:
                        Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG).show();
                }

                if(flagAction != 0){
                    tvResult.setText(Double.toString(result));
                    operand1 = 0;
                    operand2 = 0;
                    result = 0;
                    flagAction = 0;
                }
                break;

            case R.id.btn_C:
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                tvResult.setText(Integer.toString(operand1));
                break;
        }
    }

    private void ClickNumber(int num){
        if (flagAction == 0) {
            operand1 = operand1*10 + num;
            tvResult.setText(Integer.toString(operand1));
        } else {
            operand2 = operand2*10 + num;
            tvResult.setText(Integer.toString(operand2));
        }
    }

    private void ChangeSign() {
        if (flagAction == 0) {
            operand1 = -operand1 ;
            tvResult.setText(Integer.toString(operand1));
        } else {
            operand2 = -operand2;
            tvResult.setText(Integer.toString(operand2));
        }
    }

}