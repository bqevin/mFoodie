package com.projects.kevinbarassa.thefoorapp;

/**
 * Created by Kevin Barassa on 29-Dec-16.
 */

public class RestaurantItem {

    private String restaurantName;
    private int restaurantPhoto;

    public RestaurantItem(String restaurantName, int restaurantPhoto) {
        this.restaurantName = restaurantName;
        this.restaurantPhoto = restaurantPhoto;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRestaurantPhoto() {
        return restaurantPhoto;
    }

    public void setRestaurantPhoto(int restaurantPhoto) {
        this.restaurantPhoto = restaurantPhoto;
    }
}
