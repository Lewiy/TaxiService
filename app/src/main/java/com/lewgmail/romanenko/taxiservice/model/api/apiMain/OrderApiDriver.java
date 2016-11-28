package com.lewgmail.romanenko.taxiservice.model.api.apiMain;

import com.lewgmail.romanenko.taxiservice.model.pojo.Order;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Lev on 18.11.2016.
 */

public interface OrderApiDriver {

    @GET("/order/{orderStatus}")
    Observable<List<Order>> getAllOrderType(@Header("Authorization") String authorization,
                                            @Path("orderStatus") String type);
}
