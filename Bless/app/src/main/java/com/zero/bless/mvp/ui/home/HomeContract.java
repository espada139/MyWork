package com.zero.bless.mvp.ui.home;

import com.zero.bless.mvp.base.BasePresenter;
import com.zero.bless.mvp.base.BaseView;

/**
 * Created by xiaocai on 18-4-15.
 */

public interface HomeContract {

    interface IView extends BaseView{

        void showToast();

    }

    interface IHomePresenter extends BasePresenter{

        void loadData();

    }

}
