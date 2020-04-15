/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.ui;

import exerciseapp.dao.DataBase;
import exerciseapp.logic.Exercise;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Tapan
 */
public class ExerciseUi {
    private Exercise exercise;
    private BorderPane background;

    public ExerciseUi(Exercise exercise, DataBase db) {
        this.exercise =exercise;
        Button checkButton = new Button("Check:");
        Button generate = new Button("Generate a new question");
        Button showAnswer = new Button("Show answer");
        TextField answerSpace = new TextField();
        Label feedback = new Label();
        Label question = new Label(exercise.generateQuestion());
        
        background = new BorderPane();
        background.setTop(new Label("Exercise"));
        GridPane grid = new GridPane();
        
        grid.add(generate, 0,0);
        grid.add(question, 0, 1);
        grid.add(answerSpace, 0, 2);
        grid.add(checkButton,0, 3);
        grid.add(feedback, 0, 4);
        background.setCenter(grid);
        
        generate.setOnMouseClicked((event)-> {
           question.setText(exercise.generateQuestion());
           feedback.setText(" ");
           grid.getChildren().remove(showAnswer);
        });
        
        showAnswer.setOnMouseClicked((event)-> {
            feedback.setText("Correct answer is: "+exercise.getCorrectAnswer());
        });
        
        checkButton.setOnMouseClicked((event) -> {
            String answer = answerSpace.getText();
            answerSpace.clear();
            if(exercise.checkAnswer(answer)) {
                feedback.setText("Correct!");
                db.addPoints();
            } else {
                feedback.setText("Wrong! ");
            }
            if(!grid.getChildren().contains(showAnswer)){
                grid.add(showAnswer, 1, 3);
            }
            
        });
    }
    public BorderPane getScene() {
        return background;
    }
    
}
