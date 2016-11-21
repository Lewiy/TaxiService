package com.lewgmail.romanenko.taxiservice.model.dataManager;

import com.lewgmail.romanenko.taxiservice.model.api.Services;
import com.lewgmail.romanenko.taxiservice.model.api.UserServices;
import com.lewgmail.romanenko.taxiservice.model.pojo.Token;
import com.lewgmail.romanenko.taxiservice.model.pojo.User;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by Lev on 14.11.2016.
 */

public class ManagerUser {

    public Token registration(User user) throws IOException {

        UserServices servises = Services.createService(UserServices.class);
        Call<Token> call = servises.registration(user);
        //Log.d("My log1"," Токен" +call.execute().body().getAccessToken());
        // Log.d("My log2","Номер токена" + call.execute().body().getExpiresIn());
        return call.execute().body();

        /*call.enqueue(new Callback<Token>() {

            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()) {
                    Token user = response.body();
                } else {
                    int statusCode = response.code();

                    // Обрабатываем HTTP ошибку
                    ResponseBody errorBody = response.errorBody();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        });*/
    }

}
