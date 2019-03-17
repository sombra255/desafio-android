package br.com.fabricio.desafioandroid.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.fabricio.desafioandroid.model.Inbound;
import br.com.fabricio.desafioandroid.model.Outbound;

import static br.com.fabricio.desafioandroid.utils.FormatarDataHora.*;

/**
 * Created by Fabricio on 16/03/2019.
 */

public class Filtrar {

    public static List<Inbound> filtrarVoosHorario(List<Inbound> inbounds, boolean manha, boolean tarde, boolean noite, boolean madrugada, boolean vooUmaParada, boolean vooDireto) {
        List<Inbound>lsInbounds = new ArrayList<>();
        if(manha || tarde || noite || madrugada) {
            for (Inbound in : inbounds) {
                if (manha && isManha(in.getDepartureDate())) {
                    lsInbounds.add(in);
                }
                if (tarde && isTarde(in.getDepartureDate())) {
                    lsInbounds.add(in);
                }
                if (noite && isNoite(in.getDepartureDate())) {
                    lsInbounds.add(in);
                }
                if (madrugada && isMadrugada(in.getDepartureDate())) {
                    lsInbounds.add(in);
                }
            }
            return filtrarVoosParadas(lsInbounds, vooUmaParada, vooDireto);
        }else {
            return filtrarVoosParadas(inbounds, vooUmaParada, vooDireto);
        }
    }

    private static boolean isVooDireto(Integer stops) {
        return stops == 0;
    }

    private static boolean isVooUmaParada(Integer stops) {
        return stops == 1;
    }

    public static List<Inbound> filtrarVoosParadas(List<Inbound> inbounds, boolean vooUmaParada, boolean vooDireto) {
        List<Inbound> lsInbounds = new ArrayList<>();
        if(vooUmaParada || vooDireto) {
            for (Inbound in : inbounds) {
                if (vooUmaParada && isVooUmaParada(in.getStops())) {
                    if (!lsInbounds.contains(in)) {
                        lsInbounds.add(in);
                    }
                }
                if (vooDireto && isVooDireto(in.getStops())) {
                    if (!lsInbounds.contains(in)) {
                        lsInbounds.add(in);
                    }
                }
            }
            return lsInbounds;
        }else {
            return inbounds;
        }

    }

    public static List<Outbound> filtrarVoosHorarioVolta(List<Outbound> outbounds, boolean manha, boolean tarde, boolean noite, boolean madrugada, boolean vooUmaParada, boolean vooDireto) {
        List<Outbound>lsOutbounds = new ArrayList<>();
        if(manha || tarde || noite || madrugada) {
            for (Outbound in : outbounds) {
                if (manha && isManha(in.getDepartureDate())) {
                    lsOutbounds.add(in);
                }
                if (tarde && isTarde(in.getDepartureDate())) {
                    lsOutbounds.add(in);
                }
                if (noite && isNoite(in.getDepartureDate())) {
                    lsOutbounds.add(in);
                }
                if (madrugada && isMadrugada(in.getDepartureDate())) {
                    lsOutbounds.add(in);
                }
            }
            return filtrarVoosParadasVolta(lsOutbounds, vooUmaParada, vooDireto);
        }else {
            return filtrarVoosParadasVolta(outbounds, vooUmaParada, vooDireto);
        }
    }

    public static List<Outbound> filtrarVoosParadasVolta(List<Outbound> outbounds, boolean vooUmaParada, boolean vooDireto) {
        List<Outbound> lsOutbounds = new ArrayList<>();
        if(vooUmaParada || vooDireto) {
            for (Outbound in : outbounds) {
                if (vooUmaParada && isVooUmaParada(in.getStops())) {
                    if (!lsOutbounds.contains(in)) {
                        lsOutbounds.add(in);
                    }
                }
                if (vooDireto && isVooDireto(in.getStops())) {
                    if (!lsOutbounds.contains(in)) {
                        lsOutbounds.add(in);
                    }
                }
            }
            return lsOutbounds;
        }else {
            return outbounds;
        }
    }

//    public static List<Inbound> filtrarVoosManha(List<Inbound> inbounds) {
//        List<Inbound>lsInbounds = new ArrayList<>();
//        for(Inbound in : inbounds){
//            if(isManha(in.getDepartureDate())){
//                lsInbounds.add(in);
//            }
//        }
//        return lsInbounds;
//    }
//
//    public static List<Inbound> filtrarVoosTarde(List<Inbound> inbounds) {
//        List<Inbound>lsInbounds = new ArrayList<>();
//        for(Inbound in : inbounds){
//            if(isTarde(in.getDepartureDate())){
//                lsInbounds.add(in);
//            }
//        }
//        return lsInbounds;
//    }
//
//    public static List<Inbound> filtrarVoosNoite(List<Inbound> inbounds) {
//        List<Inbound>lsInbounds = new ArrayList<>();
//        for(Inbound in : inbounds){
//            if(isNoite(in.getDepartureDate())){
//                lsInbounds.add(in);
//            }
//        }
//        return lsInbounds;
//    }
//
//    public static List<Inbound> filtrarVoosMadrugada(List<Inbound> inbounds) {
//        List<Inbound>lsInbounds = new ArrayList<>();
//        for(Inbound in : inbounds){
//            if(isMadrugada(in.getDepartureDate())){
//                lsInbounds.add(in);
//            }
//        }
//        return lsInbounds;
//    }
}
