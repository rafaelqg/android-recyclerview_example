package com.example.P20212;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import model.Product;

public class VisibilityExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visibility_example);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button bt=findViewById(R.id.buttonVisible);
        setOnClick(bt, View.VISIBLE);

        bt=findViewById(R.id.buttonInVisible);
        setOnClick(bt, View.INVISIBLE);

        bt=findViewById(R.id.buttonGone);
        setOnClick(bt, View.GONE);


       Date dt= new Date();
       byte hora= (byte) dt.getHours();
       String messagem="";
       int color=0;
       if(hora>6 && hora<12){
           messagem="Bom dia";
           color=Color.rgb(240,230,140);
       }else if(hora>12 && hora<18){
           messagem="Boa tarde";
           color=Color.rgb(240,255,240);
       }else{
           messagem="Boa noite!";
           color=Color.rgb(112,128,144);
       }
        ConstraintLayout cl= (ConstraintLayout )findViewById(R.id.layout_main);
        cl.setBackgroundColor(color);

       Toast.makeText(this, messagem, Toast.LENGTH_LONG).show();



       //RecyclerViewAdapter ca= new RecyclerViewAdapter(new String[]{"Item A", "Item B", "Item C"});
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

    private void setOnClick(Button button, int visibility){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv= findViewById(R.id.textView);
                tv.setVisibility(visibility);
            }
        });
    }
}

