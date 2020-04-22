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

public class NetworkAdapter extends RecyclerView.Adapter<NetworkAdapter.NetworkViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public NetworkAdapter(Context ct, String NameList[], String LocList[], String DescList[], int img[]){
        context = ct;
        data1 = NameList;
        data2 = LocList;
        data3 = DescList;
        images = img;
    }

    @NonNull
    @Override
    public NetworkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_network,parent,false);
        return new NetworkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NetworkViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.link.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.Img.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class NetworkViewHolder extends RecyclerView.ViewHolder {

        TextView title, link, description;
        ImageView Img;

        public NetworkViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.network_title);
            link = itemView.findViewById(R.id.network_link);
            description = itemView.findViewById(R.id.network_des);
            Img = itemView.findViewById(R.id.network_img);

        }
    }
}
