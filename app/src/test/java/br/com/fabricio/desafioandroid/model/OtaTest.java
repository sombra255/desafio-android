package br.com.fabricio.desafioandroid.model;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Fabricio on 16/03/2019.
 */
public class OtaTest {

    private final Ota OTA = new Ota(235d);

    @Test
    public void getSaleTotal() throws Exception {
        assertEquals(235, OTA.getSaleTotal(), 0);
    }

}