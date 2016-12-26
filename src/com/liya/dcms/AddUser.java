package com.liya.dcms;
/*
 * 作者：李娅
 * 时间：2016年11月30日
 */
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;


public class AddUser extends BaseTest{
	String url = "http://localhost:8032/MS/admin.php";
	@BeforeClass
	public void frontLogin() throws InterruptedException{
		webtest.open(url);
		Thread.sleep(1000);
		webtest.type("id=username","admin");
		webtest.type("id=password","admin");
		webtest.click("tag=button");
		Thread.sleep(3000);
	}
	@AfterClass
	public void exitLogin(){
		webtest.click("xpath=html/body/div[1]/div[2]/div[1]/div/div[2]/a");
		webtest.click("link=Sign Out");
	}
	@Test(dataProvider="user",dataProviderClass=NSDataProvicer.class)
	public void addUser(String username,String password,String email,String address,String phone) throws InterruptedException{
		webtest.click("link=用户管理");
		webtest.click("link=管理组 --- 添加");
		Thread.sleep(1000);
		webtest.type("name=username", username);
		webtest.type("name=userpwd", password);
		webtest.type("name=email",email);
		webtest.type("name=address",address);
		webtest.type("name=phone",phone);
		webtest.click("xpath=html/body/div[1]/div[2]/div[4]/div/div/form/p[6]/button[1]");
		Thread.sleep(2000);
		Assert.assertEquals( webtest.getTitle(),"Dcms v1.0");
	}

}
