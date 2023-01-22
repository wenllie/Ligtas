package com.example.ligtas.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.ligtas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class NewsfeedAdapter extends RecyclerView.Adapter<NewsfeedAdapter.NewsfeedViewHolder> {

    Context context;
    List<NewsfeedModel> newsfeedList;
    List<NewsfeedSlideModel> newsfeedSlideList = new ArrayList<>();


    public NewsfeedAdapter(Context context, List<NewsfeedModel> newsfeedList) {
        this.context = context;
        this.newsfeedList = newsfeedList;
    }

    @NonNull
    @Override
    public NewsfeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsfeedAdapter.NewsfeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_newsfeed, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsfeedViewHolder holder, int position) {

        NewsfeedModel model = newsfeedList.get(position);

        holder.newsfeedTitle.setText(model.getTitle());
        holder.newsfeedDate.setText(model.getDateposted());

        DatabaseReference sliderReference = FirebaseDatabase.getInstance().getReference().child("Newsfeeds");

        sliderReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                for (DataSnapshot imageIdSnap : task.getResult().getChildren()) {

                    String imageIdKey = imageIdSnap.getKey();

                    if (imageIdKey.equalsIgnoreCase(model.getNewsfeedId())) {

                        for (DataSnapshot imagesSnap : imageIdSnap.getChildren()) {

                            String imageKey = imagesSnap.getKey();

                            if (imageKey.equalsIgnoreCase("Images")) {

                                for (DataSnapshot snap : imageIdSnap.getChildren()) {

                                    for (DataSnapshot snaps : snap.getChildren()) {

                                        if (snaps.getKey().equalsIgnoreCase("Image0")) {
                                            Glide.with(context).load(snaps.getValue().toString()).into(holder.image1);
                                            holder.image1.setVisibility(View.VISIBLE);
                                        } else if (snaps.getKey().equalsIgnoreCase("Image1")) {
                                            Glide.with(context).load(snaps.getValue().toString()).into(holder.image2);
                                            holder.image2.setVisibility(View.VISIBLE);
                                        } else if (snaps.getKey().equalsIgnoreCase("Image2")) {
                                            Glide.with(context).load(snaps.getValue().toString()).into(holder.image3);
                                            holder.image3.setVisibility(View.VISIBLE);
                                        } else if (snaps.getKey().equalsIgnoreCase("Image3")) {
                                            Glide.with(context).load(snaps.getValue().toString()).into(holder.image4);
                                            holder.image4.setVisibility(View.VISIBLE);
                                        } else if (snaps.getKey().equalsIgnoreCase("Image4")) {
                                            Glide.with(context).load(snaps.getValue().toString()).into(holder.image5);
                                            holder.image5.setVisibility(View.VISIBLE);
                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return newsfeedList.size();
    }

    /*@Override
    public int getItemCount() {
        try {
            return newsfeedList.size();
        } catch (Exception e) {

            return 0;
        }
    }*/

    public class NewsfeedViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView newsfeedDate, newsfeedTitle;
        ImageView image1, image2, image3, image4, image5;

        public NewsfeedViewHolder(@NonNull View itemView) {
            super(itemView);

            newsfeedDate = itemView.findViewById(R.id.newsfeedDate);
            newsfeedTitle = itemView.findViewById(R.id.newsfeedTitle);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
            image4 = itemView.findViewById(R.id.image4);
            image5 = itemView.findViewById(R.id.image5);
        }
    }
}
