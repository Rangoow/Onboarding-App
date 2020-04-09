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

public class LunchAdapter extends RecyclerView.Adapter<LunchAdapter.LunchViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public LunchAdapter(Context ct, String lunchNameList[], String lunchLocList[], String lunchDescList[], int img[]){
        context = ct;
        data1 = lunchNameList;
        data2 = lunchLocList;
        data3 = lunchDescList;
        images = img;
    }

    @NonNull
    @Override
    public LunchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lunch,parent,false);
        return new LunchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LunchViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.lunchImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class LunchViewHolder extends RecyclerView.ViewHolder {

        TextView title, localization, description;
        ImageView lunchImg;

        public LunchViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.lunch_title);
            localization = itemView.findViewById(R.id.lunch_loc);
            description = itemView.findViewById(R.id.lunch_desc);
            lunchImg = itemView.findViewById(R.id.lunch_img);

        }
    }
}
