package br.com.fabricio.desafioandroid.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fabricio on 16/03/2019.
 */
public class FormatarDataHoraTest {
    private final String DATA_STRING = "2019-01-22T12:15:00Z";
    private final String DATA_STRING_MANHA = "2019-01-22T09:15:00Z";
    private final String DATA_STRING_TARDE = "2019-01-22T12:15:00Z";
    private final String DATA_STRING_NOITE = "2019-01-22T19:15:00Z";
    private final String DATA_STRING_MADRUGADA = "2019-01-22T02:15:00Z";
    @Test
    public void formatarData() throws Exception {
        assertEquals(FormatarDataHora.formatarData(DATA_STRING),"12:15");
    }

    @Test
    public void formataHora() throws Exception {
        int hora = 2;
        int minutos = 20;
        String horaFormatada = String.format("%dh%d, ", hora, minutos);
        assertEquals(FormatarDataHora.formataHora(140),horaFormatada);
    }

    @Test
    public void isManha() throws Exception {
        assertEquals(FormatarDataHora.isManha(DATA_STRING_MANHA),true);
        assertEquals(FormatarDataHora.isManha(DATA_STRING_TARDE),false);
        assertEquals(FormatarDataHora.isManha(DATA_STRING_NOITE),false);
        assertEquals(FormatarDataHora.isManha(DATA_STRING_MADRUGADA),false);
    }

    @Test
    public void isTarde() throws Exception {
        assertEquals(FormatarDataHora.isTarde(DATA_STRING_MANHA),false);
        assertEquals(FormatarDataHora.isTarde(DATA_STRING_TARDE),true);
        assertEquals(FormatarDataHora.isTarde(DATA_STRING_NOITE),false);
        assertEquals(FormatarDataHora.isTarde(DATA_STRING_MADRUGADA),false);
    }

    @Test
    public void isNoite() throws Exception {
        assertEquals(FormatarDataHora.isNoite(DATA_STRING_MANHA),false);
        assertEquals(FormatarDataHora.isNoite(DATA_STRING_TARDE),false);
        assertEquals(FormatarDataHora.isNoite(DATA_STRING_NOITE),true);
        assertEquals(FormatarDataHora.isNoite(DATA_STRING_MADRUGADA),false);
    }

    @Test
    public void isMadrugada() throws Exception {
        assertEquals(FormatarDataHora.isMadrugada(DATA_STRING_MANHA),false);
        assertEquals(FormatarDataHora.isMadrugada(DATA_STRING_TARDE),false);
        assertEquals(FormatarDataHora.isMadrugada(DATA_STRING_NOITE),false);
        assertEquals(FormatarDataHora.isMadrugada(DATA_STRING_MADRUGADA),true);
    }

}