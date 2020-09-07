package com.example.videoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoapp.Action.OnClickItem;
import com.example.videoapp.Context.Contect;
import com.example.videoapp.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//

public class AdapterFragment extends RecyclerView.Adapter<AdapterFragment.ViewHolder> implements Filterable {


    List<Contect> list;
    List<Contect> listAll;
    Contect contect;
    Context context;
    OnClickItem onClickItem;


    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public AdapterFragment(List<Contect> list, Context context) {
        this.list = list;
        this.context = context;
        listAll = new ArrayList<>();
        listAll.addAll(list);
    }

    @NonNull
    @Override
    public AdapterFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.iem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFragment.ViewHolder holder, int position) {
        contect = list.get(position);
        String tt = list.get(position).getTitle();
        String avatar = list.get(position).getAvatar();
        Glide.with(context).load(avatar).into(holder.imageView);

        holder.tvName.setText(tt);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItem.onClickLayoutItem(contect);
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }
    Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Contect> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(listAll);
            } else {
                for (Contect contect:listAll) {
                    if (contect.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(contect);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((Collection<? extends Contect>) filterResults.values);
            notifyDataSetChanged();
        }
    };


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
