package org.example;

import java.util.LinkedList;

public class Stack {

    private final LinkedList<String> stack = new LinkedList<>();

    public Stack() {
        stack.addFirst("$");
    }

    public void clear() {
        stack.clear();
        stack.addFirst("$");
    }

    public void push(String symbol) {
        stack.addLast(symbol);
    }

    public String pop() {
        return stack.removeLast();
    }

}
