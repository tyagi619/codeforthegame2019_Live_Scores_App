package com.icc.cricketscores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icc.cricketscores.ClassDefinition.NewsData;
import com.squareup.picasso.Picasso;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsViewHolder> {

    NewsData[] newsData;

    public newsAdapter(NewsData[] data){
        this.newsData = data;
    }

    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_news_item,null);
        return new  newsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder newsViewHolder, int i) {
        NewsData news = newsData[i];

        Picasso.with(newsViewHolder.context).load(news.getUrlImage()).into(newsViewHolder.image);
        newsViewHolder.title.setText(news.getTitle());
        newsViewHolder.description.setText(news.getDescription());

    }

    @Override
    public int getItemCount() {
        return newsData.length;
    }

    public class newsViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,description;
        Context context;
        public newsViewHolder (View itemView) {
            super(itemView);
            context = itemView.getContext();
            image = itemView.findViewById(R.id.newsImage);
            title = itemView.findViewById(R.id.newTitle);
            description = itemView.findViewById(R.id.newsDescription);
        }
    }
}
