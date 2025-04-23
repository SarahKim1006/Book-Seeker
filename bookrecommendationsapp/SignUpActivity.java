package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookrecommendationsapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    EditText signUpPassword, signupUsername, signUpGenre, signUpName, signUpAge;
    Button signUpContinueButton;

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_sign_up);

        signUpPassword = findViewById(R.id.signUpPassword);
        signupUsername = findViewById(R.id.signupUsername);
        signUpName = findViewById(R.id.signUpName);
        signUpAge = findViewById(R.id.signUpAge);


        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.signUpContinueButton);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
                Intent intent = new Intent(SignUpActivity.this, VocabularyQuizActivity.class);
                startActivity(intent); // starting sign up activity
            }
        });


//        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sign_up);

    }
}