/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.logic;

import exerciseapp.dao.Database;
import java.util.Random;

/**
 *  Luokka tarjoaa tehtäviä, joissa lasketaan eri vektoreiden pistetuloja
 * 
 */
public class Vector implements Exercise {
    private int a;
    private int b;
    private int c;
    private int d;
    private int answer;
    
    /**
     * Metodi tarkistaa käyttäjän antaman vastauksen viimeksi generoituun kysymykseen.
     * 
     * @param answer Käyttäjän antama vastaus
     * @return Oliko vastaus oikein vaiko ei
     * @throws NumberFormatException Jos annettu vastaus ei ole numero
     */
    
    
    

    @Override
    public boolean checkAnswer(String answer) throws NumberFormatException {
        return Integer.parseInt(answer) == this.answer;
    }
    
    private void generateNewNumbers() {
        Random r = new Random();
        a = -5 + r.nextInt(11);
        b = -5 + r.nextInt(11);
        c = -5 + r.nextInt(11);
        d = -5 + r.nextInt(11);
        answer = a * c + b * d;
    }

    /**
     * Metodi Generoi uuden kysymyksen
     * @return Generoitu kysymys
     */
    @Override
    public String generateQuestion() {
        this.generateNewNumbers();
        return "Calculate the scalar product of (" + a + "," + b + ") and (" + c + "," + d + ").";
    }

    /**
     * Metodi palauttaa viimeksi generoidun kysymyksen vastauksen.
     * @return  Oikea vastaus
     */
    @Override
    public String getCorrectAnswer() {
        return String.valueOf(answer);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }
    
}
