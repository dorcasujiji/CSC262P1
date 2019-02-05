package main.java.apps;

import main.java.InputLine;
import main.java.ShellEnvironment;
import main.java.Task;

/**
 * This Task mimics the UNIX Grep utility with string argument
 * @command grep
 *
 * @author Dorcas Ujij
 */
public class SimpleGrep extends Task {

    String grepString;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public SimpleGrep(ShellEnvironment env, String[] args) {
        super(env, args);
        this.grepString = args[0];
    }

    @Override
    protected void update() {
        InputLine line = this.input.poll();
        if(line == null) {
            return;
        }

        if(line.isEndOfFile()) {
            this.closeOutput();
            this.exit(0);
            return;
        }

        // print line if line contains argument (case sensitive)
        String lineStr = line.get();
        if(lineStr.contains(grepString)) {
            this.println(lineStr);
        }
    }
}
