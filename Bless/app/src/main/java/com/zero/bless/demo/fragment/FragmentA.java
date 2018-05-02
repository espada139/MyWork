package com.zero.bless.demo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zero.bless.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * Created by xiaocai on 18-4-11.
 */

public class FragmentA extends Fragment {

    public final static String TAG = "FragmentA";

    private CallBack mCallBack;

    @OnClick(R.id.btn_submit)
    public void onClick(View view){

        if(getActivity() instanceof CallBack){

            ((CallBack)getActivity()).onSubmit("");

        }

    }

    @Override
    public void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        super.onCreateView(inflater, parent, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_a, parent, false);

        ButterKnife.bind(this, view);

        initView(view);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume(){

        super.onResume();

    }

    @Override
    public void onSaveInstanceState(Bundle state){

        super.onSaveInstanceState(state);

    }

    @Override
    public void onDestroyView(){

        super.onDestroyView();

    }

    @Override
    public void onDestroy(){

        super.onDestroy();

    }

    public void initView(View view){

        RelativeLayout contentARel = (RelativeLayout)view.findViewById(R.id.rel_content_a);

        contentARel.setVisibility(View.VISIBLE);

    }

    public void setCallBack(CallBack callBack){

        this.mCallBack = callBack;

    }

    public static FragmentA newInstance(){

        FragmentA fragmentA = new FragmentA();

        return fragmentA;

    }

    public interface CallBack{

        void onSubmit(String value);

    }

}
