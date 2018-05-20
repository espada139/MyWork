package com.zero.library_z_pub.junit;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

/**
 * Created by xiaocai on 2018/5/7.
 */

public class MockitoSpyTest {

    @Spy
    Person mPerson;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testSpyRule(){

        assertEquals(10, mPerson.getAge());

    }

}
