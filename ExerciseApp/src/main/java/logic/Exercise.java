/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Tapan
 */
public interface Exercise {
    
    public boolean checkAnswer(String answer);
    public String generateQuestion();
    public String getCorrectAnswer();
    
}
