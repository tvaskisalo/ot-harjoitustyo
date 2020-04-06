/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.ui;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import exerciseapp.logic.Algebra;
import exerciseapp.logic.Function;

/**
 *
 * @author Tapan
 */
public class Ui extends Application {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Ui ui = new Ui ();
        System.out.println("[0] Text UI ");
        System.out.println("[1] Graphical UI");
        int choice = Integer.valueOf(scan.nextLine());
        if(choice==1) {
            ui.graphicalUI();
        }
        if(choice ==0) {
            ui.textUI(scan);
        }
    }    
    
    @Override
    public void start(Stage primary) {
        BorderPane start = new BorderPane();
        
        Label header = new Label("Select an exercise:");
        GridPane menu = new GridPane();
        Button mainMenu = new Button("Main menu");
        Button algebra = new Button("Algebra");
        Button functions = new Button("Functions");
        Button vectors = new Button("Vectors");
        
        menu.add(header, 0, 0);
        menu.add(algebra, 0, 1);
        menu.add(functions, 1, 1);
        start.setTop(mainMenu);
        start.setCenter(menu);
        primary.setScene(new Scene(start));
        primary.setTitle("ExerciseApp");
        primary.setMinHeight(250);
        primary.setMinWidth(250);
        primary.show();
        
        algebra.setOnMouseClicked((event) -> {
            ExerciseUi algebraExercise = new ExerciseUi(new Algebra());
            start.setCenter(algebraExercise.getScene());
        });
        
        mainMenu.setOnMouseClicked((event) -> {
            start.setCenter(menu);
        });
        functions.setOnMouseClicked((event)->{
            ExerciseUi functionExercise = new ExerciseUi(new Function());
            start.setCenter(functionExercise.getScene());
        });
        
        
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
                System.out.println("[1] Algebra");
                System.out.println("[0] Functions");
                command = Integer.valueOf(scan.nextLine());
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
                if(command ==0) {
                Function fu = new Function();
                System.out.println(fu.generateQuestion());
                String answer = scan.nextLine();
                boolean correct =fu.checkAnswer(answer);
                if(correct) {
                System.out.println("Good work!");
                } else {
                System.out.println("Wrong! Correct answer is:" +fu.getCorrectAnswer());
                }
                }
                
                
            }
        }
        System.out.println("Goodbye!");
    }
    
    public void graphicalUI() {
        launch();
    }
    
}
