package com.example.calculator;

public class CalculatorService {

    private MathOperation mathOperation;

    public CalculatorService(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }

    // phương thức cộng 2 số nguyên 
    public int performAddition(int a, int b) {
        return mathOperation.add(a, b);
    }

}
