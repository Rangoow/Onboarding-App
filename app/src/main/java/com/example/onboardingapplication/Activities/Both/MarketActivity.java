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

import com.example.onboardingapplication.Adapters.Topics.LunchAdapter;
import com.example.onboardingapplication.R;

import java.util.Objects;

public class MarketActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String marketNameList[], marketLocList[], marketDescList[];
    int images[] = {R.drawable.ic_market,
                    R.drawable.ic_market,
                    R.drawable.ic_market,
                    R.drawable.ic_market,
                    R.drawable.ic_market};
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
        view.setBackgroundColor(getResources().getColor(R.color.topic7Backgroundcolor));



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
        topicTitle.setText(R.string.topic_market_title);


        //Set up recycler view
        recyclerView = findViewById(R.id.recyclerView_Details);

        marketNameList = getResources().getStringArray(R.array.market_name_list);
        marketLocList = getResources().getStringArray(R.array.market_loc_list);
        marketDescList = getResources().getStringArray(R.array.market_desc_list);

        LunchAdapter marketAdapter = new LunchAdapter(this,marketNameList,marketLocList,marketDescList,images);
        recyclerView.setAdapter(marketAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
