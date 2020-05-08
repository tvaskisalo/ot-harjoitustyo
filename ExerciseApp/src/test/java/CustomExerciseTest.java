/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exerciseapp.dao.Database;
import exerciseapp.logic.CustomExercise;
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
public class CustomExerciseTest {
    private Database db;
    private CustomExercise custom1;
    private Database dbb;
    private CustomExercise custom2;
    
    
    @Before
    public void setUp() {
        db = new Database("test1");
        db.createNewCustomExercise("a", "1");
        db.createNewCustomExercise("b", "2");
        db.createNewCustomExercise("c", "3");
        custom1 = new CustomExercise(db);

    }
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void newQuestionSetsCorrectQuestion() {
        custom1.setTehtavaId(1);
        Boolean a = false;
        custom1.newQuestion();
        if(custom1.getQuestion().equals("a")) {
            a=true;
        }
        custom1.setTehtavaId(2);
        Boolean b = false;
        custom1.newQuestion();
        if(custom1.getQuestion().equals("b")) {
            b=true;
        }
        
        custom1.setTehtavaId(3);
        Boolean c = false;
        custom1.newQuestion();
        if(custom1.getQuestion().equals("c")) {
            c=true;
        }
        
        Boolean correct = false;
        if(a==true && b==true && c==true) {
            correct=true;
        }
        assertEquals(correct, true);
    }
    
    @Test
    public void newAnswerSetsCorrectAnswer() {
        custom1.setTehtavaId(1);
        Boolean a = false;
        custom1.newAnswer();
        if(custom1.getAnswer().equals("1")) {
            a=true;
        }
        custom1.setTehtavaId(2);
        custom1.newAnswer();
        Boolean b = false;
        if(custom1.getAnswer().equals("2")) {
            b=true;
        }
        
        custom1.setTehtavaId(3);
        custom1.newAnswer();
        Boolean c = false;
        if(custom1.getAnswer().equals("3")) {
            c=true;
        }
        
        Boolean correct = false;
        if(a==true && b==true && c==true) {
            correct=true;
        }
       
        assertEquals(a, true);
    }
    
    @Test
    public void generateNewExerciseNumberMakesADifferentNumber() {
        Boolean correct = true;
        for (int i=0; i<100; i++) {
            int id = custom1.getTehtavaId();
            custom1.generateNewExerciseNumber();
            if (id==custom1.getTehtavaId()) {
                correct = false;
            }
        }
        assertEquals(correct, true);
    }
    
    @Test
    public void checkAnswerReturnsTrueToCorrectAnswer() {
        custom1.setTehtavaId(1);
        custom1.newAnswer();
        Boolean correct = custom1.checkAnswer("1");
        
        assertEquals(correct, true);
    }
    
    @Test
    public void checkAnswerReturnsFalseToIncorrectAnswer() {
        custom1.setTehtavaId(1);
        custom1.newAnswer();
        Boolean correct = custom1.checkAnswer("hey");
        
        assertEquals(correct, false);
    }
    
    
    
}
