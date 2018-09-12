package com.developer.dinhduy.javaot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DUY28";
    private List<Movie> movieList=new ArrayList<>();
    private MovieAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    listView=(ListView) findViewById(R.id.id_listview);
    adapter=new MovieAdapter(this,R.layout.row_item,movieList);
    AddData();
    listView.setAdapter(adapter);
    }

    private void AddData() {
        movieList.add(new Movie("Top 1",R.drawable.dauphathuongkhung,"Đấu Phá Thương Khung"));
        movieList.add(new Movie("Top 2",R.drawable.bietdoi,"Biệt Đội Siêu Anh Hùng"));
        movieList.add(new Movie("Top 3",R.drawable.sieudaichienthaibd,"Đại Chiến Thái Bình Dương"));
        movieList.add(new Movie("Top 4",R.drawable.hatde,"Hạt Dẻ Trong Rừng"));
        movieList.add(new Movie("Top 5",R.drawable.thegioikl,"Thế Giới Khủng Long"));
        movieList.add(new Movie("Top 6",R.drawable.thap,"Tháp Đấu"));
        movieList.add(new Movie("Top 7",R.drawable.aquaman,"Aquaman "));
    }
}
