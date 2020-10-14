package com.example.prueba_crud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba_crud.Modelo.Producto;
import com.example.prueba_crud.R;

import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.RetenerData>{
    private Context context;
    private List<Producto> lista_pro;

    public AdapterProducto(Context context, List<Producto> lista_pro) {
        this.context = context;
        this.lista_pro = lista_pro;
    }


    @NonNull
    @Override
    public RetenerData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta_item, parent, false);
        RetenerData retener = new RetenerData(layout);
        return retener;
    }

    @Override
    public void onBindViewHolder(@NonNull RetenerData retener, int position) {
        Producto producto = lista_pro.get(position);

        retener.pro_idc.setText(Integer.toString(producto.getIdproducto()));
        retener.pro_nombre.setText(producto.getNom_producto());
        retener.pro_precio.setText(Integer.toString(producto.getPrecio()));
        retener.pro_cantidad.setText(Integer.toString(producto.getCantidad()));
        retener.pro_idc.setText(Integer.toString(producto.getIdcategoria()));

    }

    @Override
    public int getItemCount() {
        System.out.println(lista_pro);
        return lista_pro.size();
    }

    public class RetenerData extends RecyclerView.ViewHolder{
        TextView pro_precio, pro_nombre, pro_cantidad, pro_id, pro_idc;


        public RetenerData(@NonNull View itemView) {
            super(itemView);

            pro_nombre = itemView.findViewById(R.id.p_nombre);
            pro_cantidad = itemView.findViewById(R.id.p_cantidad);
            pro_precio = itemView.findViewById(R.id.p_precio);
            pro_id = itemView.findViewById(R.id.p_idpro);
            pro_idc = itemView.findViewById(R.id.p_idc);

        }
    }
}
