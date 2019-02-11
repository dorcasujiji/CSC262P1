package main.java.apps;

import main.java.ShellEnvironment;
import main.java.Task;

/**
 * This Task mimics the UNIX "=" utility
 * sets a variable's value
 *
 * @author Dorcas Ujij
 */
public class SetVar extends Task {
    String name;
    String value;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public SetVar(ShellEnvironment env, String[] args) {
        super(env, args);
        try {
            this.name = args[0];
            this.value = args[1];
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong number of arguments given. ");
        }
    }

    @Override
    protected void update() {
        env.setVariable(name, value);
        this.closeOutput();
        this.exit(0);
        return;
    }
}
