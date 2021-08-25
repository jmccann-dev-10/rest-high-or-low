package learn.higherorlower.contoller;

import learn.higherorlower.model.Game;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guessing-game")
public class HigherOrLowerController {

    private static String GREETING = "Welcome to the game?!";
    private Game guessingGame;

    @GetMapping("/")
    public String getStatus() {
        if (guessingGame == null) {
            return "The game is currently not running.";
        } else {
            return guessingGame.toString();
        }
    }

    @PutMapping("/start")
    public String startGame() {
        if (guessingGame == null || guessingGame.isOver()) {
            guessingGame = new Game();
            return "Games successfully started.";
        } else if (guessingGame.isOver()) {
            return "You already won.  Go away";
        }

        return "Game is already in progress";
    }

    @PutMapping("{guessNumber}")
    public String guessNumber(@PathVariable int guessNumber) {
        if (guessingGame == null) {
            return "The game is currently not running.";
        } else {
            return guessingGame.checkGuess(guessNumber);
        }
    }

    /*
      Class game logic

      Controller
      * [ ] GET   /guessing-game/ - get the status of the game
      * [ ] PUT   /guessing-game/start - start the game, generate a random number
      * [ ] PUT   /guessing-game/{guessNumber} - Allow guess, return result of guess
     */

}
