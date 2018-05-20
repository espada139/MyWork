package com.zero.library_z_pub.junit;

import android.text.TextUtils;

/**
 * Created by xiaocai on 2018/5/6.
 */

public class Person {

    public Person(){
    }

    public boolean isTestEmpty(String text){

        return TextUtils.isEmpty(text);

    }

    public String getName(){

        return "tt";

    }

    public int getAge(){

        return 10;

    }

    public String eat(String food){

        return "";

    }

}
