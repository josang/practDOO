package mastermind.models;

import java.util.Random;

public class Code {

    private static final int NUMBER_ELEMENTS = 2;

    private Color[] elements;

    public Code() {
        this.elements = new Color[NUMBER_ELEMENTS];
    }

    public int getNumberElements() {
        return Code.NUMBER_ELEMENTS;
    }

    public Color getElement(int position) {
        return this.elements[position];
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < NUMBER_ELEMENTS; i++) {
            this.elements[i] = Color.values()[random.nextInt(Color.values().length)];
        }
    }

    public void setCodeFromString(String stringCode) {
        this.elements = new Color[NUMBER_ELEMENTS];

        if (stringCode.length() == NUMBER_ELEMENTS) {
            String[] stringCodeColors = stringCode.split("");

            for (int i = 0; i < NUMBER_ELEMENTS; i++) {
                try {
                    this.elements[i] = Color.valueOf(stringCodeColors[i]);
                } catch (Exception ex) {
                    this.elements[i] = null;
                }
            }
        }
    }

    public boolean valid() {
        boolean ok;
        int i = 0;

        do {
            ok = (this.elements[i] != null);
            i++;
        } while (ok && i < NUMBER_ELEMENTS);

        return ok;
    }
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NUMBER_ELEMENTS; i++) {
            stringBuilder.append(this.elements[i].toString());
        }
        return stringBuilder.toString();
    }

}
