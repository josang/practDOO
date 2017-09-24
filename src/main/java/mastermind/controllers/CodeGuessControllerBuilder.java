package mastermind.controllers;

public interface CodeGuessControllerBuilder {

    CodeGuessController getCodeGuessController();

    void build(int option);
}
