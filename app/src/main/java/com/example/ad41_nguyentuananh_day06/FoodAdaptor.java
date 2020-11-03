package com.example.ad41_nguyentuananh_day06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodAdaptor extends BaseAdapter {
    List<Food> foodList;
    public FoodAdaptor(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_item,parent,false);
        TextView tvFoodName = view.findViewById(R.id.tvFoodName);
        TextView tvAmount = view.findViewById(R.id.tvAmountSoLuong);
        Food food = foodList.get(position);
        tvFoodName.setText(food.getFoodName());
        tvAmount.setText("("+food.getSoLuong()+")");
        tvAmount.setVisibility(View.INVISIBLE);
        return view;
    }
}