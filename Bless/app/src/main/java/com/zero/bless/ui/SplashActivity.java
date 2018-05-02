package com.zero.bless.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.zero.bless.MainActivity;
import com.zero.bless.R;
import com.zero.bless.mvp.ui.home.HomeTestActivity;

/**
 * Created by Administrator on 2018/3/11.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setTheme(R.style.splash_theme);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                jumpToMain();

            }
        }, 3000);

    }

    public void jumpToMain()
    {

        Intent intent = new Intent();
        intent.setClass(this, HomeTestActivity.class);
        startActivity(intent);

    }

}
