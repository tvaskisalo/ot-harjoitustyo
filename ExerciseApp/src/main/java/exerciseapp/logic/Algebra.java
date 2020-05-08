/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.logic;
import exerciseapp.dao.Database;
import java.util.*;

/**
 * 
 * Luokka tarjoaa tehtäviä, joissa lasketaan eri yhteenlaskuja
 */
public class Algebra implements Exercise {
    private int a;
    private int b;
    private int correctAnswer;

    
    public Algebra() {
        Random r = new Random();
        a = r.nextInt(101);
        b = r.nextInt(101);
        correctAnswer = a + b;
    }
    
    /**
     * Metodi tarkistaa käyttäjän antaman vastauksen viimeksi generoituun kysymykseen.
     * 
     * @param answer Käyttäjän antama vastaus
     * @return Oliko vastaus oikein vaiko ei
     * @throws NumberFormatException Jos annettu vastaus ei ole numero
     */

    @Override
    public boolean checkAnswer(String answer) throws NumberFormatException {
        return Integer.parseInt(answer) == this.correctAnswer;
    }
    

    /**
     * Metodi Generoi uuden kysymyksen
     * @return Generoitu kysymys
     */
    
    private void generateNewNumbers() {
        Random r = new Random();
        a = r.nextInt(101);
        b = r.nextInt(101);
        correctAnswer = a + b;
    }
    @Override
    public String generateQuestion() {
        this.generateNewNumbers();
        return "Calculate " + a + " + " + b;
        
    }
    
    /**
     * Metodi palauttaa viimeksi generoidun kysymyksen vastauksen.
     * @return  Oikea vastaus
     */
    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
    
    
}
