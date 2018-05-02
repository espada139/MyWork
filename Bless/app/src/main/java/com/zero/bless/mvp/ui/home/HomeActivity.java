package com.zero.bless.mvp.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.IconMarginSpan;
import android.text.style.TextAppearanceSpan;
import android.view.MenuItem;
import android.widget.TextView;

import com.zero.bless.R;
import com.zero.bless.mvp.base.ui.BaseActivity;

import java.lang.reflect.GenericArrayType;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiaocai on 18-4-15.
 */

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected int getLayoutId(){

        return R.layout.activity_home;

    }

    @Override
    public void initView(Bundle savedInstanceState){

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);

        if(mNavigationView != null){

            setupDrawerContent(mNavigationView);

        }

        textExtand();

    }

    @Override
    public void initData(){
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case android.R.id.home:{

                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            }

        }

        return super.onOptionsItemSelected(item);

    }

    private void setupDrawerContent(NavigationView navView){

        if(mNavigationView != null){

            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){

                        case R.id.list_navigation_menu_item:{

                            break;

                        }
                        default:{
                            break;
                        }

                    }

                    item.setChecked(true);

                    if(mDrawerLayout != null){

                        mDrawerLayout.closeDrawers();

                    }

                    return true;

                }
            });

        }

    }

    public void textExtand(){
        String content = "lkkkkkkkkkkkkkkkk";

        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ssb.setSpan(new IconMarginSpan(bitmap, 60), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textText = (TextView)findViewById(R.id.test_text);

        textText.setText(ssb);

    }

}
