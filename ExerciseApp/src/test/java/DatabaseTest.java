/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exerciseapp.dao.Database;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Tapan
 */
public class DatabaseTest {
    private Database db;
    
   
    @Before
    public void setUp() {
        db = new Database("test2");
        db.setUsername("test");
        db.createUser();
    }
    
    @After
    public void tearDown() {
        db.dropTables();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test 
    public void newUserStartsWithNoExercisesDone() {
        int count = db.getExerciseCount();
        assertEquals(count, 0);
    }
    
    @Test
    public void newUserStartsWithNoPoints() {
        int count = db.getPoints();
        assertEquals(count, 0);
    }
    
    @Test
    public void increaseExerciseCountAddsCounterByOne() {
        int beginningCount = db.getExerciseCount();
        db.increaseExerciseCount();
        int increasedCount = db.getExerciseCount();
        assertEquals(beginningCount+1, increasedCount);
    }
    
    @Test
    public void addPointsAddsPointCounterByOne() {
        int beginningPoints = db.getPoints();
        db.addPoints();
        int increasedPoints = db.getPoints();
        assertEquals(beginningPoints+1, increasedPoints);
    }
    
    @Test
    public void creatingNewCustomExerciseIncreasesCountByOne() {
        int beginningCount = db.getAmountOfCustomExercises();
        db.createNewCustomExercise("a", "1");
        int increasedCount = db.getAmountOfCustomExercises();
        assertEquals(beginningCount + 1, increasedCount);
    }
    
    @Test
    public void getCustomExerciseQuestionReturnsCorrectQuestion() {
        db.createNewCustomExercise("b", "2");
        int id = db.getAmountOfCustomExercises();
        String question = db.getCustomExerciseQuestion(id);
        assertEquals(question, "b");
    }
    
    @Test
    public void getCustomExerciseAnswerReturnsCorrectAnswer() {
        db.createNewCustomExercise("c", "3");
        int id = db.getAmountOfCustomExercises();
        String answer = db.getCustomExerciseAnswer(id);
        assertEquals(answer, "3");
    }
}
