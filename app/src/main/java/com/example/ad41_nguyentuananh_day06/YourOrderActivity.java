package com.example.ad41_nguyentuananh_day06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class YourOrderActivity extends AppCompatActivity {
    ListView listViewOrder;
    ImageView btnBack;
    List<Food> foodList;
    OrderAdaptor orderAdaptor;
    TextView tvPrice;
    int tongTien=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);
        listViewOrder=findViewById(R.id.lvFoodOrder);
        btnBack = findViewById(R.id.btnBack);
        tvPrice= findViewById(R.id.tvPrice2);
        foodList = new ArrayList<>();
        Intent intent = this.getIntent();
        ArrayList<String> lstTen = intent.getStringArrayListExtra("ten");
        ArrayList<Integer> lstSoLuong = intent.getIntegerArrayListExtra("soLuong");
        for(int i=0;i<lstTen.size();i++){
            foodList.add(new Food(lstTen.get(i),lstSoLuong.get(i)));
            tongTien+=lstSoLuong.get(i)*10;
        }
        orderAdaptor = new OrderAdaptor(foodList);
        listViewOrder.setAdapter(orderAdaptor);
        tvPrice.setText("("+tongTien+")");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}