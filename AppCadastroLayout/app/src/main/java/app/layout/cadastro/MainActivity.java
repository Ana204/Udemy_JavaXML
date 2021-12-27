package app.layout.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNomeCompleto, edtEmail, edtInformeSuaCidade;
    Button buttonSalvar, buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();
        ButtonSalvar();
        ButtonCancelar();
    }

    private void initForm() {

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
    }

    private void ButtonSalvar() {

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void ButtonCancelar() {
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cancelado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}