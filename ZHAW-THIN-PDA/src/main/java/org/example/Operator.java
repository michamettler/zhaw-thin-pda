package org.example;

public enum Operator {
    ADDITION("+"),
    MULTIPLICATION("*");

    public final String value;

    Operator(String value) {
        this.value = value;
    }

    public static boolean matches(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.value.equals(symbol))
                return true;
        }
        return false;
    }
}
