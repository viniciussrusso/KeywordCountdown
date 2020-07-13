
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
 * @name KeywordCountdown.java
 * 
 */
public class KeywordCountdown {
    // Data members
    private int player1;  
    private int player2;
    private int rounds; 
    private int numVowels;
    private int numConsonants;
    private int vowelsInput;
    private final String allVowels;
    private final String allConsonants;
    private String vowels;
    private String consonants;
    private String answer;   
    private String[] keywords;
    private String word1;
    private String word2;
    private String letters;
    private boolean validation;
    
    // Constructors
    public KeywordCountdown(){
        player1 = 0;
        player2 = 0;
        rounds = 0;
        numVowels = 0;
        numConsonants = 0;
        vowelsInput = 0;
        allVowels = "AEIOU";
        allConsonants = "BCDFGHKLMNPRSTVXYWZ";
        vowels = "";
        consonants = "";
        answer = "";
        keywords = new String[] {"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONTINUE", "DEFAULT",
                   "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "IMPLEMENTS", "IMPORT",
                   "INTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC",
                   "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS",
                   "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE"};
        word1 = "";
        word2 = "";
        letters = "";
    }
    
    // Set Methods 
    public void setPlayer1(int player1){
        this.player1 = player1;
    }
    public void setPlayer2(int player2){
        this.player2 = player2;
    }
    public void setRounds(int rounds){
        this.rounds = rounds;
    }
    public void setNumVowels(int numVowels){
        this.numVowels = numVowels;
    }
    public void setNumConsonants(int numConsonants){
        this.numConsonants = numConsonants;
    }    
    public void setVowels(String vowels){
        this.vowels = vowels;
    }
    public void setConsonants(String consonants){
        this.consonants = consonants;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public void setKeywords(String[] keywords){
        this.keywords = keywords;
    }
    public void setWord1(String word1){
        this.word1 = word1;
    }
    public void setWord2(String word2){
        this.word2 = word2;
    }
    public void setLetters(String letters){
        this.letters = letters;
    }
    public void setValidation(boolean validation) {
        this.validation = validation;
    }
    
    // Random Method - Create String with random vowels and consonants
    public void random(){
        // Declaring and Initializing Random Class
        Random random = new Random();
        
        char[] randomVowels = new char [numVowels];
        for (int i=0; i<numVowels; i++){
            randomVowels[i] = allVowels.charAt(random.nextInt(allVowels.length()));
        }
        for (int i=0; i<randomVowels.length; i++){
            vowels += randomVowels[i];   
        }
        
        char[] randomConsonants = new char [numConsonants];
        for(int i=0; i<numConsonants; i++){
            randomConsonants[i] = allConsonants.charAt(random.nextInt(allConsonants.length()));
        }
        for (int i=0; i<randomConsonants.length; i++){
            consonants+= randomConsonants[i];
        }
        this.setLetters(vowels + consonants);
    }
    // Compute Letters Method - Validates and accepts number of vowels input and set number of  consonants
    public void computeLetters(){
        for (int i=0; i<1; i++){
            try{
                consonants = "";
                vowels = "";
                vowelsInput = Integer.parseInt(JOptionPane.showInputDialog(null, "How many vowels would like?"));              
                    if(vowelsInput<=9){
                        numConsonants = 9 - vowelsInput;
                        numVowels = 9 - numConsonants;
                    }
                    else if((vowelsInput != 0) || (vowelsInput != 1) || (vowelsInput != 2) || (vowelsInput != 3) || (vowelsInput != 4) || (vowelsInput != 5) || (vowelsInput != 6) || (vowelsInput != 7) || (vowelsInput != 8) || (vowelsInput != 9)){
                        i--;
                    }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "** Please enter a valid number **");
                       computeLetters();
            }
        }
    }
    // Compute Rounds Method - Validates and accepts number of rounds input 
    public void computeRounds(){
        for (int i = 0; i < 1; i++){
            try{
                rounds = Integer.parseInt(JOptionPane.showInputDialog(null,"How many rounds would like to play?" ));
                    if(rounds <= 99) {
                    }
                    else if((rounds != 0) || (rounds != 1) || (rounds != 2) || (rounds != 3) || (rounds != 4) || (rounds != 5) 
                        || (rounds != 6) || (rounds != 7) || (rounds != 8) || (rounds != 9)){
                        i--;
                    }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "** Please enter a valid number **");
                i--;
            }    
        }
    }
    // Check Words Method - Check if word typed by each player contains group of random letters
    public void checkWords(){ 
        word1 = JOptionPane.showInputDialog(null, "Player-1 \n  Using the 9 letters: "+ vowels + " "+ consonants+"\n Enter a word: ");
        word2 = JOptionPane.showInputDialog(null, "Player-2 \n  Using the 9 letters: "+ vowels + " "+ consonants+"\n Enter a word: ");
                
        char[] chLetters = letters.toCharArray();
        char[] chWordOne = word1.toUpperCase().toCharArray();
        char[] chWordTwo = word2.toUpperCase().toCharArray();
        
        Set<Character> setchLetters = new HashSet<>();
        Set<Character> setchWord = new HashSet<>();

        for (char x: chLetters){
            setchLetters.add(x);
        }
        for(char y:chWordOne){
            setchWord.add(y);
        }
        for(char z: chWordTwo){
            setchWord.add(z);
        }
     
        setchLetters.retainAll(setchWord);
        if(setchLetters.containsAll(setchWord)){
            validation = true;
        }
        else{
            validation = false;
        } 
    }
    // Check Keyword Method - Convert Keyword array into a list, check if input word is present in the list
    public void checkKeyword(){         
        List<String> list = Arrays.asList(keywords);

        for(int i=0; i<1; i++){
            if ((list.contains(word1)) || (list.contains(word2)) && validation == true) {
                JOptionPane.showMessageDialog(null, "Valid word");
                if(word1.length() > word2.length()){
                    player1++;
                }
                else{
                    player2++;
                }              
            }
            else{
                JOptionPane.showMessageDialog(null, "Word not valid");
            }
        }
    }  
    
    // Get Method  - Returns rounds
    public int getRounds(){
        return rounds;
    }
    // Get Method - Returns number of vowels
    public int getNumVowels(){
        return numVowels;
    }
    // Get Method - Returns number of consonants
    public int getNumConsonants(){
        return numConsonants;
    }
    // Get Method - Accepts final answer (which asks if player wants to repeat the game) and returns it
    public String getAnswer(){
        answer = JOptionPane.showInputDialog(null, "Would like to repeat the game? \n  If yes type: Yes \n If not type: N"); 
        return answer;
    }
    // Get Method - Returns vowels that will be used for each round
    public String getVowels(){
        return vowels;
    }
    // Get Method - Returns consonants that will be used for each round
    public String getConsonants(){
        return consonants;
    }
    // Get Method - Returns letters
    public String getLetters(){
        return letters;
    }
    // Get Method - Returns points for Player One
    public int getPlayer1(){
        return player1;
    }
    // Get Method - Returns points for Player Two
    public int getPlayer2(){
        return player2;
    }
    // Get Method - Returns validation
    public boolean isValidation(){
        return validation;
    }
    // Get Method - Returns keywords
    public String[] getKeywords(){
        return keywords;
    }
    // Get Method - Returns word input - player 1
    public String getWord1() {
        return word1;
    }
    // Get Method - Returns word input - player 2
    public String getWord2() {
        return word2;
    }
    
}

