package com.example.nhom09_ungdungxemtintuc;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsApdapter extends RecyclerView.Adapter<NewsApdapter.ViewHolder> {



    public NewsApdapter(List<News> lstNews) {
        this.lstNews = lstNews;
    }

    private List<News> lstNews;
    String URL;

    @NonNull
    @Override
    public NewsApdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context=parent.getContext();
        LayoutInflater inflater =LayoutInflater.from(context);
        View newsView = inflater.inflate(R.layout.item_news,parent,false);
        ViewHolder viewHolder = new ViewHolder(newsView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsApdapter.ViewHolder holder, int position)
    {
        News temp =lstNews.get(position);
        holder.txtTitle.setText(temp.getTitle());
        holder.txtImage.setText(temp.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayWebActivity.class);
                intent.putExtra("URL",temp.getUrl());
                v.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {

        return lstNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle =(TextView) itemView.findViewById(R.id.txtTieude);
            txtImage =(TextView) itemView.findViewById(R.id.imageView);
        }
    }





}
