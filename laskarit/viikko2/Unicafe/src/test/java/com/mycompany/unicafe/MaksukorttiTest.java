package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void luodunKortinSaldoOnOikein() {
        assertEquals(10,kortti.saldo());
    }
    
    @Test
    public void saldonKavattaminenLisaaSaldoa1() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 10.10", kortti.toString());
    }
    
    @Test
    public void saldonKavattaminenLisaaSaldoa2() {
        kortti.lataaRahaa(1111);
        assertEquals("saldo: 11.21", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeKunRahaaOnTarpeaksi() {
        kortti.otaRahaa(9);
        assertEquals(1, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosRahaEiRiita() {
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10",kortti.toString());
    }
    
    @Test
    public void palauttaaFalseKunRahaEiRiita() {
        assertFalse(kortti.otaRahaa(11));
    }
    @Test
    public void palauttaaTrueKunRahaRiitaa() {
        assertTrue(kortti.otaRahaa(10));
    }
}
