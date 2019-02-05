package edu.vt.cs.cs5254.dreamcatcher.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DreamLab {

    private static DreamLab sDreamLab;
    private List<Dream> mDreams;

    public static DreamLab getInstance(Context context) {
        if (sDreamLab == null) { sDreamLab = new DreamLab(context); }
        return sDreamLab;
    }

    private DreamLab(Context context) {

        mDreams = new ArrayList<>();

        Dream dream0 = new Dream();
        dream0.setTitle("My First Dream");
        dream0.addComment("Comment 1");
        dream0.addComment("Comment 2");
        dream0.addComment("Comment 3");
        dream0.addDreamRealized();
        dream0.setRealized(true);
        mDreams.add(dream0);

        Dream dream1 = new Dream();
        dream1.setTitle("My Second Dream");
        dream1.addComment("Comment 1");
        dream1.addComment("Comment 2");
        dream1.addDreamDeferred();
        dream1.setDeferred(true);
        dream1.addComment("Comment 3");
        mDreams.add(dream1);

        Dream dream2 = new Dream();
        dream2.setTitle("My Third Dream");
        dream2.addComment("Comment 1");
        dream2.addComment("Comment 2");
        dream2.addDreamRealized();
        dream2.setRealized(true);
        mDreams.add(dream2);

        for (int i = 0; i < 20; i++) {
            Dream dream = new Dream();
            dream.setTitle("Dream #" + i);

            dream.setDeferred(i % 5 == 0);
            dream.setRealized(i % 4 == 0); // Every other one
            mDreams.add(dream);
        }
    }

    public List<Dream> getDreams() { return mDreams; }

    public Dream getDream(UUID id) {
        for (Dream dream : mDreams) {
            if (dream.getId().equals(id)) { return dream; }
        }
        return null;
    }
}