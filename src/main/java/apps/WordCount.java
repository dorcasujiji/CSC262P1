package main.java.apps;

import main.java.InputLine;
import main.java.ShellEnvironment;
import main.java.Task;

public class WordCount extends Task {
    int lineCount, wordCount, byteCount = 0;

    public WordCount(ShellEnvironment env, String[] args) {
        super(env, args);
    }

    @Override
    protected void update() {
        InputLine line = this.input.poll();
        if (line == null) {
            // still waiting for more...
            return;
        }

        // only output and print when we've seen the whole file!
        if (line.isEndOfFile()) {
            this.println(lineCount + " "+ wordCount + " "+ byteCount);
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Otherwise, increment counts!
        String currLine = line.get();
        lineCount ++;
        wordCount += currLine.split("\\s+").length;
        byteCount += currLine.length();
    }

}
