package mastermind.controllers.local;

import mastermind.controllers.CodeGuessControllerVisitor;
import mastermind.controllers.UserCodeGuessController;
import mastermind.models.Code;
import mastermind.models.Game;

public class LocalUserCodeGuessController extends LocalCodeGuessController implements UserCodeGuessController {

    public LocalUserCodeGuessController(Game game) {
        super(game);
    }

    @Override
    public void accept(CodeGuessControllerVisitor colocateControllerVisitor) {
        colocateControllerVisitor.visit(this);
    }

    @Override
    public Code getGuessCode() {
        return new Code();
    }

}
