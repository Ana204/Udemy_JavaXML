package app.novo.appmediaescolar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import app.novo.appmediaescolar.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    TextView media,situacao;
    EditText edtMateria, edtNotaTrabalho, edtNotaProva;
    Button calcular;

    double notaProva,notaTrabalho, dMedia;
    boolean dadosValidados = true;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        edtMateria = view.findViewById(R.id.edtMateria);
        edtNotaProva = view.findViewById(R.id.edtNotaProva);
        edtNotaTrabalho = view.findViewById(R.id.edtNotaTrabalho);
        media = view.findViewById(R.id.media);
        situacao = view.findViewById(R.id.situacao);
        calcular = view.findViewById(R.id.calcular);

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    if(edtNotaProva.getText().toString().length()>0){
                        notaProva = Double.parseDouble(edtNotaProva.getText().toString());
                    }else {
                        edtNotaProva.setError("Preencha o campo com sua nota");
                        edtNotaProva.requestFocus();
                        dadosValidados = false;
                    }

                    if(edtNotaTrabalho.getText().toString().length()>0){
                        notaTrabalho = Double.parseDouble(edtNotaTrabalho.getText().toString());
                    }else {
                        edtNotaTrabalho.setError("Preencha o campo com sua nota");
                        edtNotaTrabalho.requestFocus();
                        dadosValidados = false;
                    }

                    if (edtMateria.getText().toString().length()==0){
                        edtMateria.setError("Preencha o campo com o nome da matéria");
                        edtMateria.requestFocus();
                        dadosValidados = false;
                    }

                    if (dadosValidados) {
                        dMedia = (notaProva + notaTrabalho) / 2;
                        media.setText(String.valueOf(dMedia));

                        if (dMedia >= 6) {
                            situacao.setText("APROVADO");
                        } else {
                            situacao.setText("REPROVADO");
                        }
                    }

                    //Toast.makeText(getContext(), "BUTTON CALCULAR CLICADO", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getContext(), "INFORME AS NOTAS !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}