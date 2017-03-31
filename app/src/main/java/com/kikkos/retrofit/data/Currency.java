package com.kikkos.retrofit.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kikkos on 31/03/2017.
 */

public class Currency {
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
