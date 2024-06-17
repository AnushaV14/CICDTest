package com.epam.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.utilities.TestUtility;

public class TestOne {
		TestUtility test = new TestUtility();
	
	@Test
	public void testM() {
		System.out.println("test successful :"+	test.generateRandomNumber());
	}
	

	@Test
	public void testSubtract() {
		long a = 25;
		long b = 20;
		long expectedResult = 5;
		// long result = calculatorTest.sub(a, b);
		long result = a - b;
		//_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(expectedResult, result);
		//_test.pass("Subtraction is working as expected , result is :" + result);
	}

	@Test
	public void testMultiply() {
		long a = 10;
		long b = 25;
		long expectedResult = 250;
		long result = a * b;
		// long result = calculatorTest.mult(a, b);
		//_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(expectedResult, result);
		//_test.pass("Multiplication is working as expected , result is :" + result);
	}

}
