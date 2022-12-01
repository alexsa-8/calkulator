package com.skypro.calkulator;

import com.skypro.calkulator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorServiceTests {
    public final CalculatorService calculatorService=new CalculatorService();
    public static Stream<Arguments> plusTest(){
        return Stream.of(Arguments.of(1,2,3), Arguments.of(3,4,7));
    }
    public static Stream<Arguments> minusTest(){
        return Stream.of(Arguments.of(6,5,1), Arguments.of(10,7,3));
    }
    public static Stream<Arguments> multiplyTest(){
        return Stream.of(Arguments.of(3,2,6), Arguments.of(4,5,20));
    }
    public static Stream<Arguments> divideTest(){
        return Stream.of(Arguments.of(50,25,2), Arguments.of(28,7,4));
    }

    @ParameterizedTest
    @MethodSource("plusTest")
    public void comparisonPlusTest(Integer num1, Integer num2, Integer result){
        Assertions.assertEquals(result,calculatorService.plus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("minusTest")
    public void comparisonMinusTest(Integer num1, Integer num2, Integer result){
        Assertions.assertEquals(result,calculatorService.minus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("multiplyTest")
    public void comparisonMultiplyTest(Integer num1, Integer num2, Integer result){
        Assertions.assertEquals(result,calculatorService.multiply(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("divideTest")
    public void comparisonDivideTest(Integer num1, Integer num2, Integer result){
        Assertions.assertEquals(result,calculatorService.divide(num1, num2));
    }
    @Test
    public void plusWithFirstNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, () -> calculatorService.divide(null, 1),"Параметр не заполнен");
    }

    @Test
    public void plusWithSecondNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.plus(2,null),"Параметр не заполнен");
    }
    @Test
    public void minusWithFirstNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.minus(null,3),"Параметр не заполнен");
    }
    @Test
    public void minusWithSecondNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.minus(4,null),"Параметр не заполнен");
    }
    @Test
    public void multiplyWithFirstNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.multiply(null,5),"Параметр не заполнен");
    }
    @Test
    public void multiplyWithSecondNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.multiply(6,null),"Параметр не заполнен");
    }
    @Test
    public void divideWithFirstNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.divide(null,7),"Параметр не заполнен");
    }
    @Test
    public void divideWithSecondNumberNullException(){
        CalculatorService calculatorService=new CalculatorService();
        assertThrows(NullPointerException.class, ()-> calculatorService.divide(8, null),"Параметр не заполнен");
    }
}
