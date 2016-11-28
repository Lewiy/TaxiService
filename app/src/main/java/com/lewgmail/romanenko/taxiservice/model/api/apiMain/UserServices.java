package com.lewgmail.romanenko.taxiservice.model.api.apiMain;

import com.lewgmail.romanenko.taxiservice.model.pojo.Token;
import com.lewgmail.romanenko.taxiservice.model.pojo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Lev on 13.11.2016.
 */

public interface UserServices {

    @POST("/user")
    Call<Token> registration(@Body User user);

    @GET("/user/{userId}")
    Observable<User> getUserProfile(@Path("userId") int id);

    @PUT("/user/{userId}")
    Observable<String> updateUserProfile(@Path("userId") int id);



}
