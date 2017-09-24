package mastermind.views.console;

import mastermind.controllers.CodeGuessController;
import mastermind.controllers.CodeGuessControllerVisitor;
import mastermind.controllers.local.LocalDemoCodeGuessController;
import mastermind.controllers.local.LocalUserCodeGuessController;
import mastermind.models.Code;

class CodeGuessView implements CodeGuessControllerVisitor{
    
    private CodeGuessController codeGuessController;
    
    private Code code;
    
    private String title;

    CodeGuessView(CodeGuessController codeGuessController){
        assert codeGuessController != null;
        this.codeGuessController = codeGuessController;
    }
    
    Code getGuessCode() {
        this.code = this.codeGuessController.getGuessCode();
        title = "Intento " + this.codeGuessController.attempt() + " [ " + this.code.getNumberElements() + " letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro] ";
        this.codeGuessController.accept(this);
        return code;
    }
    
    @Override
    public void visit(LocalUserCodeGuessController usercodeGuessController) {
        String userCode = new CodeView( this.title ).read().toUpperCase();
        this.code.setCodeFromString( userCode );          
    }
    
    @Override
    public void visit(LocalDemoCodeGuessController democodeGuessController) {
        new CodeView( this.title ).write( this.code );
    }



}
