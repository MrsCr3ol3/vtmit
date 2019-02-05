package edu.vt.cs.cs5254.multiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView mTotalHint;
    private TextView mTotalCorrect;
    private TextView mTotalQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mTotalCorrect = findViewById(R.id.totalCorrectAnswer);
        mTotalHint = findViewById((R.id.totalHintUsed));
        mTotalQuestion = findViewById(R.id.totalQuestion);

        Intent intent = getIntent();

        int totalCorrectAnswer = intent.getIntExtra("Total_Correct", 0);
        int totalHintUsed = intent.getIntExtra("Total_Hint", 0);
        int totalQuestion = intent.getIntExtra("Total_Question",0);

        mTotalQuestion.setText("Total Question Asked: " + Integer.toString(totalQuestion));
        mTotalHint.setText("Total Hint Used :" + Integer.toString(totalHintUsed));
        mTotalCorrect.setText("Total Correct Answers: " + Integer.toString(totalCorrectAnswer));




    }
}
