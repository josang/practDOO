package mastermind.controllers.local;

import mastermind.models.Game;
import mastermind.controllers.local.LocalContinueController;
import mastermind.controllers.local.LocalStartController;
import mastermind.main.Logic;

public class LocalLogic implements Logic {
    
    private Game game;
    
    private LocalStartController startController;
    
    private LocalSecretCodeController secretCodeController;

    private LocalContinueController continueController;
    
    private LocalCodeGuessControllerBuilder codeGuessControllerBuilder;

    public LocalLogic() {
        game = new Game();
        codeGuessControllerBuilder = new LocalCodeGuessControllerBuilder(game);
        startController = new LocalStartController(game, codeGuessControllerBuilder);
        continueController = new LocalContinueController(game);
        secretCodeController = new LocalSecretCodeController(game);
    }

    public LocalOperationController getOperationController() {
        switch (game.getState()){
        case INITIAL:
            return startController;
        case SECRET_CODE:
            return secretCodeController;
        case IN_GAME:
            return codeGuessControllerBuilder.getCodeGuessController();
        case FINAL:
            return continueController;
        case EXIT:
        default:
            return null;
        }
    }

}
