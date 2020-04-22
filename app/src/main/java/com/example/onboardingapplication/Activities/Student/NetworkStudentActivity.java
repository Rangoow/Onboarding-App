package com.example.onboardingapplication.Activities.Student;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboardingapplication.Activities.Both.HomeActivity;
import com.example.onboardingapplication.Adapters.Topics.AdminStudentAdapter;
import com.example.onboardingapplication.Adapters.Topics.NetworkAdapter;
import com.example.onboardingapplication.R;

import java.util.Objects;

public class NetworkStudentActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String NameList[], desList[], linkList[];
    int images[] = {R.drawable.ic_network,
            R.drawable.ic_network,
            R.drawable.ic_network,
            R.drawable.ic_network,
            R.drawable.ic_network,
 };


    Button homeBtn;
    TextView topicTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //FULL SCREEN + BACKGROUND COLOR
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic3Backgroundcolor));



        //SET home Button + topic title
        homeBtn = findViewById(R.id.detailsHomebtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        topicTitle = findViewById(R.id.detailsTopicTitle);
        topicTitle.setText("NETWORK");


        //Set up recycler view
        recyclerView = findViewById(R.id.recyclerView_Details);

        NameList = getResources().getStringArray(R.array.network_student_name_list);
        desList = getResources().getStringArray(R.array.network_student_des_list);
        linkList = getResources().getStringArray(R.array.network_student_link_list);

        NetworkAdapter networkStudentAdapter = new NetworkAdapter(this,NameList,linkList,desList,images);
        recyclerView.setAdapter(networkStudentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
