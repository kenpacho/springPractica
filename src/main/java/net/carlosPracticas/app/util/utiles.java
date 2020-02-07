package net.carlosPracticas.app.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class utiles {
    //metodo que de devuelve una lista de Strrings con las fechas siguientes, segun el parametro count
    //@param count
    //@return

    public static List<String> getNextDays(int count){
        SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
        //fecha de hoy
        Date start = new Date();
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, count); //Siguientes N dias desde ahora.
        Date endDate = cal.getTime();

        GregorianCalendar gcal= new GregorianCalendar();
        gcal.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gcal.getTime().after(endDate)){
            Date d= gcal.getTime();
            gcal.add(Calendar.DATE, 1);
            nextDays.add(sdf.format(d));

        }

        return nextDays;

    }



}
