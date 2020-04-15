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

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public MarketAdapter(Context ct, String marketNameList[], String marketLocList[], String marketDescList[], int img[]){
        context = ct;
        data1 = marketNameList;
        data2 = marketLocList;
        data3 = marketDescList;
        images = img;
    }

    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_market,parent,false);
        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.marketImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {

        TextView title, localization, description;
        ImageView marketImg;

        public MarketViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.market_title);
            localization = itemView.findViewById(R.id.market_loc);
            description = itemView.findViewById(R.id.market_desc);
            marketImg = itemView.findViewById(R.id.market_img);

        }
    }
}
