
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius Russo 
 * @date 1st April 2020
 * @name KeywordCountdownApp.java
 * 
 */
public class KeywordCountdownApp {
    public static void main (String arg[]){
         // Declare Variable
         int player1=0, player2=0, rounds;
         String answer;
         
         // Declaring and Creating Object
         KeywordCountdown myKeywordCountdown = new KeywordCountdown();
         
         
         
        /* Loop for number of rounds executed which contains methods from Instantiable Class. 
        *  This loop is inside another loop asks at the end if the user wants to execute game again. 
        */
         do {
            myKeywordCountdown.computeRounds();
            rounds = myKeywordCountdown.getRounds();
            for (int i=0; i<rounds; i++){
                myKeywordCountdown.computeLetters();
                myKeywordCountdown.random();    
                myKeywordCountdown.checkWords();
                myKeywordCountdown.checkKeyword();
                player1 = myKeywordCountdown.getPlayer1();
                player2 = myKeywordCountdown.getPlayer2();
            }
            JOptionPane.showMessageDialog(null, "The total points for all rounds \n Player 1: "+ player1 + "\n Player 2: "+ player2);
            answer = myKeywordCountdown.getAnswer();
         }
         while ("Yes".equalsIgnoreCase(answer) || ("Y".equalsIgnoreCase(answer)));
    }

      
}
