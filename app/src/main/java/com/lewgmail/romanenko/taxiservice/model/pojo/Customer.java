
package com.lewgmail.romanenko.taxiservice.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Customer {

    @SerializedName("customerId")
    @Expose
    private String customerId;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * @return The customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId The customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
