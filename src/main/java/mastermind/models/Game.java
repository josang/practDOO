package mastermind.models;

public class Game {

    private State state;

    private Attempt attempt;

    private Code secretCode;
    
    private Feedback feedback;
    
    private static final int MAX_ATTEMPTS = 8;

    public Game() {
        state = State.INITIAL;
        this.reset();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Code secretCode() {
        return this.secretCode;
    }

    public void setSecretCode(Code secretCode) {
        this.secretCode = secretCode;
    }
    
    public int attempt() {
        return this.attempt.value();
    }
    
    public void increaseAttemptCount() {
        this.attempt.change();
    }

    public void reset() {
        this.attempt = new Attempt();
    }

    public void processFeedback(Code guessCode) {
        this.feedback = new Feedback( this.secretCode, guessCode );
        this.feedback.guessFeedback();
    }

    public int numberDeaths() {
        return this.feedback.deaths();
    }

    public int numberInjured() {
        return this.feedback.injured();
    }

    public boolean finished() {
        return secretCodeDiscovered() || noMoreAttempts();
    }

    public boolean secretCodeDiscovered() {
        return this.secretCode.getNumberElements() == this.feedback.deaths();
    }

    public boolean noMoreAttempts() {
        return this.attempt() >= Game.MAX_ATTEMPTS;
    }

}
