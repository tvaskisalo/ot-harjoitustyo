/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tapan
 */
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti tkortti;
    
    public KassapaateTest() {
    }
    
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(100000);
        tkortti = new Maksukortti(100);
    }
    
    @Test
    public void kassassaAluksiOikeaMaaraRahaa() {
        assertEquals(1000, kassa.kassassaRahaa()/100);
    }
    
    @Test
    public void kassassaEiOleMyytyjaLounaita() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty()+kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoEdullinenPalauttaaOikeanSumman() {
        int vaihto = kassa.syoEdullisesti(500);
        assertEquals(260, vaihto);
    }
    
    @Test
    public void kateisOstoEdullinenKasvattaaKassaa() {
        kassa.syoEdullisesti(500);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisOstoEdullinenKasvattaaLounaita() {
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(240);
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoMaukasPalauttaaOikeanSumman(){
        int vaihto = kassa.syoMaukkaasti(4000);
        assertEquals(3600, vaihto);
    }
    
    @Test
    public void kateisOstoMaukasKasvattaaLounaita() {
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(400);
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kateisOstoMaukasKasvattaaKassaa() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    @Test
    public void maukasPalauttaaRiittamattomanRahan() {
        int vaihto = kassa.syoMaukkaasti(100);
        assertEquals(100, vaihto);
    }
    @Test
    public void riittamatonRahaEiLisaaMaukkaitaLounaita() {
        kassa.syoMaukkaasti(10);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test 
    public void riittamatonRahaEiMuutaKassaa() {
        kassa.syoEdullisesti(10);
        kassa.syoMaukkaasti(10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void edullinenPalauttaaRiittamattomanRahan() {
        int vaihto = kassa.syoEdullisesti(100);
        assertEquals(100, vaihto);
    }
    @Test
    public void riittamatonRahaEiLisaaEdullisiaLounaita() {
        kassa.syoEdullisesti(10);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void onnistunutKorttiOstosMaukasPalauttaaTrue() {
        boolean bl = kassa.syoMaukkaasti(kortti);
        assertTrue(bl);
    }
    @Test
    public void onnistunutKorttiOstosEdullinenPalauttaaTrue() {
        boolean bl = kassa.syoEdullisesti(kortti);
        assertTrue(bl);
    }
    @Test
    public void maukasVeloittaaRahaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(99600, kortti.saldo());
    }
    @Test
    public void edullinenVeloittaaRahaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(99760, kortti.saldo());
    }
    @Test
    public void kortillaOstoKasvattaaLounaita() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(2, kassa.edullisiaLounaitaMyyty()+kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kortillaOstoEiKasvataKassaa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void epaonnistunutOstoEiMuutaSaldoa() {
        kassa.syoEdullisesti(tkortti);
        kassa.syoMaukkaasti(tkortti);
        assertEquals(100, tkortti.saldo());
    }
    @Test
    public void epaonnistunutOstoEiKasvataLounaita() {
        kassa.syoEdullisesti(tkortti);
        kassa.syoMaukkaasti(tkortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty()+kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void epaonnistunutMaukasOstoPalauttaaFalse() {
        boolean bl = kassa.syoMaukkaasti(tkortti);
        assertFalse(bl);
    }
    @Test
    public void epaonnistunutEdullinenOstoPalauttaaFalse() {
        boolean bl = kassa.syoMaukkaasti(tkortti);
        assertFalse(bl);
    }
    @Test
    public void kortinLatausMuuttaaSaldoa(){
        kassa.lataaRahaaKortille(kortti, 100000);
        assertEquals(200000, kortti.saldo());
    }
    @Test
    public void kortinLatausKasvattaaKassaa() {
        kassa.lataaRahaaKortille(kortti, 100000);
        assertEquals(200000, kassa.kassassaRahaa());
    }
    @Test
    public void negatiivinenKortinLatausEiTeeMitaan() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, kortti.saldo());
    }
    
    
    
    
}
