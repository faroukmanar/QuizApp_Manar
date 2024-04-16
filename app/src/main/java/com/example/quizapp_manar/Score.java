package com.example.quizapp_manar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {
    Button bLogout, bTry;
    ProgressBar progressBar;
    TextView tvScore;
    int score;
    @SuppressLint("SetTextI18n")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        tvScore = findViewById(R.id.tvScore);
        progressBar = findViewById(R.id.progressBar);
        bLogout = findViewById(R.id.logout_button);
        bTry = findViewById(R.id.tryagain_button);
        score = getIntent().getIntExtra("score",0);
        progressBar.setProgress(100 * score / 5);
        tvScore.setText(100*score/5 + " %");

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thank you for participating", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this, Quiz1.class));
            }
        });
    }
}
