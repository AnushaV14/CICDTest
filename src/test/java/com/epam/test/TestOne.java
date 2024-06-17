package com.epam.test;

import org.testng.annotations.Test;

import com.epam.utilities.TestUtility;

public class TestOne {
		TestUtility test = new TestUtility();
	
	@Test
	public void testM() {
		System.out.println("test successful :"+	test.generateRandomNumber());
	}
}
