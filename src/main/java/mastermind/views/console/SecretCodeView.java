package mastermind.views.console;

import mastermind.controllers.SecretCodeController;
import mastermind.utils.IO;

public class SecretCodeView {
    
    void interact(SecretCodeController secretCodeController){
        
        IO io = new IO();
        
        secretCodeController.createSecretCode();
        io.writeln("Se ha creado un código secreto. Intente adivinarlo." );
    }

}
