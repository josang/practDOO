package mastermind.models;

public class Feedback {
    
    private int deaths;
    private int injured;
    private boolean[] secretCodeCheck;
    
    private Code secretCode;
    private Code guessCode;
    
    public Feedback(Code secretCode, Code guessCode) {
        this.secretCode = secretCode;
        this.guessCode = guessCode;
    }
    
    public int deaths() {
        return this.deaths;
    }
    
    public int injured() {
        return this.injured;
    }
    
    public void guessFeedback() {
        
        this.deaths = 0;
        this.injured = 0;
        
        this.secretCodeCheck = new boolean[this.secretCode.getNumberElements()];
        for (int i = 0; i < this.secretCode.getNumberElements(); i++) {
            this.secretCodeCheck[i] = false;
        }
        
        this.calculateDeaths();
        this.calculateInjured();
        
    }
    
    private void calculateDeaths() {
        for (int i = 0; i < this.secretCode.getNumberElements(); i++) {
            if (secretCode.getElement(i) == guessCode.getElement(i)) {
                this.deaths++;
                this.secretCodeCheck[i] = true;
            }
        }
    }
    
    private void calculateInjured() {
        for (int i = 0; i < this.secretCode.getNumberElements(); i++) {
            if (this.secretCode.getElement(i) != this.guessCode.getElement(i)) {
                int j = 0;
                while (j < this.secretCode.getNumberElements()) {
                    if (secretCode.getElement(j) == guessCode.getElement(i) && !this.secretCodeCheck[j]) {
                        this.injured++;
                        this.secretCodeCheck[j] = true;
                        j = this.secretCode.getNumberElements();
                    }
                    j++;
                }
            }
        }

    }

}
