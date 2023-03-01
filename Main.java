import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int lives = 7;
        int meme = 2;
        ArrayList<Character> guesses = new ArrayList<Character>();
        Scanner input = new Scanner(System.in);
        System.out.println("---Welcome to AJ's Hangman! (Version 2.0)---");
        System.out.println("Please enter your secret word (No Spaces!)");
        String secretWord = input.next(); //players word
        char[] current = buildCurrent(secretWord);
        eightEnters();
        while (meme == 2) {
            System.out.println("please give me a guess: ");
            char guess = input.next().charAt(0); //next guess
            int cnt = 0;
            for (int lcv = 0; lcv < secretWord.length(); lcv++) {
                if (secretWord.charAt(lcv) == guess) {
                    current[lcv] = secretWord.charAt(lcv);
                    cnt++;
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            if (checkWin(current)) {
                //while(lives > 0) {
                System.out.println("YOU WIN!");
                System.exit(0);
                //}
            } else if (cnt > 0) {
                System.out.println("lives: " + lives);
                System.out.println();
                printGuesses(guesses);
                System.out.println();
                printWord(current);
                System.out.println();
                System.out.println("Very good!");
            } else if (lives == 0) {
                //while(meme == 2){
                System.out.println("YOU LOSE!");
                System.out.println("The word was: " + secretWord);
                System.exit(0);
                //}
            } else {
                lives--;
                guesses.add(guess);
                System.out.println("lives: " + lives);
                System.out.println();
                printGuesses(guesses);
                System.out.println();
                printWord(current);
                System.out.println();
                System.out.println("Bruh... ");
            }
        }
    }


    public static String checkHangman(String word, String cur, char c) {
        for (int lcv = 0; lcv < word.length(); lcv++) {
            if (word.charAt(lcv) == c) {
                cur = cur.replace(cur.charAt(lcv), word.charAt(lcv));
            }
        }
        return cur;
    }

    public static void eightEnters(){
        for (int lcv = 0;lcv<8;lcv++){
            System.out.println();
        }
    }

    public static char[] buildCurrent(String secret){
        char[] current = new char[secret.length()];
        for (int lcv = 0; lcv < secret.length();lcv++) {
            current[lcv] += '_';
        }
        return current;
    }

    public static void printWord(char[] current){
        for (int lcv = 0; lcv < current.length; lcv++){
            System.out.print(current[lcv] + " ");
        }
    }

    public static void printGuesses(ArrayList<Character> c){
        System.out.print("Your guesses so far: ");
        for (int lcv = 0; lcv < c.size(); lcv++){
            System.out.print(c.get(lcv) + " ");
        }
    }

    public static boolean checkWin(char[] c){
        boolean ans = true;
        for (int lcv = 0; lcv < c.length; lcv++){
            if (c[lcv] == '_'){
                ans = false;
            }
        }
        return ans;
    }
}
