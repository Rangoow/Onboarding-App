package com.example.onboardingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SlidePageAdapter extends PagerAdapter {

    Context context;
    List<TopicItem> ListScreen;

    public SlidePageAdapter(Context context, List<TopicItem> listScreen) {
        this.context = context;
        ListScreen = listScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen,null);
        ImageView imgSlide = layoutScreen.findViewById(R.id.topic_img);
        TextView topicTitle = layoutScreen.findViewById(R.id.topic_title);
        TextView topicDesc = layoutScreen.findViewById(R.id.topic_description);

        topicTitle.setText(ListScreen.get(position).getTitle());
        topicDesc.setText(ListScreen.get(position).getDescription());
        imgSlide.setImageResource(ListScreen.get(position).getScreenImg());

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
