package com.zero.bless;

import com.zero.bless.demo.test.DemoOne;
import com.zero.bless.ui.SplashActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

/**
 *Robolectric测试
 * Created by xiaocai on 2018/5/9.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, buildDir = "app/build", sdk = 23)

public class ActivityTest {

    DemoOne demoOne;

    @Before
    public void setUp() throws Exception{
        demoOne = Robolectric.setupActivity(DemoOne.class);
    }

    @Test
    public void testMainActivity() throws Exception{
        assertNotNull(demoOne);
    }

}
