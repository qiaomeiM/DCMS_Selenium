/**
 * Created by likuo on 2016/11/23
 */
package com.stu.likuo;

import org.testng.annotations.Test;
import com.webtest.dataprovider.NSDataProvicer;

public class change extends base{

	@Test(dataProvider="s7",dataProviderClass=NSDataProvicer.class)
	public void test2(String input) throws InterruptedException{
		login();
		webtest.click("link=美食管理");
		webtest.click("link=列表");
		Thread.sleep(5000);
		webtest.type("xpath=/html/body/div[1]/div[2]/div[4]/div/div/div[2]/label/input", input);
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/table/tbody/tr/td[9]/a/span");
		webtest.typeAndClear("name=price","20");
		logout();
		}
	

}
