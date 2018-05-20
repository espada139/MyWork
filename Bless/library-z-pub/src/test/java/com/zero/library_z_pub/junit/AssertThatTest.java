package com.zero.library_z_pub.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xiaocai on 2018/5/5.
 */

public class AssertThatTest {

    @Rule
//    public MyRule myRule = new MyRule();
    public Timeout timeout = new Timeout(1000);

    @Test
    public void assetTathTest1(){

        assertThat( "not equal",4, equalTo(4));

    }

    @Test
    public void assertPhone(){

        assertThat("15929531531", new IsMobilePhoneMatcher());

    }

}
