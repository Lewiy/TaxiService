package com.lewgmail.romanenko.taxiservice.presenter;

import android.view.View;

import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;

/**
 * Created by Lev on 06.11.2016.
 */

public class BasePresenter implements BasePresenterInterface {

    private View view;
    private OrderId orderId;


    public BasePresenter(View view) {
        this.view = view;
    }

    /* for testing*/
    public BasePresenter() {

    }

    @Override
    public void signIn() {

    }

    /* for testing*/
    public OrderId getOrderSpecificId() {
        return orderId;
    }

    public void setOrderSpecificId(OrderId orderId) {
        this.orderId = orderId;
    }

    /*
     Error processing
     */
    public void onFinishRequest(int responceCode, String responceMsg) {


    }
}
