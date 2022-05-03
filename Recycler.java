package com.example.nidaapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;
    List<category> categoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerId);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        categoryList = new ArrayList<>();
        categoryList = fillTheList();
        recyclerAdapter = new RecyclerAdapter(this, categoryList);
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

    private List<category> fillTheList() {
        List<category> categoryList = new ArrayList<>();
        categoryList.add(new category(R.drawable.nida, "National Id", 500, "National Id registration"));
        categoryList.add(new category(R.drawable.reg, "Citizen Registration", 1500, "A citizen can register"));
        categoryList.add(new category(R.drawable.imagef, "Lost Id", 2000, "You can apply for another Id if lost"));
        categoryList.add(new category(R.drawable.images, "Special case", 3000, "If you want citizenship, you can also apply"));

        return categoryList;
    }
}






