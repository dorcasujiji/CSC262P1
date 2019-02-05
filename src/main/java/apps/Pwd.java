package main.java.apps;

import java.io.File;

import main.java.ShellEnvironment;
import main.java.Task;

public class Pwd extends Task {
	
	File workingDir;

	public Pwd(ShellEnvironment env, String[] args) {
		super(env, args);
		this.workingDir = env.currentDirectory;
	}

	@Override
	protected void update() {
		this.println(workingDir.getAbsolutePath());
		this.closeOutput();
		this.exit(0);
	}

}
