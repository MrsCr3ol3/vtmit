package edu.vt.cs.cs5254.answerbuttonwalk;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ButtonActivity extends AppCompatActivity {

    private final static int DEFAULT_COLOR = 0xff00a2ff;
    private final static int SELECTED_COLOR = 0xffcb297b;

    // Model --> State of the answers
    private List<Answer> mAnswers;

    // View --> User Interface Objects
    private TextView mQuestionTextView;
    private List<Button> mAnswerButtons;
    private Button mDisableButton;
    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // Set up model
        mAnswers = Answer.createSampleAnswers();

        // Set up view
        mQuestionTextView = findViewById(R.id.question_textview);
        mDisableButton = findViewById(R.id.disable_button);
        mResetButton = findViewById(R.id.reset_button);
        mAnswerButtons = Arrays.asList(
                findViewById(R.id.answer_button0),
                findViewById(R.id.answer_button1),
                findViewById(R.id.answer_button2),
                findViewById(R.id.answer_button3)
        );
        mQuestionTextView.setText(R.string.question_australia_capital);
        mDisableButton.setText(R.string.disable_button_name);
        mResetButton.setText(R.string.reset_button_name);

        mDisableButton.setOnClickListener(v -> processDisable());
        mResetButton.setOnClickListener(v -> processReset());

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

    private void processReset() {
        for (int i = 0; i < mAnswers.size(); i++) {
            Answer a = mAnswers.get(i);
            a.setSelected(false);
            a.setEnabled(true);
        }
        refreshView();
    }

    private void processDisable() {
        int count = 0;
        for (int i = 0; count < 2 && i < mAnswers.size(); i++) {
            Answer a = mAnswers.get(i);
            if (!a.isCorrect()) {
                a.setEnabled(false);
                count++;
            }
        }
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

}
