package com.example.onboardingapplication.Activities.Student;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.onboardingapplication.R;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class ListLocalizationActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Match",
            "Carrefour market (Gambetta)",
            "Carrefour express (nationale)",
            "Biocoop",
            "Marché de Wazemmes"
    };

    String[] descript ={
            "Le moins cher",
            "Le plus grand",
            "De dernière minute",
            "Magasin bio",
            "Le plus varié"
    };

    Integer[] imgid={
            R.drawable.match,
            R.drawable.carrefour_market,
            R.drawable.carrefour_express,
            R.drawable.biocoop,
            R.drawable.wazemmes,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic8Backgroundcolor));

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, descript, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });

    }
}