package com.lewgmail.romanenko.taxiservice.model.api;

import com.lewgmail.romanenko.taxiservice.model.pojo.Order;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observer;

/**
 * Created by Lev on 18.11.2016.
 */

public interface OrderApiDriver {

    @GET("/order/{orderStatus}")
    Observer<List<Order>> getAllOrderType(@Path("orderStatus") String type);
}
