
/**
 * Created by likuo on 2016/11/22
 */
package com.stu.likuo;

import org.testng.annotations.Test;
import com.webtest.dataprovider.NSDataProvicer;

public class login3 extends base {
	
	@Test(dataProvider="s6",dataProviderClass=NSDataProvicer.class)
	public void test1(String type) throws InterruptedException{
		login();//��¼��̨
		webtest.click("link=�������");
		webtest.click("link=һ������ --- �б�");
		Thread.sleep(3000);
		webtest.type("xpath=/html/body/div[1]/div[2]/div[4]/div/div/div[2]/label/input", type);
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/table/tbody/tr/td[6]/a/span");
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/table/tbody/tr/td[6]/a/span");
		webtest.getAlertTest();
		logout();//�˳���̨		
		
	}
	

}
