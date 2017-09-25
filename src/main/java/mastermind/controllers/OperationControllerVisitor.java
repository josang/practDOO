package mastermind.controllers;

public interface OperationControllerVisitor {

	void visit(StartController startController);
	
	void visit(SecretCodeController secretCodeController);
	
	void visit(CodeGuessController codeGuessController);
	
	void visit(ContinueController continueController);

}

