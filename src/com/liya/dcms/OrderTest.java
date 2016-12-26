package com.liya.dcms;
/*
 *作者：李娅
 *时间:2016年11月14日
 *功能：一次登录买多个菜
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class OrderTest extends BaseTest{
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
	@Test(dataProvider="order",dataProviderClass=NSDataProvicer.class)
	public void orderDinner(String dinnername) throws InterruptedException{
		webtest.type("id=header_seach",dinnername );
		webtest.click("id=header_sub");
		webtest.click("link=+购物车");
		Thread.sleep(1000);
		webtest.click("link=购物车");
		webtest.click("class=in");
		webtest.click("id=createForms");
		Thread.sleep(1000);
		webtest.click("class=inp22");
		Thread.sleep(1000);
		webtest.click("class=inp22");
		Thread.sleep(2000);
	}
	@AfterClass
	public void exitLogin(){
		webtest.click("link=退出");
	}
}
