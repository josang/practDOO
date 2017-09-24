package mastermind.controllers;

import mastermind.models.Code;

public interface SecretCodeController extends OperationController{
    
    void createSecretCode();
    
    Code secretCode();

}
