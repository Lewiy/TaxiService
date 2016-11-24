package com.lewgmail.romanenko.taxiservice.presenter;

import android.view.View;

import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;

/**
 * Created by Lev on 06.11.2016.
 */

public class BasePresenter implements BasePresenterInterface {

    private View view;
    private OrderId orderId;

    // for testing
    private String responseMsg;
    private int responceCode;

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


    /////////////////////RequestMethod///////////////////////////////////////////////


    ////////////////Response method///////////////////////////////////////////////
    public String getResponseMsg() {
        return this.responseMsg;
    }

    public int getResponceCode() {
        return this.responceCode;
    }

    /*
     Error processing
     */
    public void onFinishRequest(int responceCode, String responseMsg) {
        this.responceCode = responceCode;
        this.responseMsg = responseMsg;
    }


}
