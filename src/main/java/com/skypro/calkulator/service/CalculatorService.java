package com.skypro.calkulator.service;

import com.skypro.calkulator.exception.IllegalNumberException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer plus(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public Integer minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public Integer divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new IllegalNumberException("На ноль делить нельзя.");
        }
        return num1 / num2;
    }
}
