package com.zero.bless.demo.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zero.bless.MainActivity;
import com.zero.bless.R;
import com.zero.bless.demo.hybrid.WebApp;

/**
 * Created by xiaocai on 2018/3/26.
 */

public class DemoOne extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_one);

        webApp();

    }

    public void webApp(){

        Button webAppBtn = (Button)findViewById(R.id.web_app_button);

        webAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(DemoOne.this, WebApp.class);
                startActivity(intent);

            }
        });

    }

}
