/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import logic.Algebra;

/**
 *
 * @author Tapan
 */
public class ExcerciseUi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("[0] Begin excercise");
        System.out.println("[1] Quit excercise");
        Algebra al = new Algebra();
        while(true) {
            int command = Integer.valueOf(scan.nextLine());
            if(command==0) {
                break;
            }
            if(command==1) {
                al.generateQuestion();
                String answer = scan.nextLine();
                boolean correct =al.checkAnswer(answer);
            }
        }
    }
}
