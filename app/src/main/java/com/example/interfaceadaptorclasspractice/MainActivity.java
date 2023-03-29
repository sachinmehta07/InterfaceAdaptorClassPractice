package com.example.interfaceadaptorclasspractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] menuItems = {"Home", "About Us", "Settings", "Orders", "Category"};
        MenuAdapter adapter = new MenuAdapter(menuItems, this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMenuItemClick(int position, String menuItem) {
        Toast.makeText(this, "Clicked item at position " + position + ": " + menuItem,
                Toast.LENGTH_SHORT).show();
    }
}
