package com.lewgmail.romanenko.taxiservice.presenter;

/**
 * Created by Lev on 20.11.2016.
 */

public class CustomerPresenter {

    private int codeMsg;

    private String responseMsg;

    public void addOrder() {

    }

    public void deleteOrder() {

    }

    public void updateOrder() {

    }

    public void onFinishRequest(int codeMsg, String responseMsg) {

        this.codeMsg = codeMsg;
        this.responseMsg = responseMsg;

    }

    public int getCodeMsg() {
        return codeMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }


}
