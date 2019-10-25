package codes.walid4444.lavaloon.toggl.RecyclerView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import codes.walid4444.lavaloon.toggl.Activities.MainActivity;
import codes.walid4444.lavaloon.toggl.R;
import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class ExpandableSection extends StatelessSection {

    public boolean expanded = false;
    String title;
    TimeEntryModel content;
    Context mContext;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public ExpandableSection(Context mContext, String title, TimeEntryModel content, int id) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.cat_sec_content)
                .headerResourceId(R.layout.cat_sec_header)
                .build());
        this.id = id;
        this.title = title;
        this.content = content;
        this.mContext=mContext;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TimeEntryModel getContent() {
        return content;
    }

    public void setContent(TimeEntryModel content) {
        this.content = content;
    }

    @Override
    public int getContentItemsTotal() {
        return expanded ? 1 : 0;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;
        itemHolder.duration.setText(content.getDuration());
        itemHolder.description.setText(content.getDescription());


        itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), CategeoryStoresAcivity.class).putExtra("id", id));
            }
        });


    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(final RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.titleText.setText(title);
        if (expanded)
            changeTextSize(headerHolder.titleText, 25, 30);
        else if (headerHolder.titleText.getTextSize() > 90) {
            changeTextSize(headerHolder.titleText, 30, 25);
        } else {
            changeTextSize(headerHolder.titleText, 25, 25);
        }

            if (headerHolder.titleText.getTextSize() > 50)
        changeTextSize(headerHolder.titleText, 30, 19);

        headerHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expanded) {
                    expanded = false;
                    MainActivity.sectionAdapter.notifyItemRemoved(MainActivity.sectionAdapter.getSectionPosition(ExpandableSection.this));
                    MainActivity.sectionAdapter.notifyItemChanged(MainActivity.sectionAdapter.getSectionPosition(ExpandableSection.this));
                } else {
                    for (int i = 0; i < MainActivity.expandableSections.size(); i++) {
                        MainActivity.expandableSections.get(i).expanded = false;
                        MainActivity.sectionAdapter.notifyItemChanged(i);
                    }
                    expanded = true;
                }
            }
        });
    }

    public void changeTextSize(final TextView textView, float PstartSize, float PendSize) {
        final float startSize = PstartSize; // Size in pixels
        final float endSize = PendSize;
        long animationDuration = 350; // Animation duration in ms
        ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
        animator.setDuration(animationDuration);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                textView.setTextSize(animatedValue);
                if (PendSize == 25) {
                    textView.setTextColor(mContext.getResources().getColor(R.color.colorWhiteGrey));
                } else {
                    textView.setTextColor(mContext.getResources().getColor(R.color.colorWhite));
                }
            }
        });
        animator.start();
    }

}
