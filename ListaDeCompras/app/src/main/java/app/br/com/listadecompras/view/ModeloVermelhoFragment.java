package app.br.com.listadecompras.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.br.com.listadecompras.R;


public class ModeloVermelhoFragment extends Fragment {

    View view;

    public ModeloVermelhoFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_vermelho, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));

        return view;
    }


}