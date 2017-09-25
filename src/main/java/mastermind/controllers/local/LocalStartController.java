package mastermind.controllers.local;

import mastermind.controllers.OperationControllerVisitor;
import mastermind.controllers.StartController;
import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.ClosedInterval;

public class LocalStartController extends LocalOperationController implements StartController {

    private LocalCodeGuessControllerBuilder localCodeGuessControllerBuilder;

    LocalStartController(Game game, LocalCodeGuessControllerBuilder localCodeGuessControllerBuilder) {
        super(game);
        assert localCodeGuessControllerBuilder != null;
        this.localCodeGuessControllerBuilder = localCodeGuessControllerBuilder;
    }

    public void start(int option) {
        assert new ClosedInterval(1, this.gameOptions().length).includes(option);
        assert this.getState() == State.INITIAL;
        localCodeGuessControllerBuilder.build(option);
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
