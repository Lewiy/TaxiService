package com.lewgmail.romanenko.taxiservice.model.api;

import com.lewgmail.romanenko.taxiservice.model.pojo.Car;
import com.lewgmail.romanenko.taxiservice.model.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lev on 13.11.2016.
 */

public interface CreateAccount {

    @POST("/user")
    @FormUrlEncoded
    Call<User> registration(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobileNumbers") List<String> mobileNumbers,
            @Field("userType") String userType,
            @Field("car") Car car);


}
