/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.logic;

import java.util.Random;

/**
 * Luokka tarjoaa tehtäviä, joissa lasketaan eri funktoiden arvoja eri kohdissa
 * 
 */
public class Function implements Exercise {
    private int a;
    private int b;
    private int c;
    private int x;
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
    
    /**
     * Metodi Generoi uuden kysymyksen
     * @return Generoitu kysymys
     */
    @Override
    public String generateQuestion() {
        StringBuilder function = new StringBuilder("f(x)=");
        Random r = new Random();
        a = 5 - r.nextInt(10);
        b = 5 - r.nextInt(10);
        c = 5 - r.nextInt(10);
        x = r.nextInt(4);
        answer = a * x * x + b * x + c;
        if (a != 0) {
            function.append(a + "x²");
        }
        if (b > 0) {
            function.append("+" + b + "x");
        }
        if (b < 0) {
            function.append(b + "x");
        }
        if (c > 0) {
            function.append("+" + c);
        }
        if (c < 0) {
            function.append(c);
        }
        function.append("\n");
        function.append("Find f(" + x + ")");
        return function.toString();
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

    public int getX() {
        return x;
    }
    
}
