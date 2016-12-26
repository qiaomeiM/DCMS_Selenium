/**
 * Created by likuo on 2016/12/01
 */

package com.stu.likuo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class register extends BaseTest{
	@Test(dataProvider="s3",dataProviderClass=NSDataProvicer.class)
	public void test(String email,String password,String password2,String username) throws InterruptedException{
		
		if(webtest.isElementPresent("link=ÍË³ö")){
			webtest.click("link=ÍË³ö");
		}

		webtest.open("http://localhost:8032/MS/");
		
		Thread.sleep(2000);
		webtest.click("xpath=/html/body/div[1]/div/span[2]/a");
		webtest.open("http://localhost:8032/MS/index.php/Login/reg/");
		Thread.sleep(2000);
		webtest.type("name=email",email);
		webtest.type("name=userpwd",password);
		webtest.type("name=ruserpwd",password2);
		webtest.type("name=username",username);
		webtest.type("name=verify","1111");
		webtest.click("xpath=/html/body/div[3]/div/form/table/tbody/tr[6]/td[2]/button");
		Thread.sleep(2000);
		
		
		
		
	}

}
