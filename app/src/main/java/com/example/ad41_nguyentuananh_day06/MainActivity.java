package com.example.ad41_nguyentuananh_day06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    ImageView btnCart;
    TextView tvAmount;
    TextView tvPrice;
    RelativeLayout btnOrder;
    TextView tvThanks;
    TextView textView;
    ListView listViewFood;
    FoodAdaptor foodAdaptor;
    Food food,food1,food2,food3,food4,food5;
    List<Food> foodList;
    int positions;
    int count= 0;
    int price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCart = findViewById(R.id.btnCart);
        tvAmount = findViewById(R.id.tvAmount);
        tvPrice = findViewById(R.id.tvPrice);
        textView = findViewById(R.id.titleOrder);
        btnOrder = findViewById(R.id.btnOrder);
        tvThanks = findViewById(R.id.tvThanks);
        listViewFood = findViewById(R.id.lvFood);
        foodList = new ArrayList<>();
        food = new Food("Pizza Panda",0);
        food1 = new Food("KFC Super",0);
        food2 = new Food("Bread Eggs",0);
        food3 = new Food("Coca Cola",0);
        food4 = new Food("Chicken Super",0);
        food5 = new Food("Cup Cake",0);
        foodList.add(food);
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodAdaptor = new FoodAdaptor(foodList);
        listViewFood.setAdapter(foodAdaptor);
        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positions = position;
                count += 1;
                tvAmount.setText(count+"");
                price +=10;
                tvPrice.setText(price+"$");
                Food foodNew = new Food(foodList.get(positions).getFoodName(),foodList.get(positions).getSoLuong()+1);
                foodList.set(positions,foodNew);
            }
        });
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YourOrderActivity.class);
                ArrayList<String> listOrder = new ArrayList<>();
                ArrayList<Integer> listSoLuong = new ArrayList<>();
                for (Food food1: foodList) {
                    if(food1.getSoLuong()>0){
                        listOrder.add(food1.getFoodName());
                        listSoLuong.add(food1.getSoLuong());
                    }
                }
                intent.putStringArrayListExtra("ten",listOrder);
                intent.putIntegerArrayListExtra("soLuong",listSoLuong);
                startActivity(intent);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvThanks.setVisibility(View.VISIBLE);
            }
        });

    }
}