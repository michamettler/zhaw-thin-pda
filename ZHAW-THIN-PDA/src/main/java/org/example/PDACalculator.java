package org.example;

import java.util.InvalidPropertiesFormatException;
import java.util.Objects;

public class PDACalculator {


    private State currentState = State.START;
    private Stack stack = new Stack();
    private String numberPattern = "[0-9]+";

    public String calculate(String input) throws InvalidPropertiesFormatException {
        String[] symbols = input.split(" ");
        String result = "";

        for (String symbol : symbols) {
            switch (currentState) {
                case START:
                    if (!Operator.matches(symbol)) {
                        stack.push(symbol);
                        currentState = State.FIRST_NUMBER;
                    } else {
                        throw new InvalidPropertiesFormatException("Invalid Format!");
                    }
                    break;
                case FIRST_NUMBER:
                    if (!Operator.matches(symbol)) {
                        stack.push(symbol);
                        currentState = State.N_NUMBER;
                    } else {
                        throw new InvalidPropertiesFormatException("Invalid Format!");
                    }
                    break;
                case N_NUMBER:
                    if (!Operator.matches(symbol)) {
                        stack.push(symbol);
                        currentState = State.N_NUMBER;
                    } else {
                        if (Objects.equals(Operator.ADDITION.value, symbol)) {
                            executeAddition();
                        } else {
                            executeMultiplication();
                        }
                        currentState = State.FIRST_NUMBER;
                    }
                    break;
            }
        }

        return result;
    }

    private void executeAddition() throws InvalidPropertiesFormatException {
        String first = stack.pop();
        String second = stack.pop();

        if (first.matches(numberPattern)) {
            String sum = String.valueOf(Integer.parseInt(first) + Integer.parseInt(second));
            String previous = stack.pop();
            if (previous.matches(numberPattern)) {
                stack.push(previous);
                stack.push(sum);
                executeAddition();
            } else {
                stack.push(previous);
                stack.push(sum);
                stack.push("+");
            }
        } else {
            throw new InvalidPropertiesFormatException("Invalid Format!");
        }
    }

    private void executeMultiplication() throws InvalidPropertiesFormatException {
        String first = stack.pop();
        String second = stack.pop();

        if (!first.matches(numberPattern)) {
            String previous = stack.pop();
            if (previous.matches(numberPattern)) {
                stack.push(previous);
                executeMultiplication();
            } else {
                stack.push(previous);
                stack.push(String.valueOf(Integer.parseInt(first) * Integer.parseInt(second)));
                stack.push("+");
            }
        } else {
            throw new InvalidPropertiesFormatException("Invalid Format!");
        }
    }


}
