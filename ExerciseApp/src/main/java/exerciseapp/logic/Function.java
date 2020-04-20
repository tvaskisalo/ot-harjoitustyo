/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.logic;

import java.util.Random;

/**
 *
 * @author Tapan
 */
public class Function implements Exercise {
    private int a;
    private int b;
    private int c;
    private int x;
    private int answer;

    public Function() {
        a = 0;
        b = 0;
        c = 0;
        answer = 0;
    }

    
    @Override
    public boolean checkAnswer(String answer) {
        return Integer.valueOf(answer) == this.answer;
    }
    
    
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
