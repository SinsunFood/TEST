package com.example.test;

public class Store_menu {

    private String id;
    private String menuName;
    private int price;
    private int grams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    @Override
    public String toString() {
        return "Store1_menu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", grams=" + grams +
                '}';
    }
}
