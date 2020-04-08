package com.example.onboardingapplication.Activities.Teacher;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.onboardingapplication.Activities.Both.HomeActivity;
import com.example.onboardingapplication.Adapters.SlidePagerTeacherAdapter;
import com.example.onboardingapplication.R;
import com.example.onboardingapplication.TopicPagerItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeacherTopicsActivity extends AppCompatActivity {

    private ViewPager screenPager;
    SlidePagerTeacherAdapter slidePageAdapter;
    TabLayout pageIndicator;
    Button btnNext;
    int position = 0;
    private ValueAnimator valueAnimator;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //make activity full screen
        Objects.requireNonNull(getSupportActionBar()).hide();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //set view
        setContentView(R.layout.activity_topics);

        //hide action bar

        //ini views
        btnNext = findViewById(R.id.topicNextBtn);
        pageIndicator = findViewById(R.id.topicPageIndicator);


        //fill list screen

        final List<TopicPagerItem> list = new ArrayList<>();
        list.add(new TopicPagerItem(getString(R.string.topic_visit_title),getString(R.string.visit_text),R.drawable.ic_localization));
        list.add(new TopicPagerItem(getString(R.string.topic_information_title),getString(R.string.information_text),R.drawable.ic_informations));
        list.add(new TopicPagerItem(getString(R.string.topic_administration_title),getString(R.string.administration_text_student),R.drawable.ic_administration));
        list.add(new TopicPagerItem(getString(R.string.topic_network_title),getString(R.string.network_text),R.drawable.ic_network));
        list.add(new TopicPagerItem(getString(R.string.topic_places_title),getString(R.string.places_text),R.drawable.ic_localization));
        list.add(new TopicPagerItem(getString(R.string.topic_lunch_title),getString(R.string.lunch_text),R.drawable.ic_lunch));
        list.add(new TopicPagerItem(getString(R.string.topic_market_title),getString(R.string.market_text),R.drawable.ic_market));
        list.add(new TopicPagerItem(getString(R.string.topic_toilets_title),getString(R.string.toilets_text),R.drawable.ic_toilet));
        list.add(new TopicPagerItem(getString(R.string.topic_feedback_title),getString(R.string.feedback_text),R.drawable.ic_feedback));


        //setup viewpager
        screenPager = findViewById(R.id.topicViewPager);
        slidePageAdapter = new SlidePagerTeacherAdapter(this,list);
        screenPager.setAdapter(slidePageAdapter);


        //setup tablayout with viewpager

        pageIndicator.setupWithViewPager(screenPager);

        //next button click listener

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < list.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                else if (position == list.size()){ //when reach last screen
                    //nothing for the moment
                    //IDEA
                    //But can hide page indicator and next button to display a Start Visit button and start the visit
                }
            }
        });

        //Gradient color animatin

        valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(),
                getResources().getColor(R.color.topic1Backgroundcolor),
                getResources().getColor(R.color.topic2Backgroundcolor),
                getResources().getColor(R.color.topic3Backgroundcolor),
                getResources().getColor(R.color.topic4Backgroundcolor),
                getResources().getColor(R.color.topic5Backgroundcolor),
                getResources().getColor(R.color.topic6Backgroundcolor),
                getResources().getColor(R.color.topic8Backgroundcolor),
                getResources().getColor(R.color.topic9Backgroundcolor),
                getResources().getColor(R.color.topic10Backgroundcolor));


        valueAnimator.setDuration((8-1)* 10000000000L);

        screenPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                valueAnimator.setCurrentPlayTime((long)((positionOffset + position)*10000000000L));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        valueAnimator.addUpdateListener((new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                screenPager.setBackgroundColor((Integer)animation.getAnimatedValue());
            }
        }));

        Button startActivityHome = findViewById(R.id.topicHomebtn);
        startActivityHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
