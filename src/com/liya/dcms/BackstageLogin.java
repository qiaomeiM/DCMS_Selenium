package com.liya.dcms;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class BackstageLogin extends BaseTest{
	String url = "http://localhost:8032/MS/admin.php/Index/index";
	
	@Test(dataProvider="s3",dataProviderClass=NSDataProvicer.class)
	public void loginSecessful(String username,String password) throws InterruptedException{
			webtest.open(url);
			Thread.sleep(3000);
			webtest.type("id=username",username);
			webtest.type("id=password",password);
			webtest.click("className = btn btn-default btn-block");
			Thread.sleep(3000);
	}
	
	
}
