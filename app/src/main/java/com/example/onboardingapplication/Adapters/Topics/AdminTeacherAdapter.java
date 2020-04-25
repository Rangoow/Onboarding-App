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

public class AdminTeacherAdapter extends RecyclerView.Adapter<AdminTeacherAdapter.AdminTeacherViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public AdminTeacherAdapter(Context ct, String adminNameList[], String adminLocList[], String adminContactList[], int img[]){
        context = ct;
        data1 = adminNameList;
        data2 = adminLocList;
        data3 = adminContactList;
        images = img;
    }

    @NonNull
    @Override
    public AdminTeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_admin_teacher,parent,false);
        return new AdminTeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminTeacherViewHolder holder, int position) {
        holder.name.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.contact.setText(data3[position]);
        holder.adminImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class AdminTeacherViewHolder extends RecyclerView.ViewHolder {

        TextView name, localization, contact;
        ImageView adminImg;

        public AdminTeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.admin_teacher_name);
            localization = itemView.findViewById(R.id.admin_teacher_loc);
            contact = itemView.findViewById(R.id.admin_teacher_contact);
            adminImg = itemView.findViewById(R.id.admin_student_img);

        }
    }
}
