package com.skypro.calkulator.controller;

import com.skypro.calkulator.exception.IllegalNumberException;
import com.skypro.calkulator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        Integer result = calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1,num2,result);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        Integer result = calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1,num2,result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        Integer result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1,num2,result);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        Integer result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1,num2,result);
    }
}
