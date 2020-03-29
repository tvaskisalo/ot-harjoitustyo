/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logic.Algebra;
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
public class AlgebraTest {
    private Algebra al;
    

    @Before
    public void setUp() {
        al = new Algebra();
    }
    
    @Test
    public void algebraQuestionsHaveCorrectAnswers() {
        int sumA =0;
        int sumB=0;
        int sumAnswer=0;
        for(int i= 0; i<100; i++) {
            String[] strings = al.generateQuestion().split(" ");
            sumA+=Integer.valueOf(strings[1]);
            sumB+=Integer.valueOf(strings[3]);
            sumAnswer+=Integer.valueOf(al.getCorrectAnswer());
        }
        assertEquals(sumA+sumB, sumAnswer);
    }
    
    @Test 
    public void incorrectAnswerReturnsFalse() {
        int sumA =0;
        int sumB=0;
        String[] strings = al.generateQuestion().split(" ");
        sumA+=Integer.valueOf(strings[1]);
        sumB+=Integer.valueOf(strings[3]);
        
        assertEquals(al.checkAnswer(String.valueOf(sumB+sumA+1)), false);
    }
    
    @Test
    public void correctAnswerReturnsTrue() {
        int sumA =0;
        int sumB=0;
        String[] strings = al.generateQuestion().split(" ");
        sumA+=Integer.valueOf(strings[1]);
        sumB+=Integer.valueOf(strings[3]);
        
        assertEquals(al.checkAnswer(String.valueOf(sumB+sumA)), true);
    }
    
}
