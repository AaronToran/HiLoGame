/*
HiLoGame Assignment 1
Aaron Toran
2015-01-16
cis 260
 Dave Klick
*/
import java.lang.Math;
import java.lang.System;

public class HiLoGame {
    public int numOfGuesses;
    public static int numOfGames;
    
    private int lowNum;
    private int highNum;
    private int answer;
    
    //Swaps the num if they are entered wrong and creates a random number
    public HiLoGame(int hN, int lN) {
        numOfGames++;
        if (hN< lN) {
           lowNum  = hN;
           highNum = lN;
        } else{
            highNum = hN;
           lowNum = lN;
        }
        answer = lowNum + (int)(Math.random() * ((highNum - lowNum) + 1));
    }

    public static final int LOW = 0;
    public static final int HIGH = 1;
    public static final int CORRECT = 2;
    //get methods
    public final int getLow(){
        return  lowNum;
    }
    public final int getHigh(){
        return highNum ;
    }
    public int getGuesses(){
        return numOfGuesses;
    }
    public static int getGames(){
        return numOfGames;
        
    }
    //checks guesses and gets number of guesses for getguesses
    public int checkGuess(int guess){
    numOfGuesses++;
        if(guess < answer){
            return LOW;
        }else if(guess > answer){
            return HIGH;
        }else if(guess == answer){
            return CORRECT;
        }else{return 0;}
    }

}