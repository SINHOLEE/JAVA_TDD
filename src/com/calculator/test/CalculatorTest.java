package com.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.calculator.Calculator;

class CalculatorTest {

	@Test
	void testSum() {
        Calculator calculator = new Calculator();
        assertEquals(30, calculator.sum(10, 20));
	}

}
