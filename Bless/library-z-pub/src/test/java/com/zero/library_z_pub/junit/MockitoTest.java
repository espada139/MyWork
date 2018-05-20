package com.zero.library_z_pub.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.after;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by xiaocai on 2018/5/6.
 */

public class MockitoTest {

    @Mock
    Person mPerson;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testPersonNotNull(){

        Person person = mock(Person.class);

        assertNotNull(person);

    }

    @Test
    public void testPersonText(){

        Person person = mock(Person.class);

        when(person.isTestEmpty("")).thenReturn(true);

        assertTrue(person.isTestEmpty(""));

    }

    @Test
    public void testPersonNotNullByAnnimoction(){

        assertNotNull(mPerson);

    }

    @Test
    public void testPersonName(){

        doReturn("tt").when(mPerson).getName();

        assertEquals("tt", mPerson.getName());

    }

    @Test
    public void testPersonEat(){

        when(mPerson.eat(anyString())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocation) throws Throwable{

                Object[] args = invocation.getArguments();

                return args[0] + "好吃";

            }

        });

        System.out.println(mPerson.eat("罐罐面"));

    }

    @Test
    public void testVerify(){

        when(mPerson.getAge()).thenReturn(10);

        System.out.println("age = "+mPerson.getAge());

        System.out.println("begin = "+System.currentTimeMillis());
        verify(mPerson, after(1000)).getAge();
        System.out.println("end = "+System.currentTimeMillis());

        mPerson.getAge();
        verify(mPerson,atLeast(2)).getAge();

        verify(mPerson,timeout(100).times(3).description("not call 3 times")).getAge();

    }

    @Test
    public void testAny(){

        when(mPerson.eat(any(String.class))).thenReturn("Meat");

        System.out.println("any foot "+mPerson.eat("dd"));

    }

}
