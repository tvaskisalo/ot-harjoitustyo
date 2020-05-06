/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.ui;

import exerciseapp.dao.DataBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import exerciseapp.logic.Algebra;
import exerciseapp.logic.CustomExercise;
import exerciseapp.logic.Function;
import exerciseapp.logic.Vector;

/**
 *
 * @author Tapan
 */
public class Ui extends Application {
    
    public static void main(String[] args) {
        launch();
        
    }    
    
    @Override
    public void start(Stage primary) {
        BorderPane start = new BorderPane();
        DataBase db = new DataBase();
        
        GridPane user = new GridPane();
        Label instruction = new Label("Give a username: ");
        TextField name = new TextField();
        Button confirm = new Button("Confirm username");
        
        user.add(instruction, 0, 0);
        user.add(name, 0, 1);
        user.add(confirm, 0, 2);
        
        GridPane userInfo = new GridPane();
        Label username = new Label();
        Label points = new Label();
        Label percent = new Label();
        
        userInfo.add(username, 0, 0);
        userInfo.add(points, 1, 0);
        userInfo.add(percent, 2, 0);
        userInfo.setHgap(15);
        
        Label header = new Label("Select an exercise:");
        GridPane menu = new GridPane();
        Button mainMenu = new Button("Main menu");
        Button algebra = new Button("Algebra");
        Button functions = new Button("Functions");
        Button vectors = new Button("Vectors");
        Button createCustom = new Button("Create custom exercise");
        Button custom = new Button("Custom exercise");
        
        menu.add(header, 0, 0);
        menu.add(algebra, 1, 1);
        menu.add(functions, 2, 1);
        menu.add(vectors, 3, 1);
        menu.add(custom, 4, 1);
        menu.add(createCustom, 1, 2);
        
        
        start.setCenter(user);
        primary.setScene(new Scene(start));
        primary.setTitle("ExerciseApp");
        primary.setMinHeight(450);
        primary.setMinWidth(650);
        primary.show();
        
        confirm.setOnMouseClicked((event) -> {
            String alias = name.getText();
            if(alias.trim().equals("")) {
                user.add(new Label("Username is invalid"), 3, 0);
            } else {
                db.setUsername(alias);
                db.createUser();
                username.setText(alias);
                points.setText("Points: " + db.getPoints());
                if(db.getExerciseCount()==0) {
                    percent.setText("Success rate: 0"); 
                } else {
                    percent.setText("Success rate: "+((db.getPoints()*100)/db.getExerciseCount())+ "%");
                }
                start.setTop(mainMenu);
                start.setCenter(menu);
                start.setBottom(userInfo);
            }
        });
        
        algebra.setOnMouseClicked((event) -> {
            ExerciseUi algebraExercise = new ExerciseUi(new Algebra(), db, points, percent);
            start.setCenter(algebraExercise.getScene());
        });
        vectors.setOnMouseClicked((event)-> {
            ExerciseUi vectorExercise = new ExerciseUi(new Vector(), db, points, percent);
            start.setCenter(vectorExercise.getScene());
        });
        
        functions.setOnMouseClicked((event)->{
            ExerciseUi functionExercise = new ExerciseUi(new Function(), db, points, percent);
            start.setCenter(functionExercise.getScene());
        });
        
        custom.setOnMouseClicked((event) -> {
            ExerciseUi customExercise = new ExerciseUi(new CustomExercise(db), db, points, percent);
            start.setCenter(customExercise.getScene());
        });
        
        createCustom.setOnMouseClicked((event)-> {
            CustomExerciseUi customUi = new CustomExerciseUi(db);
            start.setCenter(customUi.getScene());
        });
        
        mainMenu.setOnMouseClicked((event) -> {
            start.setCenter(menu);
        });
        
        
    }

}
