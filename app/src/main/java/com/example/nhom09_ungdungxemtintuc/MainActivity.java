package com.example.nhom09_ungdungxemtintuc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<News> listNews= News.getListNews();

    private RecyclerView rcNews;

    private NewsApdapter adapter;
    private ItemTouchHelper itemTouchHelper;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcNews = findViewById(R.id.rcNews);
        itemTouchHelper =new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rcNews);
        Intent intent =getIntent();


        if(intent!=null&&intent.hasExtra("textTitle")){
            String a =intent.getStringExtra("textTitle");
            String b = intent.getStringExtra("textImage");
            String c = intent.getStringExtra("textUrl");
            News newNews=new News(a,b,c);
            listNews.add(newNews);
            for(News news:listNews){
                Log.d("MainActivity","News: "+news.getTitle());
            }
            if(adapter!=null){
                adapter.notifyDataSetChanged();
            }

        }
        adapter=new NewsApdapter(listNews);
        rcNews.setAdapter(adapter);
        rcNews.setLayoutManager(new LinearLayoutManager(MainActivity.this));









    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            listNews.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
        }
    };
    public void addScreen(View view) {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }





}