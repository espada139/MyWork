package com.zero.library_z_pub.junit;

import com.zero.library_z_pub.sys.log.LogTool;
import com.zero.library_z_pub.sys.utils.DateUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by xiaocai on 2018/5/4.
 */
@RunWith(Parameterized.class)
public class DateUtilTest {

    private String date = "2017-10-15 16:00:02";
    private long stamp = 1508054402000L;
    private Date mDate;

    public DateUtilTest(String date){

        this.date = date;

    }

    @Parameterized.Parameters
    public static Collection primeNumbers(){

        return Arrays.asList(new String[]{
                "2017-10-15 16:00:02",
                "2017-10-15",
                "2017/10/15 16:00:02"
        });

    }

    @Before
    public void setUp() throws Exception{

        System.out.println(" 测试开始");
        mDate = new Date();
        mDate.setTime(stamp);

    }

    @After
    public void tearDown() throws Exception{

        System.out.println("测试结束");

    }

    @Test
    public void stampToDateTest() throws Exception{

        assertEquals("ddd", DateUtil.stampToDate(stamp));

    }

    @Test
    public void dateToStampTest() throws Exception{

        assertNotEquals(4, DateUtil.dateToStamp(date));

    }

    /**
     * @Test可以接受两个参数，expected是异常参数、timeout是超时参数。
     * @throws Exception
     */
    @Test(expected = ParseException.class, timeout = 10)
    public void dateToStampTestWithParseException() throws Exception{

        DateUtil.dateToStamp(this.date);

    }

    /**
     * @Ignore注解表示忽略该测试
     */
    @Test
    @Ignore("not implement yet")
    public void dateToStampNullTest(){
    }

}
