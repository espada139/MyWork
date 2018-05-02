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

public class FragmentB extends Fragment {

    @OnClick(R.id.btn_submit)
    public void onClick(View view){

        if(getActivity() instanceof CallBack){

            ((CallBack)getActivity()).onGoTo();

        }

    }

    @Override
    public void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_b, parent, false);

        ButterKnife.bind(this,view);

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

        RelativeLayout contentBRel = (RelativeLayout)view.findViewById(R.id.rel_content_b);

        contentBRel.setVisibility(View.VISIBLE);

    }

    public static FragmentB newInstance(){

        FragmentB fragmentB = new FragmentB();

        return fragmentB;

    }

    public interface CallBack {

        void onGoTo();

    }

}
