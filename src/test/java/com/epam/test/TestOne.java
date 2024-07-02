package com.epam.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestOne {
	
	protected ExtentReports _extent;
	protected ExtentTest _test;

	@BeforeTest
	public void setUp(ITestContext iTest ) {
		System.out.println("Test Method Execution started: ");
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/target/Reports/extentReport.html");
		_extent = new ExtentReports();
		_extent.attachReporter(htmlReporter);
		_test = _extent.createTest(iTest.getClass().getName());

	}
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("Test Method Execution started: ");
		
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Test Method Execution Ended: ");
		
	}
	
	@AfterTest
	public void tearDown() {
		_extent.flush();
		
	}

	@DataProvider(name = "testdata")
	public Object[][] provideTestData() {
		return new Object[][] { { 5, 3, 8 }, // Test 1: Addition
				{ 10, 4, 6 }, // Test 2: Subtraction
				// Add more test data as needed
		};
	}

	@Test(dataProvider = "testdata")
	public void testAddition(int a, int b, int expectedSum) {
		int result = a + b;
		_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(result, expectedSum, "Addition failed");
		_test.pass("Addition is working as expected , result is :" + result);
	}

	@Test(groups = { "positive" })
	public void testAdd() {
		long a = 15;
		long b = 20;
		int expectedResult = 35;
		long result = a + b;
		// long result = calculatorTest.sum(a, b);
		// Assert
		_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(expectedResult, result);
		_test.pass("Addition is working as expected , result is :" + result);
	}

	@Test(groups = { "positive" })
	public void testSubtract() {
		long a = 25;
		long b = 20;
		long expectedResult = 5;
		// long result = calculatorTest.sub(a, b);
		long result = a - b;
		_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(expectedResult, result);
		_test.pass("Subtraction is working as expected , result is :" + result);
	}

	@Test(groups = { "positive" })
	public void testMultiply() {
		long a = 10;
		long b = 25;
		long expectedResult = 250;
		long result = a * b;
		// long result = calculatorTest.mult(a, b);
		_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(expectedResult, result);
		_test.pass("Multiplication is working as expected , result is :" + result);
	}

	@Test(groups = { "positive" })
	public void testDivide() {
		double a = 56;
		double b = 10;
		double expectedResult = 5.6;
		double result = a / b;
		// double result = calculatorTest.div(a, b);
		_test.info("Input values are :" + a + " , " + b);
		Assert.assertEquals(expectedResult, result, 0.00005);
		_test.pass("Division is working as expected , result is :" + result);

	}

	@Test(expectedExceptions = IllegalArgumentException.class, groups = { "negative" })
	public void testDivideByZero() {
		int a = 15;
		int b = 0;
		_test.info("Input values are :" + a + " , " + b);

		int c = a / b;
		_test.fail("Division is not working as expected , result is :" + c);
		System.out.println("result:" + c);
		// calculatorTest.div(a, b);
	}

	@Test(groups = { "positive" })
	public void testSquareRoot() {
		int a = 9;
		double expectedResult = 3.0;
		double result = Math.sqrt(a);
		_test.info("Input value is :" + a );
		Assert.assertEquals(expectedResult, result);
		_test.pass("Square root is working as expected , result is :" + result);
	}

	@Test(groups = { "negative" }, expectedExceptions = IllegalArgumentException.class)
	public void testSquareRootWithNegativeVal() {
		int a = -49;
		int expectedResult = -7;
		double result = Math.sqrt(a);
		_test.info("Input value is :" + a );
		Assert.assertEquals(expectedResult, result);
		_test.fail("Square root is not working as expected , result is :" + result);
		
	}

}
