package com.liya.dcms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

/*
 * 作者
 */
public class OrderTest1 extends BaseTest {
	String url = "http://localhost:8032/MS/";

	@BeforeClass
	public void frontLogin() throws InterruptedException{
		webtest.open(url);
		Thread.sleep(1000);
		webtest.type("name=username", "Tom");
		webtest.type("id=loginpwd","123456" );
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		Thread.sleep(3000);
	}
	@Test(priority = 0,dataProvider="order",dataProviderClass=NSDataProvicer.class)
	public void shoppingCart(String dinnername) throws InterruptedException{
		webtest.type("id=header_seach",dinnername );
		webtest.click("id=header_sub");
		webtest.click("link=+���ﳵ");
		Thread.sleep(1000);
		
	}
	@Test(priority = 1)
	public void orderDinner() throws InterruptedException{
		webtest.click("link=���ﳵ");
		webtest.click("class=all");
		webtest.click("id=createForms");
		Thread.sleep(1000);
		webtest.click("class=inp22");
		Thread.sleep(1000);
		webtest.click("class=inp22");
		Thread.sleep(3000);
	}
	@AfterClass
	public void exitLogin(){
		webtest.click("link=�˳�");
	}

}
