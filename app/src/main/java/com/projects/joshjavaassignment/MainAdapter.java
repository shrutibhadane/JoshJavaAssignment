package com.projects.joshjavaassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    Context context;
    int userClickCount;
    private ArrayList<Integer> listData = new ArrayList<>();

    public MainAdapter(Context context, int userClickCount, ArrayList<Integer> listData) {
        this.context = context;
        this.userClickCount = userClickCount;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.adapter_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Integer arrayListValue = listData.get(position);
        holder.textView.setText("" + arrayListValue);

        if(userClickCount %2 != 0) {
            if (arrayListValue % 2 != 0) {
                holder.contentLayout.setBackgroundColor(context.getResources().getColor(R.color.light_red));
            } else {
                holder.contentLayout.setBackgroundColor(context.getResources().getColor(R.color.light_blue));
            }
        } else {
            if (arrayListValue % 2 != 0) {
                holder.contentLayout.setBackgroundColor(context.getResources().getColor(R.color.light_blue));
            } else {
                holder.contentLayout.setBackgroundColor(context.getResources().getColor(R.color.light_red));
            }
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout contentLayout;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contentLayout = (ConstraintLayout) itemView.findViewById(R.id.contentLayout);
            textView = (TextView) itemView.findViewById(R.id.textView);

        }
    }
}
