package com.example.inehemias.foddieapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MyReceiver extends BroadcastReceiver {

    private Context mcontext;

    protected static final String I_AM_HOME = "com.example.I_AM_HOME";


    private ArrayList<MealItemClass> meal;

    public MyReceiver(){

    }
    public MyReceiver(ArrayList<MealItemClass> mealItems){
        this.meal = mealItems;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyReciever", "Broadcast Recieved");
        this.mcontext = context;
        int mypos= new Random().nextInt(meal.size());


        int position = intent.getExtras().getInt("pos");

        MealItemClass myMeal = meal.get(position);

        Intent intent2 = new Intent(context, DescriptionActivity.class);

        //passing data to the next activity
        intent2.putExtra("Title",myMeal.getTitle());
        intent2.putExtra("Description", myMeal.getDesc());
        intent2.putExtra("Thumbnail", myMeal.getImage());
        intent2.putExtra("Url", myMeal.getUrl());

        context.startActivity(intent2);
        Toast.makeText(context, "Happy Cooking "+ meal.get(position).getTitle() , Toast.LENGTH_LONG).show();

    }


}