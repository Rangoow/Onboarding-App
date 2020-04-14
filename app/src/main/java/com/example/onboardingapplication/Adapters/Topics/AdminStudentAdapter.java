package com.example.onboardingapplication.Adapters.Topics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboardingapplication.R;

public class AdminStudentAdapter extends RecyclerView.Adapter<AdminStudentAdapter.AdminStudentViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public AdminStudentAdapter(Context ct, String adminNameList[], String adminLocList[], String adminJobList[], int img[]){
        context = ct;
        data1 = adminNameList;
        data2 = adminLocList;
        data3 = adminJobList;
        images = img;
    }

    @NonNull
    @Override
    public AdminStudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_admin_student,parent,false);
        return new AdminStudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminStudentViewHolder holder, int position) {
        holder.name.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.job.setText(data3[position]);
        holder.adminImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class AdminStudentViewHolder extends RecyclerView.ViewHolder {

        TextView name, localization, job;
        ImageView adminImg;

        public AdminStudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.admin_student_name);
            localization = itemView.findViewById(R.id.admin_student_loc);
            job = itemView.findViewById(R.id.admin_student_job);
            adminImg = itemView.findViewById(R.id.admin_img);

        }
    }
}
