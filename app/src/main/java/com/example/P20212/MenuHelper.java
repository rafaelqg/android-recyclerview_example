package com.example.P20212;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.P20212.R;
import com.example.P20212.SecundaryActivity;
import com.example.P20212.VisibilityExample;

public class MenuHelper {


    public void menuActionsConfig(MenuItem item, Activity activity) {
        Intent myIntent;
        switch (item.getItemId()){
            case R.id.menu_item_1:
                myIntent = new Intent(activity.getBaseContext(), VisibilityExample.class);
                activity.startActivity(myIntent);
                break;
            case R.id.menu_item_2:
                myIntent = new Intent(activity.getBaseContext(), SecundaryActivity.class);
                activity.startActivity(myIntent);
                break;
            case R.id.menu_item_recycler_view:
                myIntent = new Intent(activity.getBaseContext(), ActivityRecyclerView.class);
                activity.startActivity(myIntent);
                break;
            case R.id.menu_item_linear_layout:
                myIntent = new Intent(activity.getBaseContext(), ActivityDynamicLinearLayout.class);
                activity.startActivity(myIntent);
                break;
            default:
        }
    }
}
