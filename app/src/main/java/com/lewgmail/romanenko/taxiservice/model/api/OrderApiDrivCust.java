package com.lewgmail.romanenko.taxiservice.model.api;

import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Lev on 18.11.2016.
 */

public interface OrderApiDrivCust {
    @GET("/order/{orderId}")
    Observable<OrderId> getOrderId(@Header("Authorization") String authorization,
                                   @Path("orderId") int orderId);
}
