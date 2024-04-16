package com.example.quizapp_manar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_Register extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail,signupPassword;
    private Button signupButton;
    private TextView loginRedirectText;

    public activity_Register() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.signup_email);
        //signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = signupEmail.getText().toString().trim();
                //String userName = signupUsername.getText().toString().trim();
                String userPassword = signupPassword.getText().toString().trim();


                if(userEmail.isEmpty()){
                    signupEmail.setError("Email Cant be Empty");
                }
                if(userPassword.isEmpty()){
                    signupEmail.setError("Password Cant be Empty");
                }else {
                    auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(activity_Register.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(activity_Register.this,MainActivity.class));
                            }else{
                                Toast.makeText(activity_Register.this, "SignUp Failed" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_Register.this, MainActivity.class));
            }
        });
    }
}