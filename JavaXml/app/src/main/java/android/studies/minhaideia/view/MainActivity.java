package android.studies.minhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.studies.minhaideia.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //peguei os dados da activity Splash
        Bundle bundle = getIntent().getExtras();

        System.out.println("Nome: " + bundle.getString("nome"));
        System.out.println("Email: " + bundle.getString("email"));
    }
}