package main.java.apps;

import main.java.ShellEnvironment;
import main.java.Task;

/**
 * This Task mimics the UNIX Echo utility
 *
 * @author Dorcas Ujij
 */
public class Echo extends Task {
    String[] args;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public Echo(ShellEnvironment env, String[] args) {
        super(env, args);
        this.args = args;
    }

    @Override
    protected void update() {
        StringBuilder builder = new StringBuilder();
        for(String string: args) {
            builder.append(string + " ");
        }
        this.println(builder.toString());
        this.closeOutput();
        this.exit(0);
        return;
    }
}
