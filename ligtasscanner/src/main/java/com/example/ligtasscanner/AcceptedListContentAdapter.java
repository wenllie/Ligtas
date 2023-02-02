package com.example.ligtasscanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AcceptedListContentAdapter extends RecyclerView.Adapter<AcceptedListContentAdapter.ViewHolder> {

    List<AcceptedListContent> acceptedListContentList;
    Context context;

    public AcceptedListContentAdapter(List<AcceptedListContent> acceptedListContentList, Context context) {
        this.acceptedListContentList = acceptedListContentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.accepted_list_content_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.acceptedName.setText(acceptedListContentList.get(position).fullName);
        holder.acceptedIDNumber.setText(acceptedListContentList.get(position).idNumber);

    }

    @Override
    public int getItemCount() {
        try {
            return acceptedListContentList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView acceptedName, acceptedIDNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            acceptedName = itemView.findViewById(R.id.acceptedName);
            acceptedIDNumber = itemView.findViewById(R.id.acceptedIDNumber);
        }
    }
}
