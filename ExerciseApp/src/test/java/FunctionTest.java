/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exerciseapp.logic.Function;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tapan
 */
public class FunctionTest {
    private Function function;
    
    @Before
    public void setUp() {
        function = new Function();
    }
    
    @Test
    public void functionQuestionsHaveCorrectAnswers() {
        boolean correct = true;
        for(int i=0; i<1000; i++) {
            function.generateQuestion();
            int a = function.getA();
            int b = function.getB();
            int c = function.getC();
            int x = function.getX();
            int answer = Integer.valueOf(function.getCorrectAnswer());
            if(a * x * x + b * x + c != answer) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }
    
    @Test
    public void functionCorrectAnswerReturnsTrue() {
        boolean correct = true; 
        for(int i=0; i<1000; i++) {
            function.generateQuestion();
            int a = function.getA();
            int b = function.getB();
            int c = function.getC();
            int x = function.getX();
            int answer = Integer.valueOf(function.getCorrectAnswer());
            if(!function.checkAnswer(String.valueOf(a * x * x + b * x + c))) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }
    
    @Test
    public void functionIncorrectAnswerReturnsFalse() {
        boolean correct = true; 
        for(int i=0; i<1000; i++) {
            function.generateQuestion();
            int a = function.getA();
            int b = function.getB();
            int c = function.getC();
            int x = function.getX();
            int answer = Integer.valueOf(function.getCorrectAnswer());
            if(function.checkAnswer(String.valueOf(a * x * x + b * x + c -1))) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }
}
