/**
 * Created by likuo on 2016/11/25
 */

package com.stu.likuo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class login2  extends BaseTest{
	@Test(dataProvider="s1",dataProviderClass=NSDataProvicer.class)
	public void test(String name,String password )throws InterruptedException{
		webtest.open("http://localhost:8032/MS/");
		Thread.sleep(5000);
		webtest.type("id=loginuser",name);
		webtest.type("id=loginpwd",password);
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/form/table/tbody/tr[5]/td/input");
		Thread.sleep(2000);
		webtest.click("xpath=/html/body/div[1]/div/span[4]/a");
		
		
	}
}

