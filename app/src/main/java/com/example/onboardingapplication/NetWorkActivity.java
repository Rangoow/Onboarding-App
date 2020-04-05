package com.example.onboardingapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.security.auth.PrivateCredentialPermission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NetWorkActivity  extends AppCompatActivity {
    /** Called when the activity is first created. */


    private  List<String>  groupArray;//group list
    private  List<List<String>> childArray;// sub list
    private  ExpandableListView  expandableListView_one;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_network);
        expandableListView_one =(ExpandableListView)findViewById(R.id.listview_network);
        groupArray =new ArrayList<String>();
        childArray = new ArrayList<List<String>>();
        Objects.requireNonNull(getSupportActionBar()).hide();
        getResources().getColor(R.color.topic8Backgroundcolor);

        initdate();
        expandableListView_one.setAdapter(new ExpandableListViewaAdapter(NetWorkActivity.this));
        Button startActivityHome = findViewById(R.id.topicHomebtn);
        startActivityHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });


    }
    class ExpandableListViewaAdapter extends BaseExpandableListAdapter {
        Activity activity;
        public  ExpandableListViewaAdapter(Activity a)
        {
            activity = a;
        }
        /*-----------------Child */
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childArray.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            String string =childArray.get(groupPosition).get(childPosition);

            return getGenericView2(string);
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return childArray.get(groupPosition).size();
        }
        /* ----------------------------Group */
        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return getGroup(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return groupArray.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

            String   string=groupArray.get(groupPosition);
            return getGenericView(string);
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition)
        {
            // TODO Auto-generated method stub
            return true;
        }

        @SuppressLint("ResourceAsColor")
        private TextView  getGenericView(String string )
        {
            AbsListView.LayoutParams  layoutParams =new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView  textView =new TextView(activity);
            textView.setLayoutParams(layoutParams);

            textView.setGravity(Gravity.CENTER_VERTICAL |Gravity.LEFT);

            textView.setPadding(100, 100, 100, 100);
            textView.setTextSize(18);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextColor(Color.WHITE);
            textView.setText(string);
            return textView;
        }
        private TextView  getGenericView2(String string )
        {
            AbsListView.LayoutParams  layoutParams =new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView  textView =new TextView(activity);
            textView.setLayoutParams(layoutParams);

            textView.setGravity(Gravity.CENTER_VERTICAL |Gravity.LEFT);

            textView.setPadding(150, 50, 50, 50);
            textView.setTextSize(16);
//            textView.setTextColor(Color.BLACK);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
//            textView.setTextColor(R.color.textColor);
            textView.setText(string);
            return textView;
        }
    }

    private void addInfo(String group,String []child) {

        groupArray.add(group);

        List<String>  childItem =new ArrayList<String>();

        for(int index=0;index<child.length;index++)
        {
            childItem.add(child[index]);
        }
        childArray.add(childItem);
    }

    private void initdate()
    {
        addInfo("    Campus isen", new String[]{"Site permettant de publier des documents pour ses élèves, et d'effectuer des rendus de travail","https://campus.isen.fr/"});
        addInfo("    Aurion", new String[]{"Site indispensable, emploi du temps avec reservation de salles et projecteurs, saisie des notes et des absences","https://aurion.yncrea.fr/"});
        addInfo("    Fastilog", new String[]{"Application mission/congés","https://ssl.fastilog.fr/fastilog/"});
        addInfo("    Mon portail RH", new String[]{"Entretien annuel / fiches de paie / formations (plan de développement des compétences)","https://app.monportailrh.com/ "});
        addInfo("    Site ISEN", new String[]{"Site permettant de rester à jours par rapport aux actualités de l'ISEN","https://www.isen-lille.fr/"});
    }
}


