/**
 * Created by likuo on 2016/11/23
 */

package com.stu.likuo;

import org.testng.annotations.Test;
import com.webtest.dataprovider.NSDataProvicer;

public class add extends base {

	@Test(dataProvider="s8",dataProviderClass=NSDataProvicer.class)
	public void test2(String bname,String orderno,String text) throws InterruptedException{
		login();
		webtest.click("link=分类管理");
		webtest.click("link=一级分类 --- 添加");
		Thread.sleep(5000);
		webtest.type("name=bname",bname);
		webtest.type("name=orderno",orderno);
		webtest.type("name=pic", "F:\\FFOutput\\123.png");
		webtest.type("xpath=/html/body/div[1]/div[2]/div[4]/div/div/form/p[4]/span/textarea",text);
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/form/p[5]/button[1]");
		logout();
	}
	

}
