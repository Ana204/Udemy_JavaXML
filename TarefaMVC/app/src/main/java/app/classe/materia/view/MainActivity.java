package app.classe.materia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import app.classe.materia.R;
import app.classe.materia.controller.MateriaController;
import app.classe.materia.model.Materia;

public class MainActivity extends AppCompatActivity {

    Materia materia;
    MateriaController materiaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for (int i = 0; i < 5; i++){
            materiaController = new MateriaController(getApplicationContext());
            materia = new Materia();

            materia.setCodigoDaMateria(i);
            materia.setNomeDaMateria("PORT" + i);

            materiaController.incluir(materia);
        }
    }
}