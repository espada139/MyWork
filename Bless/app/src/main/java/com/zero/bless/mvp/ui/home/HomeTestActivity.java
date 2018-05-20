package com.zero.bless.mvp.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.bless.R;
import com.zero.library_z_pub.sys.log.LogTool;
import com.zero.library_z_pub.sys.net.api.WanApi;
import com.zero.library_z_pub.sys.net.entity.callback.BaseCallback;
import com.zero.library_z_pub.sys.net.entity.callback.BaseError;
import com.zero.library_z_pub.sys.net.entity.callback.BaseResult;
import com.zero.library_z_pub.sys.utils.ScreenUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaocai on 18-4-26.
 */

public class HomeTestActivity extends Activity {

    private String mCloud = null;
    private String mPush = null;

    ReentrantLock mLock = new ReentrantLock();

    @Override
    public void onCreate(Bundle savedInstanceState){
        
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float wDp = dm.widthPixels/dm.density;
        System.out.println(">>>>> debug HomeTestActivity width="+dm.widthPixels+" denity="+dm.density+" wdp="+wDp);

        ScreenUtils.logScreenInfo(this);

        Map<String,String> params = new HashMap<String,String>();
        params.put("page", "0");

        new Thread(){
            @Override
            public void run(){

                try{

                    int time = (int)(Math.random()*10)*60;
                    System.out.println(">>>>> debug hometestactivity time="+time);
                    sleep(time);

//                    mCloud = "clound";

                    mLock.lock();

                    if(mPush != null && mPush.length() > 0){
                        System.out.println(">>>>> debug hometestactivity merge 2");
                        fresh("shangyun");
                    }

                }catch (Exception e){
                }finally {
//                    mLock.unlock();
                }

            }
        }.start();

        WanApi.getInstance().getArticalList(params, new BaseCallback<String, Exception>() {
            @Override
            public void onSuccess(BaseResult<String> result) {

                Map<String,String> params = new HashMap<>();

                WanApi.getInstance().getBanner(params, new BaseCallback<String, Exception>() {
                    @Override
                    public void onSuccess(BaseResult<String> result) {

                        if(mCloud != null && mCloud.length() > 0){
                            System.out.println(">>>>> debug hometestactivity merge 1");
                        }

                        Map<String,String> params = new HashMap<>();
                        WanApi.getInstance().getFriend(params, new BaseCallback<String, Exception>() {
                            @Override
                            public void onSuccess(BaseResult<String> result) {

//                                mLock.lock();

                                fresh("push");
                                mPush = "push";

//                                mLock.unlock();

                            }

                            @Override
                            public void onFailure(BaseError<Exception> error) {

                                if(mCloud != null && mCloud.length() > 0){
                                    System.out.println(">>>>> debug hometestactivity merge 1");
                                }

                            }
                        });

                    }

                    @Override
                    public void onFailure(BaseError<Exception> error) {
                    }
                });

            }

            @Override
            public void onFailure(BaseError<Exception> error) {
            }
        });

        testLock();

        testView();

    }

    public synchronized void fresh(String from){
        System.out.println(">>>>> debug hometestactivity fresh from="+from);
    }

    int count = 0;
    public void testLock(){

        for(int i = 0; i < 100; i++){

            final int num = i;

            new Thread(){
                @Override
                public void run(){

                    int time = (int)(Math.random()*10)*60;
//                    System.out.println(">>>>> debug hometestactivity time="+time);
                    try {
                        mLock.lock();
                        sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        mLock.unlock();
                    }
                    count++;
                    System.out.println(">>>>> debug hometestactivity i = "+num+" count="+count);

                }
            }.start();

        }

    }

    public void testView(){
        final EditText testInputEt = (EditText)findViewById(R.id.test_input_et);
        Button saveBtn = (Button)findViewById(R.id.save_test);
        final TextView rightBarTitle = (TextView)findViewById(R.id.right_bar_title);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                rightBarTitle.setText("save click");
                Toast.makeText(HomeTestActivity.this,testInputEt.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
