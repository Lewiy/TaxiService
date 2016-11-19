package com.lewgmail.romanenko.taxiservice.model.DataManager;

import com.lewgmail.romanenko.taxiservice.model.api.OrderApiDrivCust;
import com.lewgmail.romanenko.taxiservice.model.api.Services;
import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;
import com.lewgmail.romanenko.taxiservice.presenter.BasePresenter;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lev on 19.11.2016.
 */

public class ManagerOrderApiDrivCust {

    private BasePresenter mBasePresenter;

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

                    }

                    @Override
                    public void onNext(OrderId orderId) {

                    }
                });
    }

}
