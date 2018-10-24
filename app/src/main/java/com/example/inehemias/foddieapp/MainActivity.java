package com.example.inehemias.foddieapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MealItemClass> FoodList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private FloatingActionButton fab;

    private  int gridCount;
    int[] textureArrayWin = {
            R.drawable.apple_pie,
            R.drawable.california_panini,
            R.drawable.capuccino,
            R.drawable.greek_salad,
            R.drawable.mesculin_chicken_wrap,
            R.drawable.salmon_burger,
            R.drawable.pizza,
            R.drawable.cheeseburger,

    };

    private String tag = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FoodList = new ArrayList<>();
        setContentView(R.layout.activity_main);
        gridCount = getResources().getInteger(R.integer.grid_col_count);
        recyclerView = findViewById(R.id.recyclerview_id);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        FoodList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(this, FoodList);
        recyclerView.setAdapter(adapter);

        loadMealsData();//our method below to load the data from strings.xml

        RecyclerView myRV =(RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter MyAdapter = new RecyclerViewAdapter(this, FoodList);
        myRV.setLayoutManager(new GridLayoutManager(this, gridCount));
        myRV.setAdapter(MyAdapter);
        AddItem();


    }

    private void AddItem() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(tag, "new intent");
                Intent intent = new Intent(MainActivity.this, AddiNewItemActivity.class);
                startActivityForResult(intent, 2);
                }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra("titleKey");
                String info = data.getStringExtra("infoKey");
                String desc = data.getStringExtra("descKey");
                int image = data.getIntExtra("imageKey",0);
                MealItemClass newItem = new MealItemClass(title, info);
                newItem.setImage(textureArrayWin[image]);
                newItem.setDesc(desc);
                FoodList.add(newItem);
                adapter.notifyDataSetChanged();

                Log.d(tag, desc);


                }
        }
    }
    private void loadMealsData() {
        FoodList.clear();

        String [] foodTitles = getResources().getStringArray(R.array.food_titles);
        String [] foodInfos =  getResources().getStringArray(R.array.food_infos);
        String [] desc =  getResources().getStringArray(R.array.food_description);
        String [] urls = getResources().getStringArray(R.array.urls);

        for(int i=0; i<textureArrayWin.length; ++i){

            MealItemClass currItem = new MealItemClass(foodTitles[i], foodInfos[i], textureArrayWin[i]);
            currItem.setDesc(desc[i]);
            currItem.setUrl(urls[i]);
            FoodList.add(currItem);

        }
        adapter.notifyDataSetChanged();
        //come back here if issues... double check
}



}