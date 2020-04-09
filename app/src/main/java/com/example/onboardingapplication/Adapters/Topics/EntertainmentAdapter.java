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

public class EntertainmentAdapter extends RecyclerView.Adapter<EntertainmentAdapter.EntertainmentViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public EntertainmentAdapter(Context ct, String entertainmentNameList[], String entertainmentLocList[], String entertainmentDescList[], int img[]){
        context = ct;
        data1 = entertainmentNameList;
        data2 = entertainmentLocList;
        data3 = entertainmentDescList;
        images = img;
    }

    @NonNull
    @Override
    public EntertainmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_entertainment,parent,false);
        return new EntertainmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntertainmentViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.entertainmentImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class EntertainmentViewHolder extends RecyclerView.ViewHolder {

        TextView title, localization, description;
        ImageView entertainmentImg;

        public EntertainmentViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.entertainment_title);
            localization = itemView.findViewById(R.id.entertainment_loc);
            description = itemView.findViewById(R.id.entertainment_desc);
            entertainmentImg = itemView.findViewById(R.id.entertainment_img);

        }
    }
}
