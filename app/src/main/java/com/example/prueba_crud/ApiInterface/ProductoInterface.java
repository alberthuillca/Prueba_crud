package com.example.prueba_crud.ApiInterface;

import com.example.prueba_crud.Modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoInterface {

    @GET("/")
    Call<List<Producto>> listar_productos();
}
