package com.example.ligtasscanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AcceptedListMainAdapter extends RecyclerView.Adapter<AcceptedListMainAdapter.ViewHolder> {

    List<AcceptedListMain> acceptedListMainList;
    Context context;

    public AcceptedListMainAdapter(List<AcceptedListMain> acceptedListMainList, Context context) {
        this.acceptedListMainList = acceptedListMainList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_accepted_list_main, null, false);
        return new AcceptedListMainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AcceptedListContentAdapter contentAdapter = new AcceptedListContentAdapter(acceptedListMainList.get(position).acceptedListContentList, context);
        holder.acceptedListContentRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.acceptedListContentRecyclerView.setAdapter(contentAdapter);
        contentAdapter.notifyDataSetChanged();

        holder.dateAcceptedTextview.setText(acceptedListMainList.get(position).date);
    }

    @Override
    public int getItemCount() {
        try {
            return acceptedListMainList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView dateAcceptedTextview;
        RecyclerView acceptedListContentRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateAcceptedTextview = itemView.findViewById(R.id.dateAcceptedTextview);
            acceptedListContentRecyclerView = itemView.findViewById(R.id.acceptedListContentRecyclerView);
        }
    }
}
