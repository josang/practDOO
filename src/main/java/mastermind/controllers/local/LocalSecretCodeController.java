package mastermind.controllers.local;

import mastermind.controllers.OperationControllerVisitor;
import mastermind.controllers.SecretCodeController;
import mastermind.models.Code;
import mastermind.models.Game;
import mastermind.models.State;

public class LocalSecretCodeController extends LocalOperationController implements
    SecretCodeController{
    
    LocalSecretCodeController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void createSecretCode() {
        assert this.getState() == State.SECRET_CODE;
        
        Code secretCode = new Code();
        secretCode.random();
        this.setSecretCode( secretCode );
        this.setState(State.IN_GAME);       
    }

}
