
/**
 * author QiaoMei
 * function ·â×°µÇÂ¼Ä£¿é
 */
package com.stu.qiaomei;

import com.webtest.core.BaseTest;

public class LoginPre extends BaseTest{

	public void openPage(){
		webtest.open("http://localhost:8032/MS/index.php/Index/index");
	}
	public void signIn(String name,String pwd) throws InterruptedException{
		webtest.type("id=loginuser", name);
		webtest.type("id=loginpwd", pwd);
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		Thread.sleep(3000);
	}
	public void signOut(){
		webtest.click("link=ÍË³ö");
	}
	
}
