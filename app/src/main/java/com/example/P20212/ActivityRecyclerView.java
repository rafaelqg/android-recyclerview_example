package com.example.P20212;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import model.Product;

public class ActivityRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        Product p =new Product();
        p.initialLoad();
        RecyclerViewAdapterForProducts ca= new RecyclerViewAdapterForProducts(p.getProducts());
        RecyclerView cv=this.findViewById(R.id.recycler_view);
        cv.setLayoutManager(new LinearLayoutManager(this));
        cv.setAdapter(ca);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new MenuHelper().menuActionsConfig(item, this);
        return super.onOptionsItemSelected(item);
    }
}