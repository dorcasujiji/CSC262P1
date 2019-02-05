package main.java.apps;

import main.java.ShellEnvironment;
import main.java.Task;

import java.util.HashMap;

public class SetVar extends Task {
    protected HashMap<String, String> map = new HashMap<>();
    String varName;
    String varValue;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public SetVar(ShellEnvironment env, String[] args) {
        super(env, args);
        this.varName = args[0];
        this.varValue = args[1];
    }

    @Override
    protected void update() {
        map.put(varName, varValue);
        this.closeOutput();
        this.exit(0);
        return;
    }
}
