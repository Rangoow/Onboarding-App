package com.example.onboardingapplication.Activities.Student.Admin;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.onboardingapplication.Adapters.Pager.AdminPagerAdapter;
import com.example.onboardingapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class AdminStudentActivityBis extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdminPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_bis);

        //FULL SCREEN + BACKGROUND COLOR
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic3Backgroundcolor));

        tabLayout = (TabLayout) findViewById(R.id.adminStudentTabLayout);
        viewPager =(ViewPager) findViewById(R.id.adminChoicePager);
        adapter =  new AdminPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentAdminDirection(),getResources().getString(R.string.admin_tab_1));
        adapter.AddFragment(new FragmentAdminCycle(),getResources().getString(R.string.admin_tab_2));
        adapter.AddFragment(new FragmentAdminDomains(),getResources().getString(R.string.admin_tab_3));
        adapter.AddFragment(new FragmentAdminUseful(),getResources().getString(R.string.admin_tab_4));



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
