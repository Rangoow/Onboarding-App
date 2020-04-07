package com.example.onboardingapplication.Activities.Both;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboardingapplication.Adapters.ToiletsAdapter;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toilets);

        Objects.requireNonNull(getSupportActionBar()).hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic9Backgroundcolor));

        recyclerView = findViewById(R.id.recyclerView_Toilets);

        toiletNameList = getResources().getStringArray(R.array.toilets_name_list);
        toiletLocList = getResources().getStringArray(R.array.toilets_loc_list);
        toiletDescList = getResources().getStringArray(R.array.toilets_desc_list);

        ToiletsAdapter toiletsAdapter = new ToiletsAdapter(this,toiletNameList,toiletLocList,toiletDescList,images);
        recyclerView.setAdapter(toiletsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
