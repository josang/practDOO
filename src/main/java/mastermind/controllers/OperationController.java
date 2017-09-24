package mastermind.controllers;

public interface OperationController {
    
    void accept(OperationControllerVisitor operationControllerVisitor);

}
