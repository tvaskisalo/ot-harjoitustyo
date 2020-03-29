/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.*;

/**
 *
 * @author Tapan
 */
public class Algebra implements Exercise {
    private int a;
    private int b;
    private int correctAnswer;

    public Algebra() {
        Random r = new Random();
        a=r.nextInt(101);
        b=r.nextInt(101);
        correctAnswer = a+b;
    }
    
    

    @Override
    public boolean checkAnswer(String answer){
        int ans=Integer.valueOf(answer);
        return ans==correctAnswer;
    }

    @Override
    public String generateQuestion() {
        Random r = new Random();
        a=r.nextInt(101);
        b=r.nextInt(101);
        correctAnswer = a+b;
        return "Calculate " + a + " + " +b;
        
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
    
    
}
