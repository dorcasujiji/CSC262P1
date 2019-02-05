package main.java.apps;

import main.java.InputLine;
import main.java.ShellEnvironment;
import main.java.Task;

import java.util.ArrayList;

/**
 * This Task mimics the UNIX Sort utility
 * @command sort
 *
 * @author Dorcas Ujij
 */
public class Sort extends Task {
    ArrayList<String> inputList = new ArrayList<>();
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public Sort(ShellEnvironment env, String[] args) {
        super(env, args);
    }

    @Override
    protected void update() {
        InputLine line = this.input.poll();
        if(line == null) {
            return;
        }

        if(line.isEndOfFile()) {
            inputList.sort(null);
            for(String lineStr: inputList) {
                this.println(lineStr);
            }
            this.closeOutput();
            this.exit(0);
            return;
        }

        inputList.add(line.get());
    }
}
