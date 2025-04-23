package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class VocabularyQuizQuestion2 extends AppCompatActivity {

    private RadioGroup radioGroup2;
    private boolean question2Correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vocabulary_quiz_question2);

        radioGroup2 = findViewById(R.id.question2);

        radioGroup2.setOnCheckedChangeListener((group, checkedId) -> {
            // on below line we are getting radio button from our group.
            RadioButton checkedradioButton = findViewById(checkedId);
            if (checkedradioButton.getText().toString().equals("renown")) {
                question2Correct = true;
//                Toast.makeText(VocabularyQuizQuestion2.this, "Question 2 correct",
//                        Toast.LENGTH_LONG).show();
            } else {
                question2Correct = false;
            }
        });
        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.summitButton);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
//                if (question2Correct == true) {
                Intent intent = new Intent(VocabularyQuizQuestion2.this, VocabularyQuizQuestion3.class);
                startActivity(intent); // starting sign up activity
//                } else {
//                    Intent intent = new Intent(VocabularyQuizQuestion2.this, Homepage.class);
//                    startActivity(intent); // starting sign up activity
//                }
            }
        });
    }
}