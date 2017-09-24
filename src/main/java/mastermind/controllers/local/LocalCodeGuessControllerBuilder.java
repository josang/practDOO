package mastermind.controllers.local;

import mastermind.controllers.CodeGuessControllerBuilder;
import mastermind.models.Game;

class LocalCodeGuessControllerBuilder implements CodeGuessControllerBuilder {

    private LocalCodeGuessController codeGuessController;

    private Game game;

    LocalCodeGuessControllerBuilder(Game game) {
        this.game = game;
    }

    public LocalCodeGuessController getCodeGuessController() {

        return this.codeGuessController;
    }

    public void build(int option) {

        if (option == 1) {
            this.codeGuessController = new LocalUserCodeGuessController(this.game);
        } else if (option == 2) {
            this.codeGuessController = new LocalDemoCodeGuessController(this.game);
        }

    }

}
