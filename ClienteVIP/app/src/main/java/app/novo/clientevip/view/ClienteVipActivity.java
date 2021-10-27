package app.novo.clientevip.view;

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

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import app.novo.clientevip.Controller.ClienteController;
import app.novo.clientevip.R;
import app.novo.clientevip.api.AppUtil;
import app.novo.clientevip.model.Cliente;

public class ClienteVipActivity extends AppCompatActivity {

    Cliente novoVip;
    ClienteController controller;

    private SharedPreferences preferences;

    EditText edtPrimeiroNome, edtSobrenome;
    CheckBox ckPessoaFisica;
    Button btnSalvarEContinuar, btnCancelar;

    boolean isFormularioNovoVip, isPessoaFisica;
    int ultimoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_vip);

        initNovoVip();
        btnSalvarEContinuarEvento();
        btnCancelarEvento();
        pessoaFisica();


    }

    private void initNovoVip() {

        edtPrimeiroNome = findViewById(R.id.edtPrimeiroNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        ckPessoaFisica = findViewById(R.id.ckPessoaFisica);
        btnSalvarEContinuar = findViewById(R.id.btnSalvarEContinuar);
        btnCancelar = findViewById(R.id.btnCancelar);

        isFormularioNovoVip = false;
        novoVip = new Cliente();
        controller = new ClienteController(this);

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

                    controller.incluir(novoVip);
                    ultimoId = controller.getUltimo();

                    salvarSharedPreferences();

                    Intent intent = new Intent(ClienteVipActivity.this, PessoaFisicaActivity.class);
                    startActivity(intent);
                    finish();

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
                        .setBackgroundColor(Color.parseColor("#FFFFFFFF"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("Deseja realmente cancelar ?")
                        .setNegativeBtnText("NÃO")
                        .setNegativeBtnBackground(getResources().getColor(R.color.red))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnBackground(getResources().getColor(R.color.green))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.mipmap.logo, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Toast.makeText(ClienteVipActivity.this, "Cancelado com sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .onNegativeClicked(dialog -> Toast.makeText(ClienteVipActivity.this, "Continue com seu cadastro", Toast.LENGTH_SHORT).show())
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

    public void pessoaFisica() {

        ckPessoaFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPessoaFisica = ckPessoaFisica.isChecked();
            }
        });
    }

/*    public void pessoaFisica(View view) {
        isPessoaFisica = ckPessoaFisica.isChecked();
    }*/

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("pessoaFisica", novoVip.isPessoaFisica());
        dados.putString("primeiroNome", novoVip.getPrimeiroNome());
        dados.putString("sobrenome", novoVip.getSobrenome());
        dados.putInt("ultimoId", ultimoId);
        dados.apply();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        //isPessoaFisica = preferences.getBoolean("pessoaFisica", false);
    }


}