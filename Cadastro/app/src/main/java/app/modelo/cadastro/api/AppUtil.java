package app.modelo.cadastro.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtil {

    /**
     *
     * @return data atual
     */
    public static String getDataAtual(){

        String dataAtual = "dd/mm/aaaa";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyy");
        Date data = new Date();

        dataAtual = dateFormat.format(data);

        return dataAtual;

    }

    /**
     *
     * @return hora atual
     */

    public static String getHoraAtual(){



        String horaAtual = "00:00:00";


        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date data = new Date();

        horaAtual = dateFormat.format(data);

        return horaAtual;
    }
}
