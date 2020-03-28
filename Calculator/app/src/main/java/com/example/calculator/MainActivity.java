package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

enum State
{
    NULL,
    PLUS,
    MINUS,
    DIVIDE,
    MULT,
    EQUAL,
    POW,
    SQRT,

    PI,
    EXP,
    SIN,
    COS,
    TAN,
    PERCENT,
    LN,
    LOG,
    FACT,
    NPOWER,

}

enum Sign
{
    PLUS,
    MINUS,
    DIVIDE,
    MULT,
    NONE,
    POW,
    SQRT,

    SIN,
    COS,
    TAN,
    PERCENT,
    LN,
    LOG,
    FACT,
    NPOWER,

}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textScreen;
    private Button n0;
    private Button n1;
    private Button n2;
    private Button n3;
    private Button n4;
    private Button n5;
    private Button n6;
    private Button n7;
    private Button n8;
    private Button n9;
    private Button btnDot;
    private Button equal;
    private Button addit;
    private Button subs;
    private Button mult;
    private Button div;
    private Button btnDelete;
    private Button btnSqrt;
    private Button btnPow;
    private Button deleteAll;

    private Button pi;
    private Button exp;
    private Button sin, cos, tan, log, ln, npower;

    private int dot = 0;
    private double num1 = 0;
    private double num2 = 0;

    State oper = State.NULL;
    Sign sign = Sign.NONE;

    int negative = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textScreen = findViewById(R.id.textScreen);
        n0 = findViewById(R.id.zero);
        n1 = findViewById(R.id.one);
        n2 = findViewById(R.id.two);
        n3 = findViewById(R.id.three);
        n4 = findViewById(R.id.four);
        n5 = findViewById(R.id.five);
        n6 = findViewById(R.id.six);
        n7 = findViewById(R.id.seven);
        n8 = findViewById(R.id.eight);
        n9 = findViewById(R.id.nine);
        btnDot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        addit = findViewById(R.id.plus);
        subs = findViewById(R.id.minus);
        mult = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);

        deleteAll = findViewById(R.id.clear);
        btnDelete = findViewById(R.id.delete);

        btnPow = findViewById(R.id.power);
        btnSqrt = findViewById(R.id.half_power);

//        pi = findViewById(R.id.pi);
//        exp = findViewById(R.id.exp);
//        sin = findViewById(R.id.sin);

        deleteAll.setOnClickListener(this);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textScreen.setText("");
            }
        });

        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        equal.setOnClickListener(this);
        addit.setOnClickListener(this);
        subs.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

    }

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.clear:
                    textScreen.setText("");
                    break;

                case R.id.dot:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().contains("."))
                        dot = 1;
                    if (dot != 1)
                        textScreen.append(".");
                    dot = 1;
                    break;

                case R.id.delete:
                    if (textScreen.getText().toString().length() == 0) {

                    } else if (textScreen.getText().toString().length() != 1) {
                        try {
                            textScreen.setText(textScreen.getText().toString().substring(0, textScreen.getText().toString().length() - 1));
                        } catch (NumberFormatException e) {
                            textScreen.setText("");
                        }
                    } else
                        textScreen.setText("");
                    if (textScreen.toString().contains(".")) {
                        dot = 1;
                    } else
                        dot = 0;
                    break;

                case R.id.one:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("1");
                    break;

                case R.id.two:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("2");
                    break;

                case R.id.three:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("3");
                    break;

                case R.id.four:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("4");
                    break;

                case R.id.five:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("5");
                    break;

                case R.id.six:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("6");
                    break;

                case R.id.seven:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("7");
                    break;

                case R.id.eight:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("8");
                    break;

                case R.id.nine:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 1) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    if (oper != State.NULL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    textScreen.append("9");
                    break;

                case R.id.zero:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (textScreen.getText().toString().equals("0")) {
                        textScreen.append("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    if ((textScreen.getText().toString().length() == 0 && dot != 1) || (textScreen.getText().toString().charAt(0) == '0'))
                        textScreen.setText("0");
                    else
                        textScreen.append("0");
                    break;


                case R.id.plus:
                    oper = State.PLUS;
                    sign = Sign.PLUS;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    if (oper != State.NULL && oper != State.EQUAL && negative == 0

                    ) {
                        oper = State.NULL;
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("Infinity");
                    }
                    dot = 0;
                    break;


                case R.id.minus:
                    oper = State.MINUS;
                    sign = Sign.MINUS;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("Infinity");
                    }
                    dot = 0;
                    break;


                case R.id.multiply:
                    oper = State.MULT;
                    sign = Sign.MULT;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("Infinity");
                    }
                    dot = 0;
                    break;

                case R.id.divide:
                    oper = State.DIVIDE;
                    sign = Sign.DIVIDE;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("Infinity");
                    }
                    dot = 0;
                    break;

                case R.id.half_power:
                    oper = State.SQRT;
                    sign = Sign.SQRT;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("Infinity");
                    }
                    dot = 0;
                    break;

                case R.id.power:
                    oper = State.POW;
                    sign = Sign.POW;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("Infinity");
                    }
                    dot = 0;
                    break;


