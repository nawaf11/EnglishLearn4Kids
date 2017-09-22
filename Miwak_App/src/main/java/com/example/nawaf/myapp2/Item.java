package com.example.nawaf.myapp2;

/**
 * Created by nawaf on 10/18/16.
 */

public class Item {
    private String s1, s2;
    private int resImg;

    public Item(String s1, String s2, int resImg) {
        this.s1 = s1;
        this.s2 = s2;
        this.resImg = resImg;
    }


    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public int getResImg() {
        return resImg;
    }

}


