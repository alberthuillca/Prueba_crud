package com.example.prueba_crud;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba_crud.API.ServerProducto;
import com.example.prueba_crud.Adapter.AdapterProducto;
import com.example.prueba_crud.ApiInterface.ProductoInterface;
import com.example.prueba_crud.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoActivity extends AppCompatActivity {

    private RecyclerView re_data;
    private RecyclerView.LayoutManager ly_data;
    private List<Producto> list_producto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        re_data = (RecyclerView) findViewById(R.id.data_productos);
        ly_data = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        re_data.setLayoutManager(ly_data);
        Toast.makeText(ProductoActivity.this, "Entramos", Toast.LENGTH_SHORT).show();
        geet_Producto();


    }

    public  void geet_Producto(){
        ProductoInterface data = ServerProducto.getApiProducto().create(ProductoInterface.class);
        Call<List<Producto>> data_producto = data.listar_productos();
        System.out.println("LLegue hasta aqui" + data_producto);
        data_producto.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful() && response.body() != null){
                    AdapterProducto adapter = new AdapterProducto(getApplicationContext(),response.body());
                    re_data.setAdapter(adapter);
                    System.out.println("tunas " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(ProductoActivity.this, "No existen Registros", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
