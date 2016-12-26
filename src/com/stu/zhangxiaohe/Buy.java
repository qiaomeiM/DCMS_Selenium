package com.stu.zhangxiaohe;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Buy extends BaseTest{
	
	@Test
	public void test1 ()throws Exception{
		
		webtest.open("http://localhost:8032/MS/");
		Thread.sleep(2000);
		webtest.type("name=username","zhang");
		webtest.type("name=userpwd2","123456");
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/form/table/tbody/tr[5]/td/input");
		webtest.open("http://localhost:8032/MS/index.php/Index/index");
		webtest.click("xpath=/html/body/div[1]/div/span[3]/a");
		webtest.click("name=input[]");
		webtest.click("id=createForms");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[7]/td/input[1]");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[6]/td/input");
		
		

	}
	
	

}
