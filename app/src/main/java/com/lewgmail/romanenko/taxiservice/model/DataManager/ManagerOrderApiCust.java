package com.lewgmail.romanenko.taxiservice.model.dataManager;

import com.lewgmail.romanenko.taxiservice.model.api.OrderApiCust;
import com.lewgmail.romanenko.taxiservice.model.api.Services;
import com.lewgmail.romanenko.taxiservice.model.pojo.AddOrder;
import com.lewgmail.romanenko.taxiservice.model.pojo.UpdateOrder;
import com.lewgmail.romanenko.taxiservice.presenter.CustomerPresenter;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lev on 20.11.2016.
 */

public class ManagerOrderApiCust {

    private CustomerPresenter mCustomerPresenter;

    public ManagerOrderApiCust(CustomerPresenter customerPresenter) {
        this.mCustomerPresenter = customerPresenter;
    }

    public void addOrder(AddOrder addOrder) {
        OrderApiCust servises = Services.createService(OrderApiCust.class);
        Observable<String> observer = servises.addOrder(LoggedUser.getmInstance().getToken(), addOrder);

        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        mCustomerPresenter.addOrder();
                    }
                });
    }

    public void deleteOrder(long orderId) {

        OrderApiCust servises = Services.createService(OrderApiCust.class);
        Observable<String> observer = servises.deleteOrder(LoggedUser.getmInstance().getToken(), orderId);

        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        mCustomerPresenter.deleteOrder();
                    }
                });
    }

    public void updateOrder(UpdateOrder updateOrder, long orderId) {

        OrderApiCust servises = Services.createService(OrderApiCust.class);
        Observable<String> observer = servises.updateOrder(LoggedUser.getmInstance().getToken(),
                orderId,
                updateOrder);
        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        mCustomerPresenter.updateOrder();
                    }
                });

    }
}
