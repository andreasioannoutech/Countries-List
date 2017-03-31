package com.kikkos.retrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kikkos.retrofit.R;
import com.kikkos.retrofit.data.Country;
import com.kikkos.retrofit.io.ApiClient;
import com.kikkos.retrofit.io.CountriesApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CountriesRecyclerAdaptor mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerAdapter = new CountriesRecyclerAdaptor(this);
        recyclerView.setAdapter(mRecyclerAdapter);

        CountriesApiResponse apiResponse = ApiClient.getClient().create(CountriesApiResponse.class);

        Call<List<Country>> call = apiResponse.getAllCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> countries = response.body();
                mRecyclerAdapter.swapItems(countries);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("TEST", t.toString());
            }
        });
    }

}
