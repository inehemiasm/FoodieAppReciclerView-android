package com.example.inehemias.foddieapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    String tag = "Second Activity";


    private TextView title, description, urls;
    private ImageView img;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadXmlFiles();
        GettingExtras();



    }

    private void GettingExtras() {
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        //String pos = intent.getExtras().getString("position");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");
        url = intent.getExtras().getString("Url");

        title.setText(Title);
        description.setText(Description);
        img.setImageResource(image);
        urls.setText("Click below for online Recipe");
    }

    private void loadXmlFiles() {
        setContentView(R.layout.descriptions_activity);
        title = (TextView) findViewById(R.id.texttitle);
        description = (TextView) findViewById(R.id.textdescription);
        urls = (TextView) findViewById(R.id.onlineRecipes);
        img = (ImageView) findViewById(R.id.mealthumbnail);

    }

    public void onlineInfo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

    }






}
