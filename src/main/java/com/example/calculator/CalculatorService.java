package com.example.calculator;

// CalculatorService.java
public class CalculatorService {

    private MathOperation mathOperation;

    public CalculatorService(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }

    public int performAddition(int a, int b) {
        return mathOperation.add(a, b);
    }
}
