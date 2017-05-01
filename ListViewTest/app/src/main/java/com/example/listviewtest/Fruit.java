package com.example.listviewtest;

/**
 * Created by lenovo on 2017/1/25.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name,int iamgeId){
        this.name=name;
        this.imageId=iamgeId;
    }
    public String getName()
    {
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
