package org.example;

import java.util.Objects;

public class PDACalculator {

    private State currentState = State.START;
    private final Stack stack = new Stack();

    private String numberPattern = "[0-9]+";

    public String calculate(String input) throws IllegalArgumentException {
        String[] symbols = input.split(" ");

        for (String symbol : symbols) {
            switch (currentState) {
                case START:
                    if (Operator.noMatch(symbol)) {
                        stack.push(symbol);
                        currentState = State.FIRST_NUMBER;
                    } else {
                        throw new IllegalArgumentException();
                    }
                    break;
                case FIRST_NUMBER:
                    if (Operator.noMatch(symbol)) {
                        stack.push(symbol);
                        currentState = State.N_NUMBER;
                    } else {
                        throw new IllegalArgumentException();
                    }
                    break;
                case N_NUMBER:
                    if (Operator.noMatch(symbol)) {
                        stack.push(symbol);
                    } else {
                        if (Objects.equals(Operator.ADDITION.value, symbol)) {
                            executeAddition();
                        } else {
                            executeMultiplication();
                        }
                    }
                    break;
            }
        }
        return stack.pop();
    }

    private void executeAddition() throws IllegalArgumentException {
        String first = stack.pop();
        String second = stack.pop();

        if (first.matches(numberPattern) && first.matches(numberPattern) && !("$").equals(second)) {
            stack.push(String.valueOf(Integer.parseInt(first) + Integer.parseInt(second)));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void executeMultiplication() throws IllegalArgumentException {
        String first = stack.pop();
        String second = stack.pop();
        if (first.matches(numberPattern) && first.matches(numberPattern)) {
            stack.push(String.valueOf(Integer.parseInt(first) * Integer.parseInt(second)));
        } else {
            throw new IllegalArgumentException();
        }
    }


}
