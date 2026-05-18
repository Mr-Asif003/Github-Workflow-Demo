package com.communityhub.demo;

import com.communityhub.demo.service.CalculatorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    CalculatorService calculatorService;
   @BeforeEach
   void setup(){
       calculatorService=new CalculatorService();
       System.out.println("test Setup");
   }
   @AfterEach
   void cleanUp(){
       System.out.println("cleanup done");
   }
   @DisplayName("Should add two positive number")
    @Test
    void shouldAddTwoNumbers(){
        int result=calculatorService.add(2,3);
         assertEquals(5,result);
    }
    @Test
    void shouldSubtractTwoNumber(){
        int result=calculatorService.subtract(5,8);
        boolean a=false;
        if(-3==result) a=true;
        assertEquals(-3,result);
        assertTrue(a);
    }
    @Test
    void shouldThrowExceptionWhenDividingByZero(){
        assertThrows(
                ArithmeticException.class,
                ()->calculatorService.divide(10,0)
        );
    }
}
