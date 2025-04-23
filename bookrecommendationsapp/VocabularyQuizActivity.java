package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class VocabularyQuizActivity extends AppCompatActivity {
    private RadioGroup radioGroup1;
    private boolean question1Correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vocabulary_quiz);

        radioGroup1 = findViewById(R.id.question1);

        // on below line we are adding check change listener for our radio group.
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // on below line we are getting radio button from our group.
                RadioButton checkedradioButton = findViewById(checkedId);
                if (checkedradioButton.getText().toString().equals("ease")) {
                    question1Correct = true;
//                    Toast.makeText(VocabularyQuizActivity.this, "Question 1 correct",
//                            Toast.LENGTH_LONG).show();
                } else {
                    question1Correct = false;
                }
            }
        });

        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.summitButton);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
                if(question1Correct == true) {
                    Intent intent = new Intent(VocabularyQuizActivity.this, VocabularyQuizQuestion2.class);
                    startActivity(intent); // starting sign up activity
                } else {
                    Intent intent = new Intent(VocabularyQuizActivity.this, Homepage.class);
                    startActivity(intent); // starting sign up activity
                }
            }
        });
    }
}