/**
 * 杨跃娟 
 * 老师代码
 */
package com.stu.yangyuejuan;

import static org.testng.Assert.*;

import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webtest.dataprovider.NSDataProvicer;



public class CalculatorTest {

//	@BeforeSuite
//	public void addListener(ITestContext context)
//			throws Exception {
//		TestRunner runner = (TestRunner) context;
//	    runner.addListener(new WebTestListener());
//	   
//	}
	@Test(dataProvider="s1",dataProviderClass=NSDataProvicer.class,description="测试减法")
	public void testSub(String n1,String n2,String n3) {
		Calculator cal = new Calculator();
		assertEquals(cal.sub(Integer.parseInt(n1), Integer.parseInt(n2)), Integer.parseInt(n3));
	}

	@Test(description="测试加法")
	public void testAdd1() {
		Calculator cal = new Calculator();
		assertEquals(cal.add(1, 3), 2);

	}



}
