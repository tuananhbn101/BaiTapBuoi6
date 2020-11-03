package com.example.ad41_nguyentuananh_day06;

public class Food {
    private String foodName;
    private int soLuong;

    public Food(String foodName, int soLuong) {
        this.foodName = foodName;
        this.soLuong = soLuong;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
