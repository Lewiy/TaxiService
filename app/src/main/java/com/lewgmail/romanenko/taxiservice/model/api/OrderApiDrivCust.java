package com.lewgmail.romanenko.taxiservice.model.api;

import com.lewgmail.romanenko.taxiservice.model.pojo.OrderId;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @FormUrlEncoded
    @PUT("order/{orderId}/status")
    Observable<String> acceptOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") long orderId,
                                   @Field("userId") long userId,
                                   @Field("type") String orderStatus);
}
