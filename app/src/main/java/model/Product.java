package model;

import com.example.P20212.R;

import java.util.ArrayList;

public class Product {
    private String name;
    private double price;
    private String description;
    private int imageId;
    private ArrayList<Product> products= new ArrayList<Product>();

    public Product(){
        this.name=name;
        this.price=price;
        this.description=description;
    }

    public Product(String name, double price, String description, int imageId){
        this.name=name;
        this.price=price;
        this.description=description;
        this.imageId=imageId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void initialLoad(){
        products.add(new Product("Bread",0.2,"", R.drawable.bread));
        products.add(new Product("Fat Milk",0.5,"", R.drawable.milk));
        products.add(new Product("Cereals mix 1kg",8.35,"",R.drawable.cereals));
        products.add(new Product("Iogurt 0.275kg",0.5,"",R.drawable.iogurt));
        products.add(new Product("Banana (kg)",2.65,"",R.drawable.banane));
        products.add(new Product("Apple (kg)",2.34,"",R.drawable.apple));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
