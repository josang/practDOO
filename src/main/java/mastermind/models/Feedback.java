package mastermind.models;

public class Feedback {
    
    private int deaths;
    private int injured;
    private boolean[] codeCheck;
    
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
        
        this.codeCheck = new boolean[this.secretCode.getNumberElements()];
        for (int i = 0; i < this.secretCode.getNumberElements(); i++) {
            this.codeCheck[i] = false;
        }
        
        this.calculateDeaths();
        this.calculateInjured();
        
    }
    
    private void calculateDeaths() {
        for (int i = 0; i < this.secretCode.getNumberElements(); i++) {
            if (secretCode.getElement(i) == guessCode.getElement(i)) {
                this.deaths++;
                this.codeCheck[i] = true;
            }
        }
    }
    
    private void calculateInjured() {
        for (int i = 0; i < this.secretCode.getNumberElements(); i++) {
            if (!this.codeCheck[i]) {
                int j = 0;
                while (j < this.secretCode.getNumberElements()) {
                    if (secretCode.getElement(j) == guessCode.getElement(i) && !this.codeCheck[j]) {
                        this.injured++;
                        this.codeCheck[j] = true;
                        j = this.secretCode.getNumberElements();
                    }
                    j++;
                }
            }
        }

    }

}
