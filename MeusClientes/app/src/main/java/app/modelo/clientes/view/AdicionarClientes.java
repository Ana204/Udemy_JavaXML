package app.modelo.clientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.clientes.R;


public class AdicionarClientes extends Fragment {

    View view;

    public AdicionarClientes() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.adicionar_cliente, container, false);

//        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
//        txtTitulo.setText(R.string.modelo_fragment);

        //txtTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));

        return view;
    }


}