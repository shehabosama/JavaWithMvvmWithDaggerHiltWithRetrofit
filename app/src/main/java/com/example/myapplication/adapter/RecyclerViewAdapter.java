package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.RecyclerData;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<RecyclerData> listItems;
    public void setListDataItems(List<RecyclerData> listItems){
        this.listItems = listItems;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textName.setText(listItems.get(position).getName());
        holder.tvDes.setText(listItems.get(position).getDescription());
        Glide.with(holder.imageView)
                .load(listItems.get(position).getOwner().getAvatar_url())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(listItems == null)
        {
            return 0;
        }else {
            return listItems.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textName;
        TextView tvDes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.tvName);
            tvDes = itemView.findViewById(R.id.tvDesc);
        }
    }
}
