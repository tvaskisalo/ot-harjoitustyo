/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exerciseapp.logic.Vector;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tapan
 */
public class VectorTest {
    private Vector vec;
    
    @Before
    public void setUp() {
        vec = new Vector();
    }
    
    @Test
    public void vectorQuestionsHaveCorrectAnswers() {
        boolean correct = true;
        for(int i=0; i<1000; i++) {
            vec.generateQuestion();
            int a = vec.getA();
            int b = vec.getB();
            int c = vec.getC();
            int d = vec.getD();
            int answer = Integer.parseInt(vec.getCorrectAnswer()); 
            if(answer != a * c + b * d) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }

    @Test
    public void vectorCorrectAnswerReturnsTrue() {
        boolean correct = true;
        for(int i=0; i<1000; i++) {
            vec.generateQuestion();
            int a = vec.getA();
            int b = vec.getB();
            int c = vec.getC();
            int d = vec.getD();
            int answer = Integer.parseInt(vec.getCorrectAnswer()); 
            if(!vec.checkAnswer(String.valueOf(a * c + b * d))) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }
    
    @Test
    public void vectorIncorrectAnswerReturnsTrue() {
        boolean correct = true;
        for(int i=0; i<1000; i++) {
            vec.generateQuestion();
            int a = vec.getA();
            int b = vec.getB();
            int c = vec.getC();
            int d = vec.getD();
            int answer = Integer.parseInt(vec.getCorrectAnswer()); 
            if(vec.checkAnswer(String.valueOf(a * c + b * d -1))) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }
}
