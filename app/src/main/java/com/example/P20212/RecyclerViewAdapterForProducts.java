package com.example.P20212;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Product;

public class RecyclerViewAdapterForProducts extends RecyclerView.Adapter<RecyclerViewAdapterForProducts.ViewHolder> {
    private static final String TAG = "ProductsAdapter";
    private ArrayList<Product> products;

    public RecyclerViewAdapterForProducts(ArrayList<Product> dataSet) { products = dataSet;  }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textViewPrice;
        private final ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textViewDescription);
            textViewPrice = (TextView) v.findViewById(R.id.textViewPrice);
            this.imageView=(ImageView)v.findViewById(R.id.imageViewProduct);

        }
        public TextView getTextView() {
            return textView;
        }
        public TextView getTextViewPrice() { return textViewPrice;  }
        public ImageView getImageView() { return imageView; }
    }

     @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        viewHolder.getTextView().setText(products.get(position).getName());
        viewHolder.getTextViewPrice().setText("$: "+String.valueOf(products.get(position).getPrice()));
        viewHolder.getImageView().setImageDrawable(viewHolder.getImageView().getContext().getDrawable(products.get(position).getImageId()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
