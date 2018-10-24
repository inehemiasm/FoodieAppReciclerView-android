package com.example.inehemias.foddieapp;

import android.net.Uri;

public class MealItemClass {
    private String Title;
    private String info;
    private int image;
    private String desc;
    private String url;
    public MealItemClass() {

    }
    public MealItemClass(String title, String info) {
        Title = title;
        this.info = info;
    }
    public MealItemClass(String title, String info, int image) {
        Title = title;
        this.info = info;
        this.image = image;
    }
    public void setDesc(String desc){ this.desc = desc; }
    public void setUrl(String url){ this.url = url; }
    public String getUrl(){ return url; }
    public String getDesc(){ return desc; }
    public String getTitle() {
        return Title;
    }
    public String getInfo() {
        return info;
    }
    public int getImage() {
        return image;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
