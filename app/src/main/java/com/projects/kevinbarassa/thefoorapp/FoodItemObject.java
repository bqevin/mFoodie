package com.projects.kevinbarassa.thefoorapp;

/**
 * Created by Kevin Barassa on 24-Dec-16.
 */


public class FoodItemObject {

    private String name;
    private int photo;

    public FoodItemObject(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}

