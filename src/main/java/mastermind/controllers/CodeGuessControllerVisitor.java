package mastermind.controllers;

import mastermind.controllers.local.LocalDemoCodeGuessController;
import mastermind.controllers.local.LocalUserCodeGuessController;

public interface CodeGuessControllerVisitor {

    void visit(LocalDemoCodeGuessController localDemoCodeAttemptController);

    void visit(LocalUserCodeGuessController userCodeAttemptController);
}
