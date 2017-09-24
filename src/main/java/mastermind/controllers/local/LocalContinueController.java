package mastermind.controllers.local;

import mastermind.controllers.ContinueController;
import mastermind.controllers.OperationControllerVisitor;
import mastermind.models.Game;
import mastermind.models.State;

public class LocalContinueController extends LocalOperationController implements ContinueController {

    LocalContinueController(Game game) {
        super(game);
    }

    public void resume(boolean another) {
        assert this.getState() == State.FINAL;
        if (another) {
            this.resetGame();
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

}
