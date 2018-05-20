package com.zero.library_z_pub.junit.entity;

/**
 * Created by xiaocai on 2018/5/8.
 */

public class Banana extends Fruit {

    private static String COLOR = "黄色的";

    public Banana(){
    }

    public static String getCOLOR(){
        return COLOR;
    }

    public String getBananaInfo(){
        return getCOLOR()+flavor();
    }

    private String flavor(){
        return "甜甜的";
    }

    public final boolean isLink(){
        return true;
    }

}
