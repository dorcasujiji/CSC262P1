package main.java.apps;

import main.java.InputLine;
import main.java.ShellEnvironment;
import main.java.Task;

import java.util.regex.Pattern;

/**
 * This Task mimics the UNIX Grep utility with regex argument
 * @command regrep
 *
 * @author Dorcas Ujij
 */
public class RegexGrep extends Task {
    Pattern regex;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public RegexGrep(ShellEnvironment env, String[] args) {
        super(env, args);
        this.regex = Pattern.compile(args[0]);
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

        String lineStr = line.get();
        if(regex.matcher(lineStr).find()) {
            this.println(lineStr);
        }
    }
}
