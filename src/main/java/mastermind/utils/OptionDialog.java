package mastermind.utils;

public class OptionDialog {
    
    
    private String [] options;
    
    public OptionDialog( String [] options ) {
        assert options != null;
        this.options = options;
    }
    
    public int read() {
        IO io = new IO();
        int value;
        boolean ok;
        ClosedInterval limits = new ClosedInterval( 1, this.options.length );
        
        for ( int i = 0; i < this.options.length; i++ ) {
            io.writeln( ( i + 1 ) + ". " + this.options[i] );
        }
        
        do {
            value = io.readInt("Opción? ");
            ok = limits.includes(value);
            if (!ok) {
                io.writeln("El valor no corresponde a una de las opciones ofrecidas");
            }
        } while (!ok);
        return value;
    }

}

