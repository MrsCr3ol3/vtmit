package edu.vt.cs.cs5254.multiquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private final static int DEFAULT_COLOR = 0xff00a2ff;
    private final static int SELECTED_COLOR = 0xffcb297b;
    private int hintCounter = 0;
    private List<Integer> hintRandomNumber;
    private int questionSet = 0;
    private int totalHint = 0;
    private int totalCorrect = 0;
    private int totalQuestion = 0;


    // Model --> State of the answers
    private List<Answer> mAnswers;

    // View --> User Interface Objects
    private TextView mQuestionTextView;
    private List<Button> mAnswerButtons;
    private Button mHintButton;
    private Button mSubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hintRandomNumber = new ArrayList<>();

        mAnswers = Answer.createAnswers(questionSet);


        mQuestionTextView = findViewById(R.id.question_textview);
        mHintButton = findViewById(R.id.hint_button);
        mSubmitButton = findViewById(R.id.submit_button);

        mAnswerButtons = Arrays.asList(
                findViewById(R.id.answer_button0),
                findViewById(R.id.answer_button1),
                findViewById(R.id.answer_button2),
                findViewById(R.id.answer_button3)
        );

        mQuestionTextView.setText(R.string.question_aus_capital);
        mHintButton.setText(R.string.hint_button);
        mSubmitButton.setText(R.string.submit_button);

        mHintButton.setOnClickListener(v -> processHint());
        mSubmitButton.setOnClickListener(v -> processSubmit());
        disableButton(mSubmitButton);
        setSelectedStyle(mSubmitButton);

        mAnswerButtons.get(0).setOnClickListener(v -> processSelectedAnswer(0));
        mAnswerButtons.get(1).setOnClickListener(v -> processSelectedAnswer(1));
        mAnswerButtons.get(2).setOnClickListener(v -> processSelectedAnswer(2));
        mAnswerButtons.get(3).setOnClickListener(v -> processSelectedAnswer(3));



        refreshView();
    }

    private void refreshView() {
        // Drive the view from the model
        for (int i = 0; i < mAnswers.size(); i++) {
            Answer a = mAnswers.get(i);
            Button b = mAnswerButtons.get(i);
            b.setText(a.getTextResourceId());

            if (a.isEnabled()) {
                enableButton(b);
                if (a.isSelected()) {
                    setSelectedStyle(b);
                    setEnableSubmitButton(mSubmitButton);
                } else {
                    setDefaultStyle(b);
                }
            } else {
                disableButton(b);
            }
        }
    }

    private void processSelectedAnswer(int selectedAnswerIndex) {
        for (int i = 0; i < mAnswers.size(); i++) {
            Answer answer = mAnswers.get(i);
            answer.setSelected(false);
        }
        mAnswers.get(selectedAnswerIndex).setSelected(true);
        refreshView();
    }

    private void processSubmit() {

        for (int i = 0; i < mAnswers.size(); i++) {
            Answer a = mAnswers.get(i);
            if(a.isCorrect() && a.isSelected()) {
                totalCorrect++;
            }
        }


        for (int i = 0; i < mAnswers.size(); i++) {
            Answer a = mAnswers.get(i);
            a.setSelected(false);
            a.setEnabled(true);
        }
        if (questionSet < 3) {
            questionSet++;
            totalQuestion++;
            if (questionSet == 1) { mQuestionTextView.setText(R.string.question_us_capital);}
            else { mQuestionTextView.setText(R.string.question_korea_capital);}

            mAnswers = Answer.createAnswers(questionSet);
        }

        hintRandomNumber.clear();
        hintCounter = 0;
        mSubmitButton.setEnabled(false);
        setSelectedStyle(mSubmitButton);
        mHintButton.setEnabled(true);


        Log.d("question set", "this is current qeestion set:" + questionSet);

        if (questionSet == 3) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("Total_Correct", totalCorrect);
            intent.putExtra("Total_Hint", totalHint);
            intent.putExtra("Total_Question", totalQuestion);
            startActivity(intent);}

        refreshView();


    }

    private void processHint() {

        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        hintRandomNumber.add(randomNumber);


        Log.d("first rand", "this is first rand  "+randomNumber);

        if (!mAnswers.get(randomNumber).isEnabled() || mAnswers.get(randomNumber).isCorrect())
        {
            while (hintRandomNumber.contains(randomNumber)) {
                randomNumber = rand.nextInt(4);
            }
            hintRandomNumber.add(randomNumber);
            Log.d("second rand", "this is second rand  "+randomNumber);
        }


        for (int i = 0; i < mAnswers.size(); i++) {
            Answer a = mAnswers.get(randomNumber);
            if (!a.isCorrect()) {
                a.setEnabled(false);
            }
        }
        hintCounter++;

        if (hintCounter == 3) {
            mHintButton.setEnabled(false);
        }

        totalHint++;
        refreshView();
    }

    // View style methods

    private void enableButton(Button button) {
        button.setEnabled(true);
        button.setTextColor(Color.WHITE);
        button.getBackground().clearColorFilter();
    }

    private void disableButton(Button button) {
        button.setEnabled(false);
        button.getBackground().clearColorFilter();
        button.setTextColor(0xff999999);
    }

    private void setDefaultStyle(Button button) {
        button.getBackground().setColorFilter(DEFAULT_COLOR, PorterDuff.Mode.MULTIPLY);
        button.setTextColor(Color.WHITE);
    }

    private void setSelectedStyle(Button button) {
        button.getBackground().setColorFilter(SELECTED_COLOR, PorterDuff.Mode.MULTIPLY);
        button.setTextColor(Color.WHITE);
    }

    private void setEnableSubmitButton (Button button) {
        button.setEnabled(true);
        button.setTextColor(Color.WHITE);
        button.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
    }

    private boolean containsInt (int[] array, int intToSearch) {
        for (int element:array) {
            if ( element == intToSearch ) {
                return true;
            }

        }
        return false;
    }


}
