package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;
import app.modelo.appclientevip.model.Cliente;


public class ClienteVipActivity extends AppCompatActivity {

    Cliente novoVip;
    private SharedPreferences preferences;

    EditText edtPrimeiroNome, edtSobrenome;
    CheckBox ckPessoaFisica;
    Button btnSalvarEContinuar, btnCancelar;

    boolean isFormularioNovoVip, isPessoaFisica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_vip);

        initNovoVip();
        btnSalvarEContinuarEvento();
        btnCancelarEvento();

    }

    private void initNovoVip() {

        edtPrimeiroNome = findViewById(R.id.edtPrimeiroNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        ckPessoaFisica = findViewById(R.id.ckPessoaFisica);
        btnSalvarEContinuar = findViewById(R.id.btnSalvarEContinuar);
        btnCancelar = findViewById(R.id.btnCancelar);

        isFormularioNovoVip = false;
        novoVip = new Cliente();
        restaurarSharedPreferences();
    }

    private void btnSalvarEContinuarEvento() {

        btnSalvarEContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioNovoVip = validarFormulario()) {

                    novoVip.setPrimeiroNome(edtPrimeiroNome.getText().toString());
                    novoVip.setSobrenome(edtSobrenome.getText().toString());
                    novoVip.setPessoaFisica(isPessoaFisica);

                    salvarSharedPreferences();

                    if (isPessoaFisica){

                        Intent intent = new Intent(ClienteVipActivity.this, PessoaFisicaActivity.class);
                        startActivity(intent);
                    }
                    else {

                        Intent intent = new Intent(ClienteVipActivity.this, PessoaJuridicaActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }

  private void btnCancelarEvento() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FancyAlertDialog.Builder
                        .with(ClienteVipActivity.this)
                        .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("Deseja realmente cancelar ?")
                        .setNegativeBtnText("NÃO")
                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Toast.makeText(ClienteVipActivity.this, "Cancelado com sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .onNegativeClicked(dialog ->Toast.makeText(ClienteVipActivity.this, "Continue com seu cadastro", Toast.LENGTH_SHORT).show())
                        .build()
                        .show();

            }
        });

    }

    private boolean validarFormulario() {

        //considerar que o usuario  preencheu o formulario
        boolean retorno = true;

        if (TextUtils.isEmpty(edtPrimeiroNome.getText().toString())) {
            edtPrimeiroNome.setError("Preencha o campo com seu primeiro nome");
            retorno = false;
        }
        if (TextUtils.isEmpty(edtSobrenome.getText().toString())) {
            edtSobrenome.setError("Preencha o campo com seu sobrenome");
            retorno = false;
        }

        return retorno;
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        //isPessoaFisica = preferences.getBoolean("pessoaFisica", false);
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("pessoaFisica", novoVip.isPessoaFisica());
        dados.putString("primeiroNome", novoVip.getPrimeiroNome());
        dados.putString("sobrenome", novoVip.getSobrenome());
        dados.apply();
    }

    public void pessoaFisica(View view) {

        isPessoaFisica = ckPessoaFisica.isChecked();
    }
}