package com.example.test;

import javax.xml.namespace.QName;

public class Menu {
    private int image;
    private String type;
    private String name;
    private String content;

    public Menu(int image, String type, String name, String content) {
        this.image = image;
        this.type = type;
        this.name = name;
        this.content = content;

    }

    public int getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
