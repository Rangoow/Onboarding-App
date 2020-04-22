package com.example.onboardingapplication.Activities.Both;

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

import com.example.onboardingapplication.Adapters.Topics.ToiletsAdapter;
import com.example.onboardingapplication.R;

import java.util.Objects;

public class ToiletsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String toiletNameList[], toiletLocList[], toiletDescList[];
    int images[] = {R.drawable.ic_toilet,
                    R.drawable.ic_toilet,
                    R.drawable.ic_toilet,
                    R.drawable.ic_toilet,
                    R.drawable.ic_toilet,
                    R.drawable.ic_toilet,
                    R.drawable.ic_toilet,
                    R.drawable.ic_toilet};
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
        view.setBackgroundColor(getResources().getColor(R.color.topic9Backgroundcolor));



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
        topicTitle.setText(R.string.topic_toilets_title);


        //Set up recycler view
        recyclerView = findViewById(R.id.recyclerView_Details);

        toiletNameList = getResources().getStringArray(R.array.toilets_name_list);
        toiletLocList = getResources().getStringArray(R.array.toilets_loc_list);
        toiletDescList = getResources().getStringArray(R.array.toilets_desc_list);

        ToiletsAdapter toiletsAdapter = new ToiletsAdapter(this,toiletNameList,toiletLocList,toiletDescList,images);
        recyclerView.setAdapter(toiletsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
