package br.com.fabricio.desafioandroid.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.fabricio.desafioandroid.model.Inbound;
import br.com.fabricio.desafioandroid.model.Outbound;

/**
 * Created by Fabricio on 16/03/2019.
 */

public class Ordenar {


    public static List<Inbound> ordenarMenor(List<Inbound> inbounds) {
        Collections.sort(inbounds, new Comparator<Inbound>() {
            public int compare(Inbound obj1, Inbound obj2) {
                // ## Ascending ordenarMenorPrecoMenorTempo
                return obj1.getPricing().getOta().getSaleTotal().compareTo(obj2.getPricing().getOta().getSaleTotal()); // To compare string values
                // return Integer.valueOf(obj1.empId).compareTo(Integer.valueOf(obj2.empId)); // To compare integer values

                // ## Descending ordenarMenorPrecoMenorTempo
                // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
                // return Integer.valueOf(obj2.empId).compareTo(Integer.valueOf(obj1.empId)); // To compare integer values
            }
        });
        return inbounds;
    }

    public static List<Inbound> ordenarMaior(List<Inbound> inbounds) {
        Collections.sort(inbounds, new Comparator<Inbound>() {
            public int compare(Inbound obj1, Inbound obj2) {
                // ## Ascending ordenarMenorPrecoMenorTempo
                return obj2.getPricing().getOta().getSaleTotal().compareTo(obj1.getPricing().getOta().getSaleTotal()); // To compare string values
                // return Integer.valueOf(obj1.empId).compareTo(Integer.valueOf(obj2.empId)); // To compare integer values

                // ## Descending ordenarMenorPrecoMenorTempo
                // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
                // return Integer.valueOf(obj2.empId).compareTo(Integer.valueOf(obj1.empId)); // To compare integer values
            }
        });
        return inbounds;
    }

    public static List<Inbound> ordenarMenorPrecoMenorTempo(List<Inbound> inbounds) {

        Collections.sort(inbounds, new Comparator() {

            public int compare(Object o1, Object o2) {

                Double x1 = ((Inbound) o1).getPricing().getOta().getSaleTotal();
                Double x2 = ((Inbound) o2).getPricing().getOta().getSaleTotal();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer y1 = ((Inbound) o1).getDuration();
                Integer y2 = ((Inbound) o2).getDuration();
                return y1.compareTo(y2);
            }
        });
        return inbounds;
    }

    public static List<Outbound> ordenarMenorVolta(List<Outbound> outbounds) {
        Collections.sort(outbounds, new Comparator<Outbound>() {
            public int compare(Outbound obj1, Outbound obj2) {
                return obj1.getPricing().getOta().getSaleTotal().compareTo(obj2.getPricing().getOta().getSaleTotal()); // To compare string values
            }
        });
        return outbounds;
    }

    public static List<Outbound> ordenarMaiorVolta(List<Outbound> outbounds) {
        Collections.sort(outbounds, new Comparator<Outbound>() {
            public int compare(Outbound obj1, Outbound obj2) {
                return obj2.getPricing().getOta().getSaleTotal().compareTo(obj1.getPricing().getOta().getSaleTotal()); // To compare string values
            }
        });
        return outbounds;
    }

    public static List<Outbound> ordenarMenorPrecoMenorTempoVolta(List<Outbound> outbounds) {

        Collections.sort(outbounds, new Comparator<Outbound>() {

            public int compare(Outbound o1, Outbound o2) {

                Double x1 = ((Outbound) o1).getPricing().getOta().getSaleTotal();
                Double x2 = ((Outbound) o2).getPricing().getOta().getSaleTotal();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer y1 = ((Outbound) o1).getDuration();
                Integer y2 = ((Outbound) o2).getDuration();
                return y1.compareTo(y2);
            }
        });

        return outbounds;
    }
}
