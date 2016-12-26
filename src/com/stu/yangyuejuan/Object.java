/**
 * 杨跃娟 
 * 对象库
 */
package com.stu.yangyuejuan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webtest.core.BaseTest;

public class Object extends BaseTest{
	//后台
	//登录——用户名
	@FindBy(id="username")
	public WebElement g;
	//登录——密码
	@FindBy(id="password")
	public WebElement inputUPwd;
	//登录——SUBMIT
	@FindBy(xpath=".//*[@id='loginform']/p[3]/button")
	public WebElement SUBMIT;
	//美食管理
	@FindBy(linkText="美食管理")
	public WebElement CateManage;
	//美食管理——添加
	@FindBy(linkText="添加")
	public WebElement CateAdd;
	//美食管理——添加——美食名称
	@FindBy(className="input-xxlarge")
	public WebElement CateName;
	//美食管理——添加——美食价格
	@FindBy(name="price")
	public WebElement CatePrice;
	//美食管理——添加——排序方式
	@FindBy(name="orderno")
	public WebElement CateOrderno;
	//美食管理——添加——所属分类
	@FindBy(id="selection2")
	public WebElement CateSelection;
	//美食管理——添加——美食图片
	@FindBy(name="pic")
	public WebElement CatePic;
	//美食管理——添加——美食描述
	@FindBy(name="describe")
	public WebElement CateDescribe;
	//美食管理——添加——Submit
	@FindBy(xpath="html/body/div[1]/div[2]/div[4]/div/div/form/p[7]/button[1]")
	public WebElement CateSubmit;
	
	public Object(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
}
