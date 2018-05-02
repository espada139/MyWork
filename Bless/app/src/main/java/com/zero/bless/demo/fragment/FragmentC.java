package com.zero.bless.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zero.bless.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xiaocai on 18-4-11.
 */

public class FragmentC extends Fragment {

    @OnClick(R.id.btn_submit)
    public void onClick(View view){

        if(getActivity() instanceof CallBack){

            ((CallBack)getActivity()).onGoToHome();

        }

    }

    @Override
    public void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_c, parent, false);

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

    private void initView(View view){

        RelativeLayout contentCRel = (RelativeLayout)view.findViewById(R.id.rel_content_c);

        contentCRel.setVisibility(View.VISIBLE);

    }

    public static FragmentC newInstance(){

        FragmentC fragmentC = new FragmentC();

        return fragmentC;

    }

    public interface CallBack{

        void onGoToHome();

    }

}
