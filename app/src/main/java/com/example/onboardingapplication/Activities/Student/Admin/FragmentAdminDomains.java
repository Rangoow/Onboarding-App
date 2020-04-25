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

public class FragmentAdminDomains extends Fragment {
    View v;
    private RecyclerView adminRecyclerView;
    private List<AdminStudentItem> listAdmin;


    public FragmentAdminDomains() {
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
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_9),
                getString(R.string.admin_loc_9),
                getString(R.string.admin_job_9),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_10),
                getString(R.string.admin_loc_10),
                getString(R.string.admin_job_10),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_11),
                getString(R.string.admin_loc_11),
                getString(R.string.admin_job_11),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_12),
                getString(R.string.admin_loc_12),
                getString(R.string.admin_job_12),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_13),
                getString(R.string.admin_loc_13),
                getString(R.string.admin_job_13),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_14),
                getString(R.string.admin_loc_14),
                getString(R.string.admin_job_14),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_15),
                getString(R.string.admin_loc_15),
                getString(R.string.admin_job_15),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_16),
                getString(R.string.admin_loc_16),
                getString(R.string.admin_job_16),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_17),
                getString(R.string.admin_loc_17),
                getString(R.string.admin_job_17),
                R.drawable.ic_administration));
        listAdmin.add(new AdminStudentItem(getString(R.string.admin_name_18),
                getString(R.string.admin_loc_18),
                getString(R.string.admin_job_18),
                R.drawable.ic_administration));
    }
}
