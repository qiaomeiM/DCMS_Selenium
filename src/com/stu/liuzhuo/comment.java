/**
 * 功能：前台美食评论 
 * 作者：刘镯
 * 时间：2016.11.22
 * */
package com.stu.liuzhuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class comment extends BaseTest{

	@BeforeClass
	public void login() throws InterruptedException{
		webtest.open("http://localhost:8032/MS/");
		Thread.sleep(3000);
		webtest.type("id=loginuser", "zhangjiaming");
		webtest.type("id=loginpwd", "lzjm12345");
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		Thread.sleep(5000);
	}
	
	@Test(dataProvider="s5",dataProviderClass=NSDataProvicer.class)
	public void foodComment(String scomment) throws InterruptedException{
		webtest.click("xpath=//*[@id='xinxiu_img']/div[1]/a/img");
		Thread.sleep(3000);
		webtest.type("name=content",scomment);
		webtest.click("xpath=//*[@id='addEva']/input[2]");
	}
	
	@AfterClass
	public void logout() throws InterruptedException{
		
		webtest.click("class=clearMsg");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='header_login']/span[4]/a");
	}
}
