package mastermind.main;

import mastermind.controllers.OperationController;
import mastermind.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

	public void interact(OperationController operationController);
}
