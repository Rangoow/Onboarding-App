package com.example.onboardingapplication.Activities.Student;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.onboardingapplication.Activities.Both.HomeActivity;
import com.example.onboardingapplication.Adapters.Topics.EntertainmentAdapter;
import com.example.onboardingapplication.R;

import java.util.Objects;

public class AdminActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] administrationNameList;
    String[] administrationLocList;
    String[] administrationDescList;
    int images[] = {R.drawable.ic_administration,
            R.drawable.ic_administration,
            R.drawable.ic_administration,
            R.drawable.ic_administration,
            R.drawable.ic_administration};
    Button homeBtn;
    TextView topicTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //SET home Button + topic title
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic5Backgroundcolor));

        //Set up recycler view
        homeBtn = findViewById(R.id.detailsHomebtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        topicTitle = findViewById(R.id.detailsTopicTitle);
        topicTitle.setText(R.string.topic_administration_title);

        //Set up recycler view
        recyclerView = findViewById(R.id.recyclerView_Details);

        administrationNameList = getResources().getStringArray(R.array.administration_name_list);
        administrationLocList = getResources().getStringArray(R.array.administration_loc_list);
        administrationDescList = getResources().getStringArray(R.array.administration_desc_list);

        EntertainmentAdapter entertainmentAdapter = new EntertainmentAdapter(this,administrationNameList,administrationLocList,administrationDescList,images);
        recyclerView.setAdapter(entertainmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
