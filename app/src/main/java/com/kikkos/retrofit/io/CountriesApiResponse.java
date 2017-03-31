package com.kikkos.retrofit.io;

import com.kikkos.retrofit.data.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kikkos on 31/03/2017.
 */

public interface CountriesApiResponse {

    @GET("all")
    Call<List<Country>> getAllCountries();

    @GET("name/{name}")
    Call<Country> getCountry(@Path("name") String name);
}
