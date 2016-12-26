/**
 * author QiaoMei
 * function ²âÊÔ½á¹û½ØÆÁ
 */
package com.stu.qiaomei;

import java.io.IOException;

import org.testng.annotations.Test;


import com.webtest.core.BaseTest;

public class ListenerTest extends BaseTest{
		@Test
		public void test() throws InterruptedException, IOException{
			webtest.open("file:///D:/Eclipse/DCMS1/test-output/TestResult.html");

			Thread.sleep(5000);
			webtest.cutScreen();
		}
		 
		 
	 
		
	
	
}
