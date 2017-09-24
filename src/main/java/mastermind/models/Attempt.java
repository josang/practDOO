package mastermind.models;

public class Attempt {
    
    private int value = 1;
    
    public Attempt() {
        this.value = 1;
    }
    
    public int value() {
        return this.value;
    }
    
    public void change() {
        value = value + 1;
    }

}
