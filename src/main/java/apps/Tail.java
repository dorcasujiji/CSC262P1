package main.java.apps;

import main.java.InputLine;
import main.java.ShellEnvironment;
import main.java.Task;

import java.util.ArrayList;

/**
 * This Task mimics the UNIX Tail utility
 * displays last $args lines of input
 *
 * @author Dorcas Ujij
 */
public class Tail extends Task {
    int counter = 10;
    int pointer = 0;
    boolean overWrite = false;
    ArrayList<String> output = new ArrayList<>();

    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public Tail(ShellEnvironment env, String[] args) {
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
            // wait for next input ...
            return;
        }

        // display content of arraylist in correct order
        if(line.isEndOfFile()) {
            for(int i=pointer; i<= output.size()-1; i++) {
                this.println(output.get(i));
            }
            for(int i=0; i<= pointer-1; i++) {
                this.println(output.get(i));
            }
            this.closeOutput();
            this.exit(0);
            return;
        }

        // cycle around arraylist
        if(pointer == counter) {
            pointer = 0;
            overWrite = true;
        }

        // keeps track of arraylist elements
        // will overwrite them if need be (size of arraylist = args[0]
        if(!overWrite) {
            output.add(pointer, line.get());
        } else {
            output.set(pointer, line.get());
        }

        pointer++;
    }
}
