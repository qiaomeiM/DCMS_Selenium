package com.liya.dcms;
import org.testng.Assert;
/*
 * 作者
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;


public class FrontdeskRegiter extends BaseTest {
	String url = "http://localhost:8032/MS/";
	public int i = 0;
	
//	@BeforeClass
//	public void frontLogin() throws InterruptedException{
//		webtest.open(url);
//	}
//	@AfterClass
//	public void exitLogin(){
//		webtest.click("link=�˳�");
//	}
	@Test(dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void registerSecessful(String email,String passwrod,String rpwd,String nickname) throws InterruptedException{
			i=i+1;
			webtest.open(url);
			Thread.sleep(2000);
			webtest.click("xpath=//*[@id='header_login']/span[2]/a");
			Thread.sleep(2000);
			webtest.getWindow(i);
			webtest.type("name=email", email);
			webtest.type("name=userpwd", passwrod);
			webtest.type("name=ruserpwd", rpwd);
			webtest.type("name=username", nickname);
			webtest.click("xpath=//*[@id='regSubmit']/table/tbody/tr[6]/td[2]/button");
			Thread.sleep(4000);
			webtest.click("link=�˳�");
	}
	
	/*@Test(dataProvider="s5",dataProviderClass=NSDataProvicer.class)
	public void registerFalse(String email,String passwrod,String rpwd,String nickname
) throws InterruptedException{
//			webtest.open(url);
//			Thread.sleep(2000);
//			webtest.click("xpath=//*[@id='header_login']/span[2]/a");
//			Thread.sleep(2000);
//			webtest.type("xpath=//*[@id='regSubmit']/table/tbody/tr[1]/td[2]/input", "liya_123@123.com");
			webtest.open(url);
			webtest.type("name=email", email);
			webtest.type("name=userpwd", passwrod);
			webtest.type("name=ruserpwd", rpwd);
			webtest.type("name=username", nickname);
			webtest.click("xpath=//*[@id='regSubmit']/table/tbody/tr[6]/td[2]/button");
			Thread.sleep(3000);
			Assert.assertTrue(webtest.getHtmlSource().concat("�˳�"), true);
	}*/
}
