package com.zero.bless.mvp.base.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xiaocai on 18-4-15.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        initView(savedInstanceState);
        initData();

    }

    abstract protected int getLayoutId();

    abstract protected void initView(Bundle savedInstanceState);

    abstract protected void initData();

}
