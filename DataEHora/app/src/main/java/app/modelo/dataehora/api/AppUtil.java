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


//           dia = (Calendar.DAY_OF_MONTH < 10) ? "0"+dia : dia;

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

        String horas, minutos, segundos;

        String horaAtual = "00:00:00";


        try{

            Calendar calendar = Calendar.getInstance();

            horas = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            minutos = String.valueOf(calendar.get(Calendar.MINUTE));
            segundos = String.valueOf(calendar.get(Calendar.SECOND));

            horas = (Calendar.HOUR_OF_DAY <= 9) ? "0"+horas : horas;
            minutos = (Calendar.MINUTE <= 9) ? "0"+minutos : minutos;
            segundos = (Calendar.MILLISECOND <= 9) ? "0"+segundos : segundos;

            horaAtual = horas+":"+minutos+":"+segundos;


            return horaAtual;



        }catch (Exception e){

        }

        return horaAtual;
    }
}
