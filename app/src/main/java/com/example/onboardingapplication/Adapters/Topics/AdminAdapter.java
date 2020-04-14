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

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.AdminViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public AdminAdapter(Context ct, String adminNameList[], String adminLocList[], String adminDescList[], int img[]){
        context = ct;
        data1 = adminNameList;
        data2 = adminLocList;
        data3 = adminDescList;
        images = img;
    }

    @NonNull
    @Override
    public AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_admin,parent,false);
        return new AdminAdapter.AdminViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapter.AdminViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.entertainmentImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

        public class AdminViewHolder extends RecyclerView.ViewHolder {
            TextView title, localization, description;
            ImageView entertainmentImg;

            public AdminViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.admin_title);
                localization = itemView.findViewById(R.id.admin_loc);
                description = itemView.findViewById(R.id.admin_desc);
                entertainmentImg = itemView.findViewById(R.id.admin_img);
        }
    }
}
