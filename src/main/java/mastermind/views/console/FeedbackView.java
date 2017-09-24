package mastermind.views.console;

import mastermind.controllers.CodeGuessController;
import mastermind.utils.IO;

public class FeedbackView {
    
    private IO io;
    private CodeGuessController codeGuessController;
    
    public FeedbackView(CodeGuessController codeGuessController) {
        this.codeGuessController = codeGuessController;
        io = new IO();
    }
    
    public void show() {
        if ( codeGuessController.secretCodeDiscovered()) {
            io.write( "Has acertado el código secreto!!! Victoria");
        }else { 
            
            io.write(codeGuessController.numberDeaths() + " muertos");
            io.write(" y " + codeGuessController.numberInjured() + " heridos");
            
            if ( codeGuessController.noMoreAttempts()) {
                io.writeln();
                io.write( "Se han acabado los intentos. Has perdido");
            }
        }
        
        io.writeln();
    }
}
