/**
 * author QiaoMei
 * function ��¼_Excel
 */
package com.stu.qiaomei;

import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class LoginExcel extends BaseTest{
	//����Excel����������������е�¼
	@Test(dataProvider="s2",dataProviderClass=NSDataProvicer.class)
		public void login2(String name,String pwd) throws InterruptedException{
		webtest.open("http://localhost:8032/MS/index.php/Index/index");
		webtest.type("id=loginuser", name);
		webtest.type("id=loginpwd", pwd);
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		Thread.sleep(3000);
		webtest.click("link=�˳�");
	}
}
