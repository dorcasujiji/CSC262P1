package main.java.apps;

import main.java.InputLine;
import main.java.ShellEnvironment;
import main.java.Task;

/**
 * This Task mimics the UNIX Head utility
 * displays first $args lines of input
 *
 * @author Dorcas Ujij
 */
public class Head extends Task {
    int counter = 10;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public Head(ShellEnvironment env, String[] args) {
        super(env, args);
        if(args.length > 0) {
            try {
                this.counter = Integer.valueOf(args[0]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Argument must be an integer");
            }
        }
    }

    @Override
    protected void update() {
        InputLine line = this.input.poll();
        if(line == null) {
            return;
        }

        if(line.isEndOfFile() || counter <= 0) {
            this.closeOutput();
            this.exit(0);
            return;
        }

        // print line
        counter--;
        this.println(line.get());
    }
}
