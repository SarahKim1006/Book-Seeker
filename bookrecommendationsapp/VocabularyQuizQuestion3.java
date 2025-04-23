package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class VocabularyQuizQuestion3 extends AppCompatActivity {

    private RadioGroup radioGroup3;
    private boolean question3Correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vocabulary_quiz_question3);

        radioGroup3 = findViewById(R.id.question3);

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // on below line we are getting radio button from our group.
                RadioButton checkedradioButton = findViewById(checkedId);
                if (checkedradioButton.getText().toString().equals("coalesce")) {
                    question3Correct = true;
//                    Toast.makeText(VocabularyQuizQuestion3.this, "Question 3 correct",
//                            Toast.LENGTH_LONG).show();
                } else {
                    question3Correct = false;
                }
            }
        });
        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.summitButton);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
                Intent intent = new Intent(VocabularyQuizQuestion3.this, ReadingLevel.class);
                startActivity(intent); // starting sign up activity
            }
        });
    }
}


