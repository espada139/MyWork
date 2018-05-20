package com.zero.library_z_pub.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by xiaocai on 2018/5/6.
 */

public class MyRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description){

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                // evaluate前执行方法相当于@Before
                String methodName = description.getMethodName();
                System.out.println(methodName+"测试开始");

                // 运行的测试方法
                base.evaluate();

                System.out.println(methodName+"测试结束");

            }
        };

    }

}
