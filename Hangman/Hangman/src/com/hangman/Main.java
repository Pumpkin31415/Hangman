package com.hangman;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Let's make a hangman game
    // we need a guesses list, a word to guess, and chances before being hung
    // chances will be set to 6 for a head, 2 legs, 2 arms, and a torso
    // lets make a word to guess owl for now. Later this will be pulled from a word list.
    static List<Character> guesses = new ArrayList<Character>();
    static int chances = 6;
    static String word = "owl";
    //we need a scanner for character input.
    static Scanner sc = new Scanner(System.in);
    //cast the word to a char array
    static char[] wordArray = word.toCharArray();
    //create a word length to setup for the display
    static int wordLength = word.length();
    // create a display for the correct letters guessed
    static char[] wordDisplay = new char[wordLength];



    public static void main(String[] args) {
        //make the word Display start with _s for characters
        for(int i = 0; i <= wordLength -1; i++){
            wordDisplay[i] = '_';
        }
        // while you still have chances and the word is not guessed lets play the game.


            while (chances > 0) {
                String displayString = new String(wordDisplay);
                if (!displayString.equals(word)) {
                System.out.println(wordDisplay);
                guesses(sc);

                //subtract a chance after each round
                chances--;
                //while we still have chances then display how many we have for reference
                if (chances > 0) {
                    System.out.println("You have " + chances + " chances left.");
                } else {
                    //if we don't have chances then tell them that they lost
                    System.out.println("You lose!");
                }
            }else{
                    System.out.println("You win!");
                    chances = 0;
                }
        }

    }
    public static void guesses(Scanner sc){
        //prompt for a guess
        System.out.println("Please guess a letter.");
        // remind them what they guessed
        System.out.println("So far you have guessed: " + guesses);
        //send the guess to a variable
        char playerGuess = sc.next().charAt(0);
        //guess test **COMMENT OUT IF NO LONGER NEEDED**
        //System.out.println("You guessed: " + playerGuess);
        //We don't want the person to guess a letter that they already did so let's prevent them from doing so
        //create a boolean to make sure they haven't guessed that letter
        boolean hasGuessed = guesses.contains(playerGuess);
        //check if they guessed that letter
        if (hasGuessed){
            // if they already guessed it do this
            System.out.println("You can't guess a letter you have already guessed.");
            guesses(sc);
        }
        else {
            //regardless of being right or wrong add the guess to the player's guesses
            guesses.add(playerGuess);

            //see if the guess is in the word
            for (int i = 0; i <= wordArray.length - 1; i++) {
                //I have to cast the letter to be checked to a variable because java is dumb...
                char letterCheck = wordArray[i];
                //if it is in the word then do this
                if (playerGuess == letterCheck) {
                    System.out.println("There is a\\ an " + playerGuess + " in the word!");
                    wordDisplay[i] = playerGuess;
                    chances++;
                }


            }
        }



    }
}
