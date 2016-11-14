package com.lewgmail.romanenko.taxiservice.model.api;

import com.lewgmail.romanenko.taxiservice.model.pojo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lev on 13.11.2016.
 */

public interface CreateAccount {

    @POST("/user")
    @FormUrlEncoded
    Call<User> registration(
            @Body User user);

}
