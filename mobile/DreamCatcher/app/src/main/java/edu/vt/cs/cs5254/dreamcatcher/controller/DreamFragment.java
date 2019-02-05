package edu.vt.cs.cs5254.dreamcatcher.controller;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.List;
import java.util.UUID;

import edu.vt.cs.cs5254.dreamcatcher.R;
import edu.vt.cs.cs5254.dreamcatcher.model.Dream;
import edu.vt.cs.cs5254.dreamcatcher.model.DreamEntry;
import edu.vt.cs.cs5254.dreamcatcher.model.DreamLab;


public class DreamFragment extends Fragment {

    private static final int REALIZED_COLOR = 0xff008f00;
    private static final int COMMENT_COLOR = 0xffffd479;
    private static final int REVEALED_COLOR = 0xff6ef0ff;
    private static final int DEFERRED_COLOR = 0xffFF0000;

    private static String ARG_DREAM_ID = "dream_id";

    //model

    private Dream mDream;
    //view
    private EditText mTitleField;
    private CheckBox mRealizedCheckBox;
    private CheckBox mDeferredCheckBox;
    private Button mEntryButton0;
    private Button mEntryButton1;
    private Button mEntryButton2;
    private Button mEntryButton3;
    private Button mEntryButton4;

    public static Fragment newInstance(UUID dreamId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DREAM_ID, dreamId);
        DreamFragment fragment = new DreamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID dreamId = (UUID) getArguments().getSerializable(ARG_DREAM_ID);
        mDream = DreamLab.getInstance(getActivity()).getDream(dreamId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dream, container, false);

        mTitleField = view.findViewById(R.id.dream_title);

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDream.setTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRealizedCheckBox = view.findViewById(R.id.dream_realized);
        mRealizedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // add the DR message
                if (!mDream.isRealized()) {mDream.addDreamRealized();}
            }
            else {
                //Remove DR message
                if (mDream.isRealized()) {mDream.removeDreamRealized();}
            }
            mDream.setRealized(isChecked);
            refreshView();
        });

        mDeferredCheckBox = view.findViewById(R.id.dream_deferred);
        mDeferredCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (!mDream.isDeferred()) {mDream.addDreamDeferred();}
            }
            else {
                if (mDream.isDeferred()) {mDream.removeDreamDeferred();}
            }
            mDream.setDeferred(isChecked);
            refreshView();

        });

        mEntryButton0 = view.findViewById(R.id.dream_entry_0);
        mEntryButton0.setEnabled(false);
        mEntryButton1 = view.findViewById(R.id.dream_entry_1);
        mEntryButton1.setEnabled(false);
        mEntryButton2 = view.findViewById(R.id.dream_entry_2);
        mEntryButton2.setEnabled(false);
        mEntryButton3 = view.findViewById(R.id.dream_entry_3);
        mEntryButton3.setEnabled(false);
        mEntryButton4 = view.findViewById(R.id.dream_entry_4);
        mEntryButton4.setEnabled(false);

        refreshView();

        return view;

    }

    private void refreshView() {
        if (mDream.getTitle() != null) {
            mTitleField.setText(mDream.getTitle());
        }

        mRealizedCheckBox.setChecked(mDream.isRealized());
        if (mDream.isRealized() && !mDream.isDeferred()){

            mDeferredCheckBox.setEnabled(false);
        }

        mDeferredCheckBox.setChecked(mDream.isDeferred());
        if (mDream.isDeferred() && !mDream.isRealized()){
            mRealizedCheckBox.setEnabled(false);
        }

        if (!mDream.isRealized() && !mDream.isDeferred()) {
            mDeferredCheckBox.setEnabled(true);
            mRealizedCheckBox.setEnabled(true);
        }

        refreshEntryButtons();

        List<DreamEntry> entries = mDream.getDreamEntries();
        for (DreamEntry e : entries) {
            Log.d("refreshView", e.getText());
        }

    }

    private void refreshEntryButtons() {
        refreshEntryButton(mEntryButton0,0);
        refreshEntryButton(mEntryButton1,1);
        refreshEntryButton(mEntryButton2,2);
        refreshEntryButton(mEntryButton3,3);
        refreshEntryButton(mEntryButton4,4);

    }

    private void refreshEntryButton(Button button, int position) {
        //position should not be greater than the last position

        int lastPosition = mDream.getDreamEntries().size() - 1;

        if (position > lastPosition) {
            button.setVisibility(View.GONE);
            return;
        }

        button.setVisibility(View.VISIBLE);
        DreamEntry entry = mDream.getDreamEntries().get(position);

        switch (entry.getKind()) {
            case REVEALED:
                setRevealedStyle(button);
                button.setText(entry.getText());
                break;
            case DEFERRED:
                //do something
                setDeferredStyle(button);
                button.setText(entry.getText());
                break;
            case REALIZED:
                setRealizedStyle(button);
                button.setText(entry.getText());
                break;
            case COMMENT:
                setCommentStyle(button);
                String text = entry.getText();
                DateFormat formatter;

                formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
                String toDay = formatter.format(mDream.getRevealedDate());

                button.setText(text + " (" + toDay + ")");
        }

    }

    private void setDeferredStyle(Button button) {
        button.getBackground().setColorFilter(DEFERRED_COLOR, PorterDuff.Mode.MULTIPLY);
        button.setTextColor(Color.WHITE);
    }

    private void setRevealedStyle(Button button) {
        button.getBackground().setColorFilter(REVEALED_COLOR, PorterDuff.Mode.MULTIPLY);
        button.setTextColor(Color.WHITE);
    }

    private void setRealizedStyle(Button button) {
        button.getBackground().setColorFilter(REALIZED_COLOR, PorterDuff.Mode.MULTIPLY);
        button.setTextColor(Color.WHITE);
    }

    private void setCommentStyle(Button button) {
        button.getBackground().setColorFilter(COMMENT_COLOR, PorterDuff.Mode.MULTIPLY);
        button.setTextColor(Color.BLACK);
    }




}
