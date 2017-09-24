package mastermind.views.console;

import mastermind.controllers.CodeGuessController;
import mastermind.controllers.CodeGuessControllerVisitor;
import mastermind.controllers.local.LocalDemoCodeGuessController;
import mastermind.controllers.local.LocalUserCodeGuessController;
import mastermind.models.Code;

class CodeGuessView implements CodeGuessControllerVisitor{
    
    private CodeGuessController codeAttemptController;
    
    private Code code;
    
    private String title;

    CodeGuessView(CodeGuessController codeAttemptController){
        assert codeAttemptController != null;
        this.codeAttemptController = codeAttemptController;
    }
    
    Code getGuessCode() {
        this.code = this.codeAttemptController.getGuessCode();
        title = "Intento " + this.codeAttemptController.attempt() + " [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
        this.codeAttemptController.accept(this);
        return code;
    }
    
    @Override
    public void visit(LocalUserCodeGuessController userCodeAttemptController) {
        String userCode = new CodeView( this.title ).read().toUpperCase();
        this.code.setCodeFromString( userCode );          
    }
    
    @Override
    public void visit(LocalDemoCodeGuessController demoCodeAttemptController) {
        new CodeView( this.title ).write( this.code );
    }



}
