package com.lewgmail.romanenko.taxiservice.presenter;

import android.view.View;

/**
 * Created by Lev on 06.11.2016.
 */

public class BasePresenter implements BasePresenterInterface {

    private View view;

    public BasePresenter(View view) {
        this.view = view;
    }

    @Override
    public void signIn() {

    }
}
