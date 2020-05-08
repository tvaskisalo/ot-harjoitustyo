/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.logic;

import exerciseapp.dao.Database;
import java.util.Random;

/**
 *
 * @author Tapan
 */
public class CustomExercise implements Exercise {
    private String question;
    private String answer;
    private int tehtavaId;
    private int tehtavienMaara;
    private Database db;

    public CustomExercise(Database db) {
        tehtavaId = 1;
        this.db = db;
        tehtavienMaara = db.getAmountOfCustomExercises();
    }
    
    @Override
    public boolean checkAnswer(String answer) {
        return answer.toLowerCase().trim().equals(this.answer);
    }

    @Override
    public String generateQuestion() {
        if (tehtavienMaara == 0) {
            return "There are no custom exercises";
        }
        this.generateNewExerciseNumber();
        this.newQuestion();
        this.newAnswer();
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return answer;
    }

    public void newQuestion() {
        question = db.getCustomExerciseQuestion(tehtavaId);
    }

    public void newAnswer() {
        answer = db.getCustomExerciseAnswer(tehtavaId);
    }
    
    public void generateNewExerciseNumber() {
        Random r = new Random();
        int index = r.nextInt(tehtavienMaara) + 1;
        while (index == tehtavaId && tehtavienMaara != 1) {
            index = r.nextInt(tehtavienMaara) + 1;
        }
        tehtavaId = index;
    }

    public int getTehtavienMaara() {
        return tehtavienMaara;
    }

    public void setTehtavaId(int tehtavaId) {
        this.tehtavaId = tehtavaId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getTehtavaId() {
        return tehtavaId;
    }
    
}
