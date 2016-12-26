/**
 * 功能：DCMS下订单
 * 作者：刘镯
 * 时间2016.11.15
 * */
package com.stu.liuzhuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class order extends BaseTest {
	
	@BeforeClass
	public void login() throws InterruptedException{
		webtest.open("http://localhost:8032/MS/");
		Thread.sleep(3000);
		webtest.type("id=loginuser", "zhangjiaming");
		webtest.type("id=loginpwd", "lzjm12345");
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		Thread.sleep(5000);
	}

	@Test(dataProvider="s3",dataProviderClass=NSDataProvicer.class,priority=0)
	public void order(String name) throws InterruptedException{
		webtest.type("id=header_seach",name);
		webtest.click("id=header_sub");
		Thread.sleep(1000);
		webtest.click("class=addCarts");
		Thread.sleep(1000);
		
		
	}
	@Test(priority=1)
	public void order02() throws InterruptedException{
		webtest.click("xpath=//*[@id='header_login']/span[3]/a");
		Thread.sleep(3000);
		webtest.click("class=all");
		webtest.click("id=createForms");
		webtest.click("class=inp22");
		
		webtest.click("class=inp22");
	}
	@AfterClass
	public void logout() throws InterruptedException{
		
		webtest.click("class=clearMsg");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='header_login']/span[4]/a");
	}
}
