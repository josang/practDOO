package mastermind.main;

import mastermind.controllers.OperationController;
import mastermind.controllers.local.LocalLogic;
import mastermind.views.console.ConsoleView;

public class Mastermind {
    
    private Logic logic;
    
    private View view;
    
    public Mastermind(View view, Logic logic) {
        this.view = view;
        this.logic = logic;
    }
    
    public void play() {
        OperationController controller;
        do {
            controller = logic.getOperationController();
            if (controller != null){
                view.interact(controller);
            }
        } while (controller != null);   
    }
    
    public static void main(String[] args) {
        new Mastermind(new ConsoleView(), new LocalLogic()).play();
    }

}
