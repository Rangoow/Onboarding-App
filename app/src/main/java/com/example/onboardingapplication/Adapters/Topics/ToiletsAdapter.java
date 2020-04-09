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

public class ToiletsAdapter extends RecyclerView.Adapter<ToiletsAdapter.ToiletsViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public ToiletsAdapter(Context ct, String toiletNameList[],String toiletLocList[], String toiletDescList[], int img[]){
        context = ct;
        data1 = toiletNameList;
        data2 = toiletLocList;
        data3 = toiletDescList;
        images = img;
    }

    @NonNull
    @Override
    public ToiletsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_toilets,parent,false);
        return new ToiletsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToiletsViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.toiletImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ToiletsViewHolder extends RecyclerView.ViewHolder {

        TextView title, localization, description;
        ImageView toiletImg;

        public ToiletsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.toilet_title);
            localization = itemView.findViewById(R.id.toilet_loc);
            description = itemView.findViewById(R.id.toilet_desc);
            toiletImg = itemView.findViewById(R.id.toilet_img);

        }
    }
}
