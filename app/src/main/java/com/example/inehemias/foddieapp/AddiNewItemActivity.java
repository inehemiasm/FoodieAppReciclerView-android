package com.example.inehemias.foddieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddiNewItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String tag ="add items";

    String title ="";
    String info ="";
    String desc ="";
    ImageView image;
    public int imageSrc;

    EditText editTitle, editDesc;
    EditText editInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_items);
        Intent intent = getIntent();



        // set the custom dialog components - texts and image
         editTitle = (EditText) findViewById(R.id.foodNameInfoInput);
         editInfo = (EditText) findViewById(R.id.foodInfoInput);
         editDesc = (EditText) findViewById(R.id.foodDescInput);
         Spinner spiner = (Spinner) findViewById(R.id.image_selector);

        int[] imageList = {
                R.drawable.apple_pie,
                R.drawable.california_panini,
                R.drawable.capuccino,
                R.drawable.greek_salad,
                R.drawable.mesculin_chicken_wrap,
                R.drawable.salmon_burger,
                R.drawable.pizza,
                R.drawable.cheeseburger,
                R.drawable.food

        };
        // Spinner click listener
        spiner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Pie");
        categories.add("Sandwich");
        categories.add("Cappuccino");
        categories.add("Salad");
        categories.add("Wrap");
        categories.add("Burger");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spiner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        imageSrc=position;

        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



    public void onClickok(View view) {
        Intent data = new Intent();
        title= editTitle.getText().toString();
        info= editInfo.getText().toString();
        desc= editDesc.getText().toString();
        data.putExtra("titleKey",title);
        data.putExtra("infoKey",info);
        data.putExtra("imageKey",imageSrc);
        data.putExtra("descKey", desc);
        setResult(RESULT_OK,data);
        finish();

    }

    public void onClickCancel(View view) {

        finishAndRemoveTask();


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
