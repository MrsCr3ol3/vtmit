package edu.vt.cs.cs5254.answerbuttonwalk;

import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class Answer {

    private int mTextResourceId;
    private boolean mSelected;
    private boolean mCorrect;
    private boolean mEnabled;

    public Answer(int textResourceId, boolean correct) {
        mTextResourceId = textResourceId;
        mCorrect = correct;
        mEnabled = true;
        mSelected = false;
    }

    public int getTextResourceId() {
        return mTextResourceId;
    }

    public boolean isCorrect() {
        return mCorrect;
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        mSelected = selected;
    }

    public boolean isEnabled() {
        return mEnabled;
    }

    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    public static List<Answer> createSampleAnswers() {
        return Arrays.asList(
                new Answer(R.string.answer_brisbane, false),
                new Answer(R.string.answer_canberra, true),
                new Answer(R.string.answer_perth, false),
                new Answer(R.string.answer_sydney, false)
        );
    }
}
