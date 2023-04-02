package com.example.interfaceadaptorclasspractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] menuItems = {"Home", "About Us", "Settings", "Orders", "Category"};
        MenuAdapter adapter = new MenuAdapter(menuItems, new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, String menuItem) {
                Toast.makeText(MainActivity.this,position+menuItem,Toast.LENGTH_LONG).show();



            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
