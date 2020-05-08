/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.ui;

import exerciseapp.dao.Database;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Tapan
 */
public class CustomExerciseUi {
    private final Database db;
    private final BorderPane background;

    public CustomExerciseUi(Database db) {
        this.db = db;
        background = new BorderPane();
        GridPane grid = new GridPane();
        
        Button addExercise = new Button("Add exercise");
        
        Label answerInstruction = new Label("Input the correct answer here \n Maximum character length is 35 characters");
        Label questionInstruction = new Label("Input your quesion here \n Maximum character length is 35 characters");
        Label output = new Label("");
        
        TextField answerField = new TextField();
        TextField questionField = new TextField();
        
        background.setTop(new Label("Create a new custom exercise"));
        background.setCenter(grid);
        
        grid.add(answerInstruction, 2, 1);
        grid.add(answerField, 2, 2);
        grid.add(questionInstruction, 1, 1);
        grid.add(questionField, 1, 2);
        grid.add(addExercise, 3, 2);
        grid.add(output, 1, 3);
        grid.setHgap(15);
        grid.setVgap(15);
        
        addExercise.setOnMouseClicked((event)-> {
            String answer = answerField.getText();
            answer = answer.toLowerCase().trim();
            String question = questionField.getText();
            question = question.toLowerCase().trim();
            
            if (answer.equals("") || question.equals("")) {
                output.setText("Incorrect input");
            } else if (answer.length() > 35 || question.length() > 35) {
                output.setText("The question or the answer is too long");
            } else {
                db.createNewCustomExercise(question, answer);
                questionField.clear();
                answerField.clear();
                output.setText("Exercise was added");
            }
        });
    }
    
    public BorderPane getScene() {
        return background;
    }
    
    
    
}
