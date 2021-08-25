package learn.higherorlower.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static int MAX_GUESS_NUM = 100;

    private boolean isRunning;
    private int theNumber;
    List<Integer> guessesMade = new ArrayList<>();

    public Game() {
        Random rand = new Random();
        this.isRunning = true;
        theNumber = rand.nextInt(MAX_GUESS_NUM) + 1;
    }

    public boolean isOver() {
        return !isRunning;
    }

    public String checkGuess(int guess) {
        String result;

        if (!validateGuess(guess) || !isRunning) {
            return "Guess is invalid.";
        }

        guessesMade.add(guess);
        if (guess == theNumber) {
            isRunning = false;
            result = "Congrats you win!";
        } else if (guess > theNumber) {
            result = "Your guess is too high.";
        } else {
            result = "Your guess is too low.";
        }

        return result;
    }

    private boolean validateGuess(int guess) {
        return guess >= 1 &&
                guess <= MAX_GUESS_NUM &&
                !guessesMade.contains(guess);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game is currently ")
                .append(isRunning ? "running" : "not running")
                .append("\n")
                .append("Guesses made:");
        for (int guess : guessesMade) {
            sb.append(guess).append(", ");
        }
        return sb.toString();
    }
}
