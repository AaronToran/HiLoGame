/*
    PlayGuessingGame.java
    Dave Klick
    CIS 260
    2015-01-13

    This program uses the HiLoGame class to play a number
    guessing game. It is provided as a driver to be used
    once the HiLoGame class has been implemented.

    Note: This class depends upon the presence of Keyboard.java
    (or Keyboard.class) in the same directory. Keyboard.java is
    provided on the course web site.
*/

public class PlayGuessingGame {
    public static void main(String[] args) {
        int low = 100;
        int high = 1;
        int guess = 0;
        char again = 'Y';
        String result = "";
        int status;
        Keyboard kbd = new Keyboard();
        while (again == 'Y') {
            HiLoGame game = new HiLoGame(high, low);
            status = HiLoGame.LOW;
            System.out.printf("Guess the secret number between %d and %d\n", game.getLow(), game.getHigh());
            while (status != HiLoGame.CORRECT) {
                guess = kbd.getInt("Your guess: ", game.getLow(), game.getHigh());
                status = game.checkGuess(guess);
                switch (status) {
                    case HiLoGame.LOW: result = "low"; break;
                    case HiLoGame.HIGH: result = "high"; break;
                    case HiLoGame.CORRECT: result = "correct"; break;
                    default: result = "undefined"; break;
                }
                System.out.printf("Your guess #%d was %s\n", game.getGuesses(), result);
            }
            System.out.println("Congratulations!");
            System.out.printf("You got the right number in %d guesses.\n\n", game.getGuesses());
            again = Character.toUpperCase(kbd.getChar("Play again (Y/N)? ", "YyNn"));
        }

        System.out.printf("\n%d %s played.\n", HiLoGame.getGames(),
                HiLoGame.getGames() == 1 ? "game was" : "games were");
    }
}
