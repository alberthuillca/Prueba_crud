package com.example.prueba_crud.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerProducto {

    public static  final String url="https://producto-new.herokuapp.com";
    private static Retrofit retrofit;

    public static Retrofit getApiProducto(){
        if (retrofit == null){
            retrofit =  new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
