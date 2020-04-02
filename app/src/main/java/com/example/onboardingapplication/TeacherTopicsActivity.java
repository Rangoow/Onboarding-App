package com.example.onboardingapplication;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TeacherTopicsActivity extends AppCompatActivity {

    private ViewPager screenPager;
    SlidePageAdapter slidePageAdapter;
    TabLayout pageIndicator;
    Button btnNext;
    int position = 0;
    private ValueAnimator valueAnimator;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Window window =this.getWindow();
        //make activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        //hide action bar
        getSupportActionBar().hide();
        //ini views
        btnNext = findViewById(R.id.button_next);
        pageIndicator = findViewById(R.id.page_Indicator);


        //fill list screen

        final List<TopicItem> list = new ArrayList<>();
        list.add(new TopicItem(getString(R.string.topic_visit_title),getString(R.string.visit_text),R.drawable.ic_localization));
        list.add(new TopicItem(getString(R.string.topic_information_title),getString(R.string.information_text),R.drawable.ic_informations));
        list.add(new TopicItem(getString(R.string.topic_administration_title),getString(R.string.administration_text_teacher),R.drawable.ic_administration));
        list.add(new TopicItem(getString(R.string.topic_network_title),getString(R.string.network_text),R.drawable.ic_network));
        list.add(new TopicItem(getString(R.string.topic_places_title),getString(R.string.places_text),R.drawable.ic_localization));
        list.add(new TopicItem(getString(R.string.topic_lunch_title),getString(R.string.lunch_text),R.drawable.ic_lunch));
        list.add(new TopicItem(getString(R.string.topic_entertainment_title),getString(R.string.entertainment_text),R.drawable.ic_entertainement));
        list.add(new TopicItem(getString(R.string.topic_toilets_title),getString(R.string.toilets_text),R.drawable.ic_toilet));
        list.add(new TopicItem(getString(R.string.topic_feedback_title),getString(R.string.feedback_text),R.drawable.ic_feedback));


        //setup viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        slidePageAdapter = new SlidePageAdapter(this,list);
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

                if (position == list.size()){ //when reach last screen
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
                getResources().getColor(R.color.topic7Backgroundcolor),
                getResources().getColor(R.color.topic8Backgroundcolor),
                getResources().getColor(R.color.topic9Backgroundcolor),
                getResources().getColor(R.color.topic10Backgroundcolor));


        valueAnimator.setDuration((10-1)*10000000000l);

        screenPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                valueAnimator.setCurrentPlayTime((long)((positionOffset + position)*10000000000l));
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
                window.setStatusBarColor((Integer)animation.getAnimatedValue());
            }
        }));

    }
}
