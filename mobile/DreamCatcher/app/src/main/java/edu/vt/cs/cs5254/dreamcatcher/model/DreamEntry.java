package edu.vt.cs.cs5254.dreamcatcher.model;

import java.util.Date;

public class DreamEntry {

    private String mText;
    private Date mDate;
    private DreamEntryKind mKind;

    public DreamEntry(String text, Date date, DreamEntryKind kind) {
        mText = text;
        mDate = date;
        mKind = kind;
    }

    public String getText() {
        return mText;
    }

    public Date getDate() {
        return mDate;
    }

    public DreamEntryKind getKind() {
        return mKind;
    }
}
