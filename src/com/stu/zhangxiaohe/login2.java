package com.stu.zhangxiaohe;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class login2 extends BaseTest {
	
	@Test(dataProvider="s1",dataProviderClass=NSDataProvicer.class)
		public void test2(String username,String userpwd) throws Exception{
			if(webtest.isElementPresent("link=ÍË³ö")){
				webtest.click("link=ÍË³ö");
			}
			webtest.open("http://localhost:8032/MS/");
			Thread.sleep(2000);
			webtest.type("name=username",username);
			webtest.type("name=userpwd2",userpwd);
			webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/form/table/tbody/tr[5]/td/input");
			check.verifyText("xpath=/html/body/div[1]/div/span[1]/a", username);
			Thread.sleep(2000);
	}
	

}

