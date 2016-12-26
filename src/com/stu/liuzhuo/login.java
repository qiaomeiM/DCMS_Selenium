/**
 * 功能：DCMS前台注册
 * 作者：刘镯
 * 时间：2016.11.22
 * */
package com.stu.liuzhuo;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class login extends BaseTest{
	
	int i  = 0;
	@Test(dataProvider="s1",dataProviderClass=NSDataProvicer.class)
	public void test1(String email,String pwd,String qpwd,String name) throws InterruptedException{
		
		webtest.open("http://localhost:8032/MS/");
		webtest.click("xpath=//*[@id='header_login']/span[2]/a");
		i=i+1;
		Thread.sleep(3000);
		webtest.getWindow(i);
		webtest.type("xpath=//*[@id='regSubmit']/table/tbody/tr[1]/td[2]/input",email);
		Thread.sleep(300);
		webtest.type("name=userpwd",pwd);
		Thread.sleep(300);
		webtest.type("name=ruserpwd",qpwd);
		Thread.sleep(300);
		webtest.type("name=username",name);
		String s = webtest.getText("xpath=//*[@id='regSubmit']/table/tbody/tr[5]/td[2]/img");
		webtest.type("name=verify",s);
		webtest.click("xpath=//*[@id='regSubmit']/table/tbody/tr[6]/td[2]/button");
		Thread.sleep(5000);
		String out = webtest.getText("xpath=//*[@id='header_login']/span[4]/a");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='header_login']/span[4]/a");
	}
	
}


