package com.lewgmail.romanenko.taxiservice.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lev on 15.11.2016.
 */

public class Token {
    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("expires_in")
    private int expiresIn;

    public Token() {
    }

    public Token(String accessToken) {
        mAccessToken = accessToken;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}
