package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String am, in, y, m;

    double a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, total_month = 0, total_interest = 0, emi = 0, final_month = 0,ans,totalint,tpay, year, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clc_btn = findViewById(R.id.clc_btn);
        Button reset_btn = findViewById(R.id.reset_btn);
        Button details_btn = findViewById(R.id.details_btn);
        EditText amt_edt = findViewById(R.id.amt_edt);
        EditText int_edt = findViewById(R.id.int_edt);
        EditText year_edt = findViewById(R.id.year_edt);
        EditText month_edt = findViewById(R.id.month_edt);
        TextView month_txt = findViewById(R.id.month_txt);
        TextView emi_txt = findViewById(R.id.emi_txt);
        TextView total_pay = findViewById(R.id.total_pay);
        TextView total_emi = findViewById(R.id.total_emi);


        clc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (amt_edt.getText().toString().length() != 0 && int_edt.getText().toString().length() != 0) {
                    String temp = amt_edt.getText().toString();
                    a = Double.parseDouble(temp);

                    String temp2 = int_edt.getText().toString();
                    b = Double.parseDouble(temp2);


                    if (year_edt.getText().toString().length() == 0) {
                        year_edt.setText("0");
                    } else {
                        String temp3 = year_edt.getText().toString();
                        z = Double.parseDouble(temp3);
                    }

                    year = z * 12;

                    if (month_edt.getText().toString().length() == 0) {
                        month_edt.setText("0");
                    } else {
                        String temp4 = month_edt.getText().toString();
                        d = Double.parseDouble(temp4);
                    }

                    if (d > 12) {
                        Toast.makeText(MainActivity.this, "please Enter Month Under 13", Toast.LENGTH_SHORT).show();
                    } else {
                        if (z == 0 && d == 0) {
                            Toast.makeText(MainActivity.this, "please Enter Period of loan", Toast.LENGTH_SHORT).show();
                        } else {
                            e = d + year;
                            f = (a * b) / 100;
                            ans = (f / e);
                            totalint = ans * e;
                            tpay = totalint + a;
                            emi_txt.setText("" + ans);
                        }
                    }

                } else {

                    Toast.makeText(MainActivity.this, "please Enter details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amt_edt.setText("");
                int_edt.setText("");
                year_edt.setText("");
                month_edt.setText("");
                emi_txt.setText("");
                total_emi.setText("");
                total_pay.setText("");
                month_txt.setText("");
            }
        });

        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month_txt.setText("" + ans);
                total_emi.setText("" + totalint);
                total_pay.setText("" + tpay);
            }
        });
    }
}