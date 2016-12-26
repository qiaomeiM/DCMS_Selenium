/**
 * author QiaoMei
 * function ×¢²á_QTP
 */
package com.stu.qiaomei;

import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class Register extends BaseTest{
	
	int i=1;
		
	@Test(dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void register(String email,String pwd,String repwd,String name) throws Exception{
		//ÓÃ»§×¢²á
		webtest.open("http://localhost:8032/MS");
		webtest.click("link=×¢²á");
		Thread.sleep(3000);
		webtest.getWindow(i);
		i++;
		webtest.type("name=email",email);
		webtest.type("name=userpwd",pwd);
		webtest.type("name=ruserpwd",repwd);
		webtest.type("name=username",name);
		webtest.click("class=butAdd");
		check.verifyText("id=header_login", name);
		webtest.click("link=ÍË³ö");

	}
}
