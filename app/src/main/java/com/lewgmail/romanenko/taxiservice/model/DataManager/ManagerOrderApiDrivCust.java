package com.lewgmail.romanenko.taxiservice.model.dataManager;

import com.lewgmail.romanenko.taxiservice.model.api.Services;
import com.lewgmail.romanenko.taxiservice.model.api.apiMain.OrderApiDrivCust;
import com.lewgmail.romanenko.taxiservice.model.pojo.MarkOrder;
import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;
import com.lewgmail.romanenko.taxiservice.presenter.BasePresenter;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lev on 19.11.2016.
 */

public class ManagerOrderApiDrivCust {

    private BasePresenter mBasePresenter;
    /* for test*/
    private OrderId orderIdTEST;

    public ManagerOrderApiDrivCust() {

    }

    public ManagerOrderApiDrivCust(BasePresenter presenter) {

        this.mBasePresenter = presenter;

    }

    public void loadOrderId(int orderId) {
        OrderApiDrivCust servises = Services.createService(OrderApiDrivCust.class);
        Observable<OrderId> observer = servises.getOrderId(LoggedUser.getmInstance().getToken(), orderId);

        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderId>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException)
                            mBasePresenter.onFinishRequest(((HttpException) e).code(), e.getMessage());
                        else mBasePresenter.onFinishRequest(0, e.getMessage());
                    }

                    @Override
                    public void onNext(OrderId orderId) {
                        System.out.println(" Дані пришли - кастомер" + orderId.getCustomer());
                        // mBasePresenter.setOrderSpecificId(orderId);
                    }
                });
    }

    public void acceptRefuseDoneOrder(long orderId,MarkOrder markOrder) {

        OrderApiDrivCust servises = Services.createService(OrderApiDrivCust.class);
        Observable<String> observer = servises.acceptOrder(LoggedUser.getmInstance().getToken(),
                orderId,
                markOrder);

        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        if (e instanceof HttpException)
                            mBasePresenter.onFinishRequest(((HttpException) e).code(), e.getMessage());
                        else mBasePresenter.onFinishRequest(0, e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
    }

}
