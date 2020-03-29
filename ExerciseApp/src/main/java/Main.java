
import java.util.Scanner;
import logic.Algebra;
import ui.ExerciseUi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tapan
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ExerciseUi ui = new ExerciseUi ();
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
}
