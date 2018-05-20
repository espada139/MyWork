package com.zero.library_z_pub.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaocai on 2018/5/5.
 */

public class IsMobilePhoneMatcher extends BaseMatcher<String> {

    @Override
    public boolean matches(Object item){

        if(item == null){

            return false;

        }

        Pattern pattern = Pattern.compile("(1|861)(3|5|7|8)\\d{9}$*");
        Matcher matcher = pattern.matcher((String)item);

        return matcher.find();

    }

    @Override
    public void describeTo(Description description){

        description.appendText("预计测字符串是手机号码");

    }

    @Override
    public void describeMismatch(Object item, Description description){

        description.appendText(item.toString() + "不是手机号码");

    }

}
