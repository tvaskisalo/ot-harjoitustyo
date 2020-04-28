/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.logic;

/**
 * Rajapita määrittelee, mitä metodeja jokaisella eri tehtäväluokalla pitää olla
 * 
 */
public interface Exercise {
    
    /**
     * Vaatii, että jokainen tehtäväluokka tarkistaa vastauksia
     * @param answer Käyttäjän antama vastaus
     * @return Oliko vastaus oikea vaiko ei
     */
    public boolean checkAnswer(String answer);
    
    /**
     * Vaatii, että jokainen tehtäväluokka generoi kysymyksiä.
     * @return Generoitu kysymys
     */
    public String generateQuestion();
    
    /**
     * Vaatii, että jokainen tehtäväluokka palauttaa oikean vastauksen.
     * @return Oikea vastaus
     */
    public String getCorrectAnswer();
    
}
