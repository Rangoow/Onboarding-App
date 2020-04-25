package com.example.onboardingapplication.Adapters.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboardingapplication.AdminStudentItem;
import com.example.onboardingapplication.R;

import java.util.List;

public class AdminStudentRecyclerViewAdapter extends RecyclerView.Adapter<AdminStudentRecyclerViewAdapter.AdminStudentViewHolder>{

    Context context;
    List<AdminStudentItem> data;

    public  AdminStudentRecyclerViewAdapter ( Context context, List<AdminStudentItem> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdminStudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_admin_student,parent, false);
        AdminStudentViewHolder vHolder = new AdminStudentViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminStudentViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.location.setText(data.get(position).getLocation());
        holder.job.setText(data.get(position).getJob());
        holder.img.setImageResource(data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class AdminStudentViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView location;
        private TextView job;
        private ImageView img;
        public AdminStudentViewHolder(View itemview){
            super(itemview);

            name = itemview.findViewById(R.id.admin_student_name);
            location = itemview.findViewById(R.id.admin_student_loc);
            job = itemview.findViewById(R.id.admin_student_job);
            img = itemview.findViewById(R.id.admin_student_img);

        }
    }
}
