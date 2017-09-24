package mastermind.controllers;

import mastermind.models.Code;

public interface CodeGuessController extends OperationController{

    void guessCode(Code code);
    
    int attempt();
    
    Code getGuessCode();
    
    Error validateCode(Code code);
    
    boolean secretCodeDiscovered();
    
    boolean noMoreAttempts();

    int numberInjured();

    int numberDeaths();

    void accept(CodeGuessControllerVisitor colocateControllerVisitor);

}
