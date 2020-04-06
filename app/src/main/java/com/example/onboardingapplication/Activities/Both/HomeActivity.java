package com.example.onboardingapplication.Activities.Both;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onboardingapplication.Activities.Student.StudentTopicsActivity;
import com.example.onboardingapplication.Activities.Teacher.TeacherTopicsActivity;
import com.example.onboardingapplication.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }



        Button startActivityButton = (Button) findViewById(R.id.homeStudentBtn);
        startActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentTopicsActivity.class);
                startActivity(intent);
            }
        });

        Button startActivityButton2 = (Button) findViewById(R.id.homeTeacherBtn);
        startActivityButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeacherTopicsActivity.class);
                startActivity(intent);
            }
        });
    }
}

