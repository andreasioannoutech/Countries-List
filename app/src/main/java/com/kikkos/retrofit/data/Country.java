package com.kikkos.retrofit.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kikkos on 31/03/2017.
 */

public class Country {
    @SerializedName("name")
    private String name;
    @SerializedName("nativeName")
    private String nativeName;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String region;
    @SerializedName("population")
    private int population;
    @SerializedName("flag")
    private String flag;
    @SerializedName("currencies")
    private List<Currency> currencies;

    public Country(String name, String nativeName, String capital, String region, int population, String flag, List<Currency> currencies) {
        this.name = name;
        this.nativeName = nativeName;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.flag = flag;
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
