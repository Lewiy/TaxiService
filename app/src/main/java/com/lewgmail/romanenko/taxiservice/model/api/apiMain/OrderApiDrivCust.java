package com.lewgmail.romanenko.taxiservice.model.api.apiMain;

import com.lewgmail.romanenko.taxiservice.model.pojo.MarkOrder;
import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Lev on 18.11.2016.
 */

public interface OrderApiDrivCust {
    @GET("/order/{orderId}")
    Observable<OrderId> getOrderId(@Header("Authorization") String authorization,
                                   @Path("orderId") long orderId);

    @PUT("/order/{orderId}/status")
    Observable<String> acceptOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") long orderId,
                                   @Body MarkOrder markOrder);
}
