package com.zero.library_z_pub.junit;

import com.zero.library_z_pub.junit.entity.Banana;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by xiaocai on 2018/5/8.
 */
@RunWith(PowerMockRunner.class)
public class PowerMockitoStaticTest {

    @Test
    @PrepareForTest({Banana.class})
    public void testStaticMethod(){
        PowerMockito.mockStatic(Banana.class);
        Mockito.when(Banana.getCOLOR()).thenReturn("绿色");
        assertEquals("绿色", Banana.getCOLOR());
    }

    @Test
    @PrepareForTest({Banana.class})
    public void testChangeColor(){
        Whitebox.setInternalState(Banana.class, "COLOR", "红色");
        assertEquals("红色", Banana.getCOLOR());
    }

    @Test
    @PrepareForTest({Banana.class})
    public void testPrivateMethod() throws Exception{
        Banana mBanana = PowerMockito.mock(Banana.class);
        PowerMockito.when(mBanana.getBananaInfo()).thenCallRealMethod();
        PowerMockito.when(mBanana, "flavor").thenReturn("涩涩的");
        assertEquals("黄色的涩涩的", mBanana.getBananaInfo());
        PowerMockito.verifyPrivate(mBanana).invoke("flavor");
    }

    @Test
    @PrepareForTest({Banana.class})
    public void testFinalMethod(){
        Banana mBanan = PowerMockito.mock(Banana.class);
        PowerMockito.when(mBanan.isLink()).thenReturn(false);
        assertFalse(mBanan.isLink());
    }

    @Test
    @PrepareForTest({Banana.class})
    public void testNewClass() throws Exception{
        Banana mBanana = PowerMockito.mock(Banana.class);
        PowerMockito.when(mBanana.getBananaInfo()).thenReturn("大香蕉");
        PowerMockito.whenNew(Banana.class).withNoArguments().thenReturn(mBanana);
        Banana banana = new Banana();
        assertEquals("大香蕉", banana.getBananaInfo());
    }

}



