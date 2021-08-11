package app.modelo.dataehora.api;

import java.util.Calendar;

public class AppUtil {

    /**
     *
     * @return data atual
     */
    public static String getDataAtual(){

        String dataAtual = "dd/mm/aaaa";
        String dia, mes, ano;

        try {

            Calendar calendar = Calendar.getInstance();

            dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            mes = String.valueOf(calendar.get(Calendar.MONTH)+1);
            ano = String.valueOf(calendar.get(Calendar.YEAR));


//            dia = (Calendar.DAY_OF_MONTH < 10) ? "0"+dia : dia;

            int mesAtual = (Calendar.MONTH)+1;

            mes = (mesAtual < 10) ? "0"+mes : mes;

           dataAtual = dia+"/"+mes+"/"+ano;

            return dataAtual;

        }catch (Exception e){

        }

        return dataAtual;
    }


    /**
     *
     * @return hora atual
     */

    public static String getHoraAtual(){

        String horaAtual = "12:04";

        return horaAtual;
    }
}
