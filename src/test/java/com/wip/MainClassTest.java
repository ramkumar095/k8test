package com.wip;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainClassTest {

	MainClass mc;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("From SetupClass method");
	}

	@Before
	public void setUp() {
		System.out.println("From Setup method");
		mc = new MainClass();
	}

	@Test
	public void testAdd() {
		System.out.println("From add method");
		assertEquals(60, mc.add(20, 20, 20));
	}

	@Test
	public void testMultiply() {
		System.out.println("From multiply method");
		assertEquals(200, mc.multiply(10, 20));
	}

	@After
	public void tearDown() {
		System.out.println("From TEAR Down  method");
		mc = null;

	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("From tearDownClass method");
	}

}