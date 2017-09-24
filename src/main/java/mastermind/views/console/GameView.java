package mastermind.views.console;

import mastermind.controllers.CodeGuessController;
import mastermind.models.Code;
import mastermind.utils.IO;
import mastermind.controllers.Error;

class GameView {

    private IO io = new IO();

    public void interact(CodeGuessController codeGuessController) {
        CodeGuessView codeGuessView = new CodeGuessView(codeGuessController);
        this.guessCode(codeGuessController, codeGuessView);
        this.showFeedback(codeGuessController);
    }

    private void guessCode(CodeGuessController codeGuessController, CodeGuessView codeGuessView) {
        Code attemptCode;
        Error error = null;
        do {
            attemptCode = codeGuessView.getGuessCode();
            error = codeGuessController.validateCode(attemptCode);
            if (error != null) {
                io.writeln("" + error);
            }
        } while (error != null);
        codeGuessController.attemptCode(attemptCode);
    }

    private void showFeedback(CodeGuessController codeGuessController) {
        new FeedbackView(codeGuessController).show();
    }

}
