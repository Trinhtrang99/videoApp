package com.example.videoapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoapp.Action.OnClickItem;
import com.example.videoapp.Context.Contect;
import com.example.videoapp.Main.PlayVideo;
import com.example.videoapp.R;



import java.util.List;

public class AdapterFragment2 extends RecyclerView.Adapter<AdapterFragment2.ViewHolder> {

    List<Contect> list;
    Context context;
    Contect contect;
    OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public AdapterFragment2(List<Contect> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterFragment2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item2, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFragment2.ViewHolder holder, int position) {
        contect = list.get(position);
        String tt = list.get(position).getTitle();
        String avatar = list.get(position).getAvatar();
        Glide.with(context).load(avatar).into(holder.imageView);
        holder.tvName.setText(tt);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putSerializable("object",contect);
                Intent i = new Intent(context, PlayVideo.class);
                i.putExtras(b);
               view.getContext().startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTime, tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatar);
            tvName = itemView.findViewById(R.id.time);
            tvName = itemView.findViewById(R.id.name);

        }
    }
}
