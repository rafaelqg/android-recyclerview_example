package com.example.P20212;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import model.Product;

public class ActivityDynamicLinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_linear_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout);
        Product p1 = new Product();
        p1.initialLoad();
        ArrayList<Product> products = p1.getProducts();
        for (Product p : products) {
            LinearLayout horizontalLL = new LinearLayout(this);
            horizontalLL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalLL.setOrientation(LinearLayout.HORIZONTAL);
            ll.addView(horizontalLL);
            // Create imageview programativally
            // ImageView iv = new ImageView(getApplicationContext());
            // iv.setImageDrawable(getDrawable(c.getImageId()));
            // LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 300);
            // iv.setLayoutParams(lp);
            // horizontalLL.addView(iv);

            TextView t = new TextView(ll.getContext());
            t.setText(p.getName());
            t.setTextSize(22f);
            t.setPadding(2, 30, 2, 15);
            t.setLayoutParams(new LinearLayout.LayoutParams(700, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalLL.addView(t);


            Button b = new Button(ll.getContext());
            b.setText("ADD");
            b.setTextSize(22f);
            b.setPadding(2, 30, 2, 15);
            horizontalLL.addView(b);

        }
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