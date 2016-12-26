package com.stu.liuzhuo;
/**
 * 
 * @author LiuZhuo
 * 
 * */
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class BackAdduser extends BaseTest{
	String url = "http://localhost:8032/MS/admin.php/Index/index";

	@BeforeClass
	public void Login() throws InterruptedException{
		webtest.open(url);
		webtest.type("id=username","admin");
		webtest.type("id=password","admin");
		webtest.click("tag=button");
		
		//Thread.sleep(8000);

	}
	@Test(dataProvider="s6",dataProviderClass=NSDataProvicer.class)
	public void addUserSuccess(String Name,String npwd,String Email,String address,String tel) throws InterruptedException{
			
		webtest.click("link=用户管理");
		webtest.click("link=管理组 --- 添加");
		Thread.sleep(10000);
		webtest.type("name=username",Name);
		webtest.type("name=userpwd",npwd);
		webtest.type("name=email",Email);
		webtest.type("name=address",address);
		webtest.type("name=phone",tel);
		
		webtest.click("tag=button");
		
		String pageTitle=webtest.getTitle(); 
		Assert.assertEquals(pageTitle,"Dcms v1.0");
		Thread.sleep(5000);
	
	}

	@AfterClass
	public void singOut() throws InterruptedException{
		webtest.click("link=Hi, admin!");
		webtest.click("link=Sign Out");
	//	Thread.sleep(7000);
	}
}
