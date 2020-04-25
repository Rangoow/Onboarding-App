package com.example.onboardingapplication.Activities.Student.Admin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.onboardingapplication.Activities.Both.HomeActivity;
import com.example.onboardingapplication.Adapters.Admin.AdminStudentAdapter;
import com.example.onboardingapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class AdminStudentActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdminStudentAdapter adapter;
    Button homeBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student);

        //FULL SCREEN + BACKGROUND COLOR
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic3Backgroundcolor));

        tabLayout = findViewById(R.id.adminStudentTabLayout);
        viewPager = findViewById(R.id.adminChoicePager);
        adapter =  new AdminStudentAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentAdminDirection(),getResources().getString(R.string.admin_tab_1));
        adapter.AddFragment(new FragmentAdminCycle(),getResources().getString(R.string.admin_tab_2));
        adapter.AddFragment(new FragmentAdminDomains(),getResources().getString(R.string.admin_tab_3));
        adapter.AddFragment(new FragmentAdminUseful(),getResources().getString(R.string.admin_tab_4));



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //SET home Button + topic title
        homeBtn = findViewById(R.id.detailsAdminHomebtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
