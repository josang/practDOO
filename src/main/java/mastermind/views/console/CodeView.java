package mastermind.views.console;

import mastermind.models.Code;
import mastermind.utils.IO;

public class CodeView {

    private String title;

    private IO io;

    CodeView(String title) {
        assert title != null;

        this.title = title;
        io = new IO();

    }

    String read() {
        return io.readString(this.title);
    }

    void write(Code code) {
        io.writeln(this.title + code.toString());

    }

}
