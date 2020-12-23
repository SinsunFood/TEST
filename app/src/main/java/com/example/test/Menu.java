package com.example.test;

public class Menu {
    private String id;
    private String menuName;
    private int price;
    private int grams;
    private String image;

    public Menu(String id, String menuName, int price, int grams, String image) {
        this.id = id;
        this.menuName = menuName;
        this.price = price;
        this.grams = grams;
        this.image = image;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
