package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private ArrayList<User> usersList;

    public recyclerAdapter(ArrayList<User> usersList){
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTXT;

        public MyViewHolder(final View view){
            super(view);
            nameTXT = view.findViewById(R.id.text_list_item);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {

        String name = usersList.get(position).getUsername();
        holder.nameTXT.setText(name);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
