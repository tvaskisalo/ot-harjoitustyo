/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import logic.Algebra;

/**
 *
 * @author Tapan
 */
public class ExerciseUi extends Application {
    static String[] args;
    
    @Override
    public void start(Stage primary) {
        Algebra al = new Algebra();
        Button checkButton = new Button("Check:");
        Button generate = new Button("Generate a new question");
        Button showAnswer = new Button("Show answer");
        TextField answerSpace = new TextField();
        Label feedback = new Label();
        Label question = new Label(al.generateQuestion());
        
        BorderPane background = new BorderPane();
        background.setTop(new Label("Excercise app"));
        GridPane grid = new GridPane();
        
        grid.add(generate, 0,0);
        grid.add(question, 0, 1);
        grid.add(answerSpace, 0, 2);
        grid.add(checkButton,0, 3);
        grid.add(feedback, 0, 4);
        background.setCenter(grid);
        
        generate.setOnMouseClicked((event)-> {
           question.setText(al.generateQuestion());
           feedback.setText(" ");
           grid.getChildren().remove(showAnswer);
        });
        
        showAnswer.setOnMouseClicked((event)-> {
            feedback.setText("Correct answer is: "+al.getCorrectAnswer());
        });
        
        checkButton.setOnMouseClicked((event) -> {
            String answer = answerSpace.getText();
            answerSpace.clear();
            if(al.checkAnswer(answer)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Wrong! ");
            }
            if(!grid.getChildren().contains(showAnswer)){
                grid.add(showAnswer, 1, 3);
            }
            
        });
        
        
        primary.setScene(new Scene(background));
        primary.show();
    }

    
    public void textUI(Scanner scan) {
        while(true){
            System.out.println("[1] Begin excercise");
            System.out.println("[0] Quit");
            int command = Integer.valueOf(scan.nextLine());
            if(command==0) {
                break;
            }
            if(command==1) {
                Algebra al = new Algebra();
                System.out.println(al.generateQuestion());
                String answer = scan.nextLine();
                boolean correct =al.checkAnswer(answer);
                if(correct) {
                System.out.println("Good work!");
                } else {
                System.out.println("Wrong! Correct answer is:" +al.getCorrectAnswer());
                }
            }
        }
        System.out.println("Goodbye!");
    }
    
    public void graphicalUI() {
        launch();
    }
}
