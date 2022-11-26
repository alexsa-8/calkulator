package com.skypro.calkulator.service;

import com.skypro.calkulator.exception.IllegalNumberException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalNumberException("На ноль делить нельзя.");
        }
        return num1 / num2;
    }
}
