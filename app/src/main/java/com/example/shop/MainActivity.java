package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shop.adapter.CategoryAdapter;
import com.example.shop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    TextView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecyclerView=findViewById(R.id.categoryRecycler);

        allCategory=findViewById(R.id.allCategoryImage);
        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        categoryList=new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.snacks));
        categoryList.add(new Category(1,R.drawable.snacks));
        categoryList.add(new Category(1,R.drawable.snacks));
        categoryList.add(new Category(1,R.drawable.snacks));
        categoryList.add(new Category(1,R.drawable.snacks));

        setCategoryRecycler(categoryList);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

}
