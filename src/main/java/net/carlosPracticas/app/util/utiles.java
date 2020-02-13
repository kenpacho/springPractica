package net.carlosPracticas.app.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request){
        //Obtenemos nommbre original del archivo.
        String nombreOriginal= multiPart.getOriginalFilename();
        nombreOriginal = nombreOriginal.replace(" ", "-");
        String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
        //Obtenemos la ruta ABSOLUTA de directorio imagenes.
        //Tomcat/webapps/cineapp/resources/images/
        String rutaFinal =request.getServletContext().getRealPath("/resources/images");
        try{
            //formamos el nombre del archivo para guardarlo en el disco duro.
            File imageFile = new File(rutaFinal + nombreFinal);
            //Aqui se guarda fisicamente e archivo en el SSD.
            multiPart.transferTo(imageFile);
            return nombreFinal;
        }catch (IOException e){
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    //Metodo para generar una cadena de longitud N de caracteres aleatorios.
    public static String randomAlphaNumeric(int count){
        String CARACTERES = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count -- !=0){
            int character =(int) (Math.random() * CARACTERES.length());
            builder.append(CARACTERES.charAt(character));

        }

        return builder.toString();
    }




}
