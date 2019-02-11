package main.java.apps;

import main.java.ShellEnvironment;
import main.java.Task;

import java.io.File;

public class ListFiles extends Task {

    File currentDir;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public ListFiles(ShellEnvironment env, String[] args) {
        super(env, args);
        this.currentDir = env.currentDirectory;
    }

    @Override
    protected void update() {
        String[] files = currentDir.list();
        for(String file: files) {
            this.println(file);
        }
        this.closeOutput();
        this.exit(0);
        return;
    }
}
