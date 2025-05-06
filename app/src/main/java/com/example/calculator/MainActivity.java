package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2, editTextResult;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextResult = findViewById(R.id.editTextResult);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            editTextResult.setText("لطفاً اعداد را وارد کنید");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    editTextResult.setText("تقسیم بر صفر مجاز نیست");
                    return;
                }
                result = num1 / num2;
                break;
        }

        editTextResult.setText(String.valueOf(result));
    }
}
