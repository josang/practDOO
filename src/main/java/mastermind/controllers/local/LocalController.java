package mastermind.controllers.local;

import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.models.State;

public abstract class LocalController {

    private Game game;

    protected LocalController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected State getState() {
        return game.getState();
    }

    public void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    public void attemptCode(Code code) {
        assert code != null;
        this.game.processFeedback(code);
        if (game.finished()) {
            game.setState(State.FINAL);
        } else {
            game.increaseAttemptCount();
        }
    }

    public void resetGame() {
        game.reset();
    }

    public int numberDeaths() {
        return this.game.numberDeaths();
    }

    public int numberInjured() {
        return this.game.numberInjured();
    }

    public boolean secretCodeDiscovered() {
        return this.game.secretCodeDiscovered();
    }
    
    public boolean noMoreAttempts() {
        return this.game.noMoreAttempts();
    }

    public Code secretCode() {
        return this.game.secretCode();
    }

    public void setSecretCode(Code code) {
        this.game.setSecretCode(code);
    }

    public int attempt() {
        return this.game.attempt();
    }

}