// SIN
                case R.id.sin:
                    oper = State.SIN;
                    sign = Sign.SIN;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (!textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText(Double.toString(Math.sin(num1)));
                    }
                    dot = 0;
                    break;

//                    COS
                case R.id.cos:
                    oper = State.COS;
                    sign = Sign.COS;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (!textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText(Double.toString(Math.cos(num1)));
                    }
                    dot = 0;
                    break;

//                    TAN
                case R.id.tan:
                    oper = State.TAN;
                    sign = Sign.TAN;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (!textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText(Double.toString(Math.tan(num1)));
                    }
                    dot = 0;
                    break;

//                    PERCENT
                case R.id.percent:
                    oper = State.PERCENT;
                    sign = Sign.PERCENT;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (!textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText(Double.toString(num1 * 0.01));
                    }
                    dot = 0;
                    break;

//                    LN
                case R.id.ln:
                    oper = State.LN;
                    sign = Sign.LN;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (!textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText(Double.toString(Math.log(num1)));
                    }
                    dot = 0;
                    break;

//                    LOG
                case R.id.log:
                    oper = State.LOG;
                    sign = Sign.LOG;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (!textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText(Double.toString(Math.log10(num1)));
                    }
                    dot = 0;
                    break;

//FACTORIAL
                case R.id.fact:
                    oper = State.FACT;
                    sign = Sign.FACT;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                        int temp = (int) num1;
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                        break;
                    }


//                    N^M
                case R.id.n_power:
                    oper = State.NPOWER;
                    sign = Sign.NPOWER;
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num1 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    dot = 0;
                    break;


                case R.id.equal:
                    if (textScreen.getText().toString().equals("Infinity")) {
                        textScreen.setText("");
                    }
                    try {
                        num2 = Double.parseDouble(textScreen.getText().toString());
                    } catch (NumberFormatException e) {
                        textScreen.setText("");
                    }
                    if (sign == sign.PLUS) {
                        textScreen.setText(Double.toString(num1 + num2));
                    }
                    if (sign == sign.MINUS) {
                        textScreen.setText(Double.toString(num1 - num2));
                    }
                    if (sign == sign.MULT) {
                        textScreen.setText(Double.toString(num1 * num2));
                    }
                    if (sign == sign.DIVIDE) {
                        textScreen.setText(Double.toString(num1 / num2));
                    }
                    if (sign == sign.POW) {
                        textScreen.setText(Double.toString(num1 * num1));
                    }
                    if (sign == sign.SQRT) {
                        textScreen.setText(Double.toString(Math.sqrt(num1)));
                    }
                    oper = State.EQUAL;
                    break;

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//                    pi.setOnClickListener(this);
                    exp.setOnClickListener(this);
                    sin.setOnClickListener(this);
                    cos.setOnClickListener(this);
                    tan.setOnClickListener(this);
                    ln.setOnClickListener(this);
                    log.setOnClickListener(this);
                    npower.setOnClickListener(this);
                }
            }
        }

    }