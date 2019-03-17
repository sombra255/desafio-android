package br.com.fabricio.desafioandroid.utils;

/**
 * Created by Fabricio on 16/03/2019.
 */

public class FormatarDataHora {

    public static String formatarData(String data){
        int indice = data.indexOf("T");
        return data.substring(indice+1,indice+6);
    }

    public static String formataHora(Integer horaMinutos){
        int hora = horaMinutos/60;
        int minutos = horaMinutos%60;
        String horaFormatada = String.format("%dh%d, ", hora, minutos);
        return horaFormatada;
    }

    public static boolean isManha(String data){
        int indice = data.indexOf("T");
        String hora = data.substring(indice+1,indice+6).replace(":","");
        if(Integer.parseInt(hora) >= 600 && Integer.parseInt(hora) <= 1159){
            return true;
        }
        return false;
    }

    public static boolean isTarde(String data){
        int indice = data.indexOf("T");
        String hora = data.substring(indice+1,indice+6).replace(":","");
        if(Integer.parseInt(hora) >= 1200 && Integer.parseInt(hora) <= 1759){
            return true;
        }
        return false;
    }

    public static boolean isNoite(String data){
        int indice = data.indexOf("T");
        String hora = data.substring(indice+1,indice+6).replace(":","");
        if(Integer.parseInt(hora) >= 1800 && Integer.parseInt(hora) <= 2359){
            return true;
        }
        return false;
    }

    public static boolean isMadrugada(String data){
        int indice = data.indexOf("T");
        String hora = data.substring(indice+1,indice+6).replace(":","");
        if(Integer.parseInt(hora) >= 0 && Integer.parseInt(hora) <= 559){
            return true;
        }
        return false;
    }
}
