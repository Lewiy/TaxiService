package com.lewgmail.romanenko.taxiservice.presenter;

import com.lewgmail.romanenko.taxiservice.model.DTO.DataGoogleMapDTO;
import com.lewgmail.romanenko.taxiservice.model.dataManager.ManagerGoogleMaps;
import com.lewgmail.romanenko.taxiservice.view.activity.IView;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Lev on 01.12.2016.
 */

public class MapGooglePresenter implements BasePresenterInterface {

    private ManagerGoogleMaps managerGoogleMaps = new ManagerGoogleMaps();
    private IView view;
    private Subscription subscription = Subscriptions.empty();

    public MapGooglePresenter(IView view) {
        this.view = view;
    }

    public void onPutMapMarkers(double longitude1, double latitude1, double longitude2, double latitude2) {

        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        Observable<DataGoogleMapDTO> observer = managerGoogleMaps.getDistance(longitude1, latitude1, longitude2, latitude2);

        subscription = observer
                .subscribe(new Observer<DataGoogleMapDTO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DataGoogleMapDTO dataGoogleMapDTO) {

                    }
                });


    }

    public void calculatePrice() {

    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
