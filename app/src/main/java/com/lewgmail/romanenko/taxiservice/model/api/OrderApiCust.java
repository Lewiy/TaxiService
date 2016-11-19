package com.lewgmail.romanenko.taxiservice.model.api;

import com.lewgmail.romanenko.taxiservice.model.pojo.AddOrder;
import com.lewgmail.romanenko.taxiservice.model.pojo.OrderStatus;
import com.lewgmail.romanenko.taxiservice.model.pojo.UpdateOrder;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Lev on 18.11.2016.
 */

public interface OrderApiCust {
    @POST("order")
    Observable<String> addOrder(@Header("Authorization") String authorization,
                                @Body() AddOrder addOrder);

    @FormUrlEncoded
    @PUT("order/{orderId}/status")
    Observable<String> acceptOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") int orderId,
                                   @Field("userId") int userId,
                                   @Field("type") OrderStatus orderStatus);

    @DELETE("/order/{orderId}")
    Observable<String> deleteOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") int orderId);

    @PUT("/order/{orderId}")
    Observable<String> updateOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") int orderId,
                                   @Body UpdateOrder updateOrder);
}
