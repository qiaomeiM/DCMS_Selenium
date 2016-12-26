package com.stu.zhangxiaohe;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class login extends BaseTest{
	

	@Test(dataProvider="s3",dataProviderClass=NSDataProvicer.class)
		public void test2(String email,String userpwd1,String userpwd2,String name) throws Exception{
		if(webtest.isElementPresent("link=ÍË³ö")){
			webtest.click("link=ÍË³ö");
		} 
			webtest.open("http://localhost:8032/MS/");
			Thread.sleep(1000);
			webtest.click("xpath=/html/body/div[1]/div/span[2]/a");
			webtest.open("http://localhost:8032/MS/index.php/Login/reg/");
			webtest.type("name=email",email);
			webtest.type("name=userpwd",userpwd1);
			webtest.type("name=ruserpwd",userpwd2);
			webtest.type("name=username", name);
			webtest.click("xpath=/html/body/div[3]/div/form/table/tbody/tr[6]/td[2]/button");
			Thread.sleep(1000);
			
	}
	
	

}
