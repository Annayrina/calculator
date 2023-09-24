package pro.sky.calculator.Service;

import org.springframework.stereotype.Service;

@Service

public class CalculatorServicelmpm implements CalculatorSer {
    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
