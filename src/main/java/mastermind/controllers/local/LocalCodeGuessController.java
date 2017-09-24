package mastermind.controllers.local;

import mastermind.controllers.CodeGuessController;
import mastermind.controllers.Error;
import mastermind.controllers.OperationControllerVisitor;
import mastermind.models.Code;
import mastermind.models.Game;

abstract class LocalCodeGuessController extends LocalOperationController implements CodeGuessController {

    protected LocalCodeGuessController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);

    }
    
    public Error validateCode(Code code) {
        assert code != null;
        if (!code.valid()) {
            return Error.INVALID_CODE;
        }
        return null;
    }

}
