package com.example.onboardingapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.onboardingapplication.Activities.Both.FeedbackActivity;
import com.example.onboardingapplication.Activities.Both.ToiletsActivity;
import com.example.onboardingapplication.R;
import com.example.onboardingapplication.TopicItem;

import java.util.List;

public class SlidePagerStudentAdapter extends PagerAdapter {

    Context context;
    List<TopicItem> ListScreen;

    public SlidePagerStudentAdapter(Context context, List<TopicItem> listScreen) {
        this.context = context;
        ListScreen = listScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.item_topic,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.topicImg);
        final TextView topicTitle = layoutScreen.findViewById(R.id.topicTitleTxt);
        TextView topicDesc = layoutScreen.findViewById(R.id.topicDescriptionTxt);

        topicTitle.setText(ListScreen.get(position).getTopicTitle());
        topicDesc.setText(ListScreen.get(position).getTopicDescription());
        imgSlide.setImageResource(ListScreen.get(position).getTopicScreenImg());

        Button moreInfoBtn;
        moreInfoBtn = layoutScreen.findViewById(R.id.moreInfobtn);
        moreInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        context.startActivity(new Intent(context, ToiletsActivity.class));
                        break;
                    case 9:
                        context.startActivity(new Intent(context, FeedbackActivity.class));
                        break;
                }
            }
        });



        container.addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return ListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
