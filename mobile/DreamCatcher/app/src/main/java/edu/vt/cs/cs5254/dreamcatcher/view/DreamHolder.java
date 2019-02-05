package edu.vt.cs.cs5254.dreamcatcher.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import edu.vt.cs.cs5254.dreamcatcher.R;
import edu.vt.cs.cs5254.dreamcatcher.controller.DreamActivity;
import edu.vt.cs.cs5254.dreamcatcher.model.Dream;


public class DreamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //model field

    private Dream mDream;

    //view field
    private TextView mTitleTextView;
    private TextView mDateTextView;
    private ImageView mRealizedImage;
    private ImageView mDeferredImage;


    public DreamHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.list_item_dream, parent, false));

        itemView.setOnClickListener(this);

        mTitleTextView = itemView.findViewById(R.id.dream_title);

        mDateTextView = itemView.findViewById(R.id.dream_entry_0);

        mRealizedImage = itemView.findViewById(R.id.imageView);
        mRealizedImage.setVisibility(View.GONE);
        mDeferredImage = itemView.findViewById(R.id.imageView2);
        mDeferredImage.setVisibility(View.GONE);



    }

    public void bind(Dream dream) {
        mDream = dream;
        DateFormat formatter;

        formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String toDay = formatter.format(mDream.getRevealedDate());

        mTitleTextView.setText(mDream.getTitle());
        mDateTextView.setText(toDay);

        if (dream.isRealized()) {
            mRealizedImage.setVisibility(View.VISIBLE);
            mDeferredImage.setVisibility(View.GONE);
        }
        else if (dream.isDeferred()) {
            mDeferredImage.setVisibility(View.VISIBLE);
            mRealizedImage.setVisibility(View.GONE);
        }

        else {
            mRealizedImage.setVisibility(View.GONE);
            mDeferredImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        //Intent intent = new Intent(view.getContext(), DreamActivity.class);
        Intent intent = DreamActivity.newIntent(view.getContext(), mDream.getId());
        view.getContext().startActivity(intent);

    }
}
