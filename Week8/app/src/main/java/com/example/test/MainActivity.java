package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstNumberEditText, secondNumberEditText;
    Button addButton, subtractButton, multiplyButton, divideButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = (EditText) findViewById(R.id.firstNumberEditText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                int result = firstNumber + secondNumber;
                resultTextView.setText("Result: " + result);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                int result = firstNumber - secondNumber;
                resultTextView.setText("Result: " + result);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                int result = firstNumber * secondNumber;
                resultTextView.setText("Result: " + result);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                int result = firstNumber / secondNumber;
                resultTextView.setText("Result: " + result);
            }
        });
    }
}
