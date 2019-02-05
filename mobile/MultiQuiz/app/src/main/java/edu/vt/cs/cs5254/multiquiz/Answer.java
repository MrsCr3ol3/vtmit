package edu.vt.cs.cs5254.multiquiz;

import java.util.Arrays;
import java.util.List;

/**
 * Created by HYUK on 2/6/2018.
 */

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

    public static List<Answer> createAnswers(int i) {
        if (i == 0) {
            return Arrays.asList(
                    new Answer(R.string.answer_brisbane, false),
                    new Answer(R.string.answer_canberra, true),
                    new Answer(R.string.answer_perth, false),
                    new Answer(R.string.answer_sydney, false)
            );
        }

        else if (i == 1) {
            return Arrays.asList(
                    new Answer(R.string.answer_washington, true),
                    new Answer(R.string.answer_newyork, false),
                    new Answer(R.string.answer_atl, false),
                    new Answer(R.string.answer_dallas, false)
            );
        }

        return Arrays.asList(
                new Answer(R.string.answer_incheon, false),
                new Answer(R.string.answer_daegu, false),
                new Answer(R.string.answer_seoul, true),
                new Answer(R.string.answer_pusan, false)
        );

    }
}
