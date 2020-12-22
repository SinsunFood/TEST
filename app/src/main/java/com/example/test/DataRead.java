package com.example.test;

import android.media.Image;

import java.util.ArrayList;



public class DataRead {
    ArrayList<Menu> items = new ArrayList<>();

    public ArrayList<Menu>getItems(){

        Menu menu1 = new Menu(R.drawable.food1,"나물","시금치무침","갓딴시금치로 조물조물~");
        Menu menu2 = new Menu(R.drawable.food2,"조림","장조림","방금낳은 메추리와 신선한 우둔살의 조합");
        Menu menu3 = new Menu(R.drawable.food3,"육류","양념갈비","양념된 갈비");
        Menu menu4 = new Menu(R.drawable.food4,"전","애호박전","호박전");
        Menu menu5 = new Menu(R.drawable.food5,"육류","제육볶음","제육볶음");
        Menu menu6 = new Menu(R.drawable.food6,"육류","갈비찜","갈비찜");

        items.add(menu1);
        items.add(menu2);
        items.add(menu3);
        items.add(menu4);
        items.add(menu5);
        items.add(menu6);

        return items;
    }
}
