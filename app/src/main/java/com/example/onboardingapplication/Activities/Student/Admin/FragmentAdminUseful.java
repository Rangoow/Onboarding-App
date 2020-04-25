package com.example.onboardingapplication.Activities.Student.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboardingapplication.Adapters.Admin.AdminStudentRecyclerViewAdapter;
import com.example.onboardingapplication.AdminStudentItem;
import com.example.onboardingapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdminUseful extends Fragment {

    View v;
    private RecyclerView adminRecyclerView;
    private List<AdminStudentItem> listAdmin;


    public FragmentAdminUseful() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_admin_student,container,false);
        adminRecyclerView = v.findViewById(R.id.adminStudentRecycler);
        AdminStudentRecyclerViewAdapter recyclerAdapter = new AdminStudentRecyclerViewAdapter(getContext(),listAdmin);
        adminRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adminRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdmin = new ArrayList<>();
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_19),
                getString(R.string.admin_loc_19),
                getString(R.string.admin_job_19),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_20),
                getString(R.string.admin_loc_20),
                getString(R.string.admin_job_20),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_21),
                getString(R.string.admin_loc_21),
                getString(R.string.admin_job_21),
                R.drawable.ic_administration));
    }
}
