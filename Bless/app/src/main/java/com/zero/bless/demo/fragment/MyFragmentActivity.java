package com.zero.bless.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.zero.bless.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by xiaocai on 18-4-11.
 */

public class MyFragmentActivity extends FragmentActivity implements FragmentA.CallBack, FragmentB.CallBack, FragmentC.CallBack {

    private FragmentA mFragmentA = null;
    private FragmentB mFragmentB = null;
    private FragmentC mFragmentC = null;

    public MyFragmentActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_fragment);

        ButterKnife.bind(this);

        init();

    }

    private void init(){

        if(mFragmentA == null){

            mFragmentA = FragmentA.newInstance();

        }

        if(mFragmentB == null){

            mFragmentB = FragmentB.newInstance();

        }

        if(mFragmentC == null){

            mFragmentC = FragmentC.newInstance();

        }

        switchFg(0);

    }

    private void switchFg(int code){

        FragmentManager fgManager = getSupportFragmentManager();

        FragmentTransaction fgTransaction = fgManager.beginTransaction();

        if(code == 0){

            fgTransaction.add(R.id.container, mFragmentA);

        }
        else if(code == 1){

            fgTransaction.replace(R.id.container, mFragmentB);
//            fgTransaction.addToBackStack("to b");

        }
        else if(code == 2){

            fgTransaction.replace(R.id.container, mFragmentC);
//            fgTransaction.addToBackStack("to c");

        }
        else if(code == 3){

            fgTransaction.replace(R.id.container, mFragmentA);

        }

        fgTransaction.commit();

        testFg(code);

    }

    public void testFg(int code){

        List<Fragment> fragments = getSupportFragmentManager().getFragments();

        for(int i = 0; i < fragments.size(); i++){

            Log.d(">>>>> debug code = "+code, "fragment i = "+i+" is " + fragments.get(i).toString());

        }

    }

    @Override
    public void onSubmit(String value){

        switchFg(1);

    }

    @Override
    public void onGoTo(){

        switchFg(2);

    }

    @Override
    public void onGoToHome(){

        switchFg(3);

    }

}
