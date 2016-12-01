package com.lewgmail.romanenko.taxiservice.model.dataManager;

import com.lewgmail.romanenko.taxiservice.model.api.ServicesGoogleMaps;
import com.lewgmail.romanenko.taxiservice.model.api.apiGoogleMaps.ApiGoogleMaps;
import com.lewgmail.romanenko.taxiservice.model.pojo.pojoResponseDistance.DistanceGoogleResponse;
import com.lewgmail.romanenko.taxiservice.presenter.BasePresenter;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lev on 28.11.2016.
 */

public class ManagerGoogleMaps {

    private BasePresenter basePresenter;

    public ManagerGoogleMaps(BasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }

    public void getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        ApiGoogleMaps servises = ServicesGoogleMaps.createService(ApiGoogleMaps.class);
        Observable<DistanceGoogleResponse> observer = servises.getDistace(
                Double.valueOf(longitude1) + "," + Double.valueOf(latitude1),
                Double.valueOf(longitude2) + "," + Double.valueOf(latitude2));
        observer.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DistanceGoogleResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            basePresenter.onFinishRequest(((HttpException) e).code(), e.getMessage());
                            System.out.println(e.getMessage());
                        } else {
                            basePresenter.onFinishRequest(0, e.getMessage());
                            System.out.println(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(DistanceGoogleResponse s) {
                        System.out.println(
                                s.getRows().get(0).getElements().get(0).getDistance().getText());
                    }
                });
    }
}
