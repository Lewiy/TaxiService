package com.lewgmail.romanenko.taxiservice.model.dataManager;

import com.lewgmail.romanenko.taxiservice.model.api.OrderApiDriver;
import com.lewgmail.romanenko.taxiservice.model.api.Services;
import com.lewgmail.romanenko.taxiservice.model.pojo.Order;
import com.lewgmail.romanenko.taxiservice.model.pojo.OrderStatus;
import com.lewgmail.romanenko.taxiservice.presenter.DriverPresenter;

import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lev on 20.11.2016.
 */

public class ManagerOrderApiDriver {

    private DriverPresenter mDriverPreswnter;

    public ManagerOrderApiDriver(DriverPresenter driverPresenter) {
        this.mDriverPreswnter = driverPresenter;
    }

    public void getAllOrdersType(OrderStatus orderStatus) {

        OrderApiDriver servises = Services.createService(OrderApiDriver.class);
        Observable<List<Order>> observer = servises.getAllOrderType(LoggedUser.getmInstance().getToken(), orderStatus.toString());

        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Order>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        if (e instanceof HttpException)
                            mDriverPreswnter.onFinishRequest(((HttpException) e).code(), e.getMessage());
                        else mDriverPreswnter.onFinishRequest(0, e.getMessage());

                    }

                    @Override
                    public void onNext(List<Order> orders) {

                        System.out.println("Дані прийшли" + getClass().getName());
                        mDriverPreswnter.loadOrderByType(orders);
                    }
                });
    }
}
