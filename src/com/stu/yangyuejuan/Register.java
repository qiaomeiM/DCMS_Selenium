/**
 * ÑîÔ¾¾ê 
 * Ç°Ì¨×¢²á
 */ 
package com.stu.yangyuejuan;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class Register extends BaseTest{
	int i = 0;
	String url = "http://localhost:8032/MS/index.php/Index/index/";
	@Test(dataProvider="s2",dataProviderClass=NSDataProvicer.class)
	public void t(String email,String userpwd,String ruserpwd,String username) throws Exception {
		i++;
		System.out.println(i);
		webtest.open(url);
		webtest.click("link=×¢²á");
		Thread.sleep(3000);
		webtest.getWindow(i);
		webtest.type("name=email", email);
		webtest.type("name=userpwd", userpwd);
		webtest.type("name=ruserpwd", ruserpwd);
		webtest.type("name=username", username);
		webtest.click("xpath=/html/body/div[3]/div/form/table/tbody/tr[6]/td[2]/button");
		Thread.sleep(5000);
		webtest.click("link=ÍË³ö");
	}
}




