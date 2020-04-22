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

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public PlacesAdapter(Context ct, String placesNameList[], String placesLocList[], String placesDescList[], int img[]){
        context = ct;
        data1 = placesNameList;
        data2 = placesLocList;
        data3 = placesDescList;
        images = img;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_places,parent,false);
        return new PlacesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder holder, int position) {
        holder.title.setText(data1[position]);
        holder.localization.setText(data2[position]);
        holder.description.setText(data3[position]);
        holder.placesImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class PlacesViewHolder extends RecyclerView.ViewHolder {

        TextView title, localization, description;
        ImageView placesImg;

        public PlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.places_title);
            localization = itemView.findViewById(R.id.places_loc);
            description = itemView.findViewById(R.id.places_desc);
            placesImg = itemView.findViewById(R.id.places_img);

        }
    }
}
