package com.lewgmail.romanenko.taxiservice.model.api.apiMain;

import com.lewgmail.romanenko.taxiservice.model.pojo.AddOrder;
import com.lewgmail.romanenko.taxiservice.model.pojo.UpdateOrder;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Lev on 18.11.2016.
 */

public interface OrderApiCust {
    @POST("/order")
    Observable<String> addOrder(@Header("Authorization") String authorization,
                                @Body() AddOrder addOrder);


    @DELETE("/order/{orderId}")
    Observable<String> deleteOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") long orderId);

    @PUT("/order/{orderId}")
    Observable<String> updateOrder(@Header("Authorization") String authorization,
                                   @Path("orderId") long orderId,
                                   @Body UpdateOrder updateOrder);
}
