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
    private final Exercise exercise;
    private final BorderPane background;

    public ExerciseUi(Exercise exercise, DataBase db, Label points, Label percent) {
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
           answerSpace.setDisable(false);
        });
        
        showAnswer.setOnMouseClicked((event)-> {
            feedback.setText("Correct answer is: "+exercise.getCorrectAnswer());
            answerSpace.setDisable(true);
        });
        
        checkButton.setOnMouseClicked((event) -> {
            String answer = answerSpace.getText();
            answerSpace.clear();
            try {
                Boolean check=exercise.checkAnswer(answer);
                db.increaseExerciseCount();
                if(check) {
                feedback.setText("Correct!");
                db.addPoints();
                points.setText("Points: " + db.getPoints());
                } else {
                    feedback.setText("Wrong! ");
                }
                if(!grid.getChildren().contains(showAnswer)){
                    grid.add(showAnswer, 1, 3);
                }
                if(db.getExerciseCount()==0) {
                    percent.setText("Success rate: 0%"); 
                } else {
                    percent.setText("Success rate: "+db.getPercent()+ "%");
                }
            } catch(Exception e) {
                feedback.setText("Please input numbers only");
            } 
        });
    }
    public BorderPane getScene() {
        return background;
    }
    
}
