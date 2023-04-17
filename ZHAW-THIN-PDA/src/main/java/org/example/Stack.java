package org.example;

import java.util.LinkedList;

public class Stack {

    private final LinkedList<String> stack = new LinkedList<>();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public Stack() {
        stack.addFirst("$");
    }

    public void push(String symbol) {
        stack.addLast(symbol);
    }

    public String pop() {
        return stack.removeLast();
    }

    @Override
    public String toString() {
        StringBuilder visualization = new StringBuilder();
        visualization.append("\n------");

        for (String entry : stack) {
            if (("$").equals(entry)) {
                visualization.insert(0, "\n| " + ANSI_RED + (entry.length() == 1 ? entry + " " : entry)
                        + ANSI_RESET + " |");
            } else {
                visualization.insert(0, "\n| " + ANSI_GREEN + (entry.length() == 1 ? entry + " " : entry)
                        + ANSI_RESET + " |");
            }
        }

        visualization.insert(0, "\n|    |");

        return visualization.toString();
    }
}
