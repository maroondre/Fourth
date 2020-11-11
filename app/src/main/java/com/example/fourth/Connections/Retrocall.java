package com.example.fourth.Connections;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrocall {

    public static String APIKEY = "9e7bfa22b11347bd7d5029d317c58cd1564cb579efd7526494e00dca2fcc6546";

    public ApiCall retrofitBuilder(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiCall.Soccer)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiCall apiCall = retrofit.create(ApiCall.class);

        return apiCall;
    }

    public ApiCall retrofitVideo(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiCall.BASE_URLPOD)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiCall apiCall = retrofit.create(ApiCall.class);

        return apiCall;
    }


}
