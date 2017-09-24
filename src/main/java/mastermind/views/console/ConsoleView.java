package mastermind.views.console;

import mastermind.main.View;
import mastermind.controllers.CodeGuessController;
import mastermind.controllers.ContinueController;
import mastermind.controllers.OperationController;
import mastermind.controllers.SecretCodeController;
import mastermind.controllers.StartController;

public class ConsoleView implements View {

    private StartView startView;

    private GameView gameView;

    private ContinueView continueView;

    private SecretCodeView secretCodeView;

    public ConsoleView() {
        startView = new StartView();
        secretCodeView = new SecretCodeView();
        gameView = new GameView();
        continueView = new ContinueView();
    }

    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(SecretCodeController secretCodeController) {
        secretCodeView.interact(secretCodeController);
    }

    @Override
    public void visit(CodeGuessController codeAttemptController) {
        gameView.interact(codeAttemptController);
    }

    @Override
    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }

}
