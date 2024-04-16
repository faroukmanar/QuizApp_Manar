package com.example.quizapp_manar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz4 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score;
    String RepCorrect = "Le tramway est arrêté";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        rg = findViewById(R.id.rg4);
        bNext = findViewById(R.id.button_next4);
        score = getIntent().getIntExtra("score", 0);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = findViewById(rg.getCheckedRadioButtonId());
                if (rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please choose an answer", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(rb.getText().toString().equals(RepCorrect)){
                        score += 1;
                    }
                }
                startActivity(new Intent(Quiz4.this, Quiz5.class).putExtra("score", score));
                finish();
            }
        });
    }


}