package com.lewgmail.romanenko.taxiservice.model;

import com.lewgmail.romanenko.taxiservice.model.api.CreateAccount;
import com.lewgmail.romanenko.taxiservice.model.api.Services;
import com.lewgmail.romanenko.taxiservice.model.pojo.User;

import retrofit2.Call;

/**
 * Created by Lev on 14.11.2016.
 */

public class Model {

    public void registration(User user) {

        CreateAccount servises = Services.createService(CreateAccount.class);
        Call<User> observable = servises.registration(user);
    }
}
