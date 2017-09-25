package mastermind.controllers.local;

import mastermind.controllers.CodeGuessControllerVisitor;
import mastermind.controllers.DemoCodeGuessController;
import mastermind.models.Code;
import mastermind.models.Game;

public class LocalDemoCodeGuessController extends LocalCodeGuessController implements DemoCodeGuessController {

    public LocalDemoCodeGuessController(Game game) {
        super(game);
    }

    @Override
    public void accept(CodeGuessControllerVisitor colocateControllerVisitor) {
        colocateControllerVisitor.visit(this);

    }

    @Override
    public Code getGuessCode() {
        Code code = new Code();
        code.random();

        return code;
    }

}
