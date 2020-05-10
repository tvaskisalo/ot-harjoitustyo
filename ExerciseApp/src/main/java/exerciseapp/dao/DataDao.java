/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.dao;

/**
 *
 * @author Tapan
 */
public interface DataDao {
    
    public void setUsername(String username);
    public void createUser();
    public int getPoints();
    public void addPoints();
    public int getExerciseCount();
    public void increaseExerciseCount();
    public int getAmountOfCustomExercises();
    public String getCustomExerciseQuestion(int id);
    public String getCustomExerciseAnswer(int id);
    public void createNewCustomExercise(String question, String answer);
    public double getPercent();
    public void dropTables();
}
