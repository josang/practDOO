package mastermind.controllers.local;

import mastermind.controllers.OperationControllerVisitor;
import mastermind.controllers.StartController;
import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.ClosedInterval;

public class LocalStartController extends LocalOperationController implements StartController {

    private LocalCodeGuessControllerBuilder colocateControllerBuilder;

    LocalStartController(Game game, LocalCodeGuessControllerBuilder colocateControllerBuilder) {
        super(game);
        assert colocateControllerBuilder != null;
        this.colocateControllerBuilder = colocateControllerBuilder;
    }

    public void start(int option) {
        assert new ClosedInterval(1, this.gameOptions().length).includes(option);
        assert this.getState() == State.INITIAL;
        colocateControllerBuilder.build(option);
        this.setState(State.SECRET_CODE);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public String[] gameOptions() {
        return new String [] { "Partida", "Demo" };
    }

}
