package app.modelo.appclientevip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText editEmailLogin, edtSenhaLogin;
    CheckBox checkLembrar;
    TextView recuperarSenha, politicaDePrivacidade;
    Button btnAcessar, btnSejaVip;

    boolean isFormularioLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initLogin();

        recuperarsenhaEvento();
    }


    private void initLogin() {

        editEmailLogin.findViewById(R.id.editEmailLogin);
        edtSenhaLogin.findViewById(R.id.edtSenhaLogin);
        checkLembrar.findViewById(R.id.checkLembrar);
        recuperarSenha.findViewById(R.id.recuperarSenha);
        politicaDePrivacidade.findViewById(R.id.recuperarSenha);
        btnAcessar.findViewById(R.id.btnAcessar);
        btnSejaVip.findViewById(R.id.btnSejaVip);

        isFormularioLogin = false;

    }

    private void recuperarsenhaEvento() {

        recuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}