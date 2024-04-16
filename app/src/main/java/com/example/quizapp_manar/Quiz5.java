package com.example.quizapp_manar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz5 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score;
    String RepCorrect = "Non";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        rg = findViewById(R.id.rg5);
        bNext = findViewById(R.id.button_next5);
        score = getIntent().getIntExtra("score", 0);

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = findViewById(rg.getCheckedRadioButtonId());
                if (rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please Choose an Answer", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(rb.getText().toString().equals(RepCorrect)){
                        score += 1;
                    }
                    startActivity(new Intent(Quiz5.this, Score.class).putExtra("score", score));
                    overridePendingTransition(0, 0);
                }
            }
        });
    }


}