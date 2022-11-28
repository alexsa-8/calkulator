package com.skypro.calkulator;

import com.skypro.calkulator.exception.IllegalNumberException;
import com.skypro.calkulator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> calculatorService.plus(null, 1));
    }
    @Test
    public void plusWithSecondNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.plus(2,null));
    }
    @Test
    public void minusWithFirstNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.minus(null,3));
    }
    @Test
    public void minusWithSecondNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.minus(4,null));
    }
    @Test
    public void multiplyWithFirstNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.multiply(null,5));
    }
    @Test
    public void multiplyWithSecondNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.multiply(6,null));
    }
    @Test
    public void divideWithFirstNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.divide(null,7));
    }
    @Test
    public void divideWithSecondNumberNullException(){
        assertThrows(IllegalArgumentException.class, ()-> calculatorService.divide(8,null));
    }
    @Test
    public void divisionByZeroException(){
        assertThrows(IllegalNumberException.class, ()-> calculatorService.divide(5,0));
    }


}
