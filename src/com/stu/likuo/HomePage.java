/**
 * Created by likuo on 2016/12/05
 */

package com.stu.likuo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver = null;
	@FindBy(id="username")//后台登录用户名
	public WebElement roleusername;
	@FindBy(id="password")//后台登录密码
	public WebElement rolepassword;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/form/p[3]/button")//后台登录SUBMIT
	public WebElement roleSUBMIT;
	@FindBy(xpath="linkText=分类管理")//分类管理
	public WebElement rolefenlei;
	@FindBy(linkText="一级分类 --- 添加")//一级分类 --- 添加
	public WebElement roleadd1;
	@FindBy(linkText="二级分类 --- 添加")//二级分类 --- 添加
	public WebElement roleadd2;
	@FindBy(name="bname")//一级分类 --- 添加下的分类名称
	public WebElement rolebname;
	@FindBy(name="orderno")//一级分类 --- 添加下的排序编号
	public WebElement roleorderno;
	@FindBy(name="pic")//一级分类 --- 添加下的分类图标
	public WebElement rolepic;
	@FindBy(name="describe")//一级分类 --- 添加下的描述
	public WebElement roledescribe;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[4]/div/div/form/p[5]/button[1]")//一级分类 --- 添加下的Submit
	public WebElement roleSubmit;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/div[2]/a")
	public WebElement roleadmin;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/div[2]/a")
	public WebElement roletable;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[3]")
	public WebElement roletui;
	public HomePage(){
		System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	//操作方法之打开页面
	public void open(String url){
		driver.get(url);
	}
	public void login(String username,String password){
		roleusername.sendKeys(username);
		rolepassword.sendKeys(password);
		roleSUBMIT.click();
		}
	public void fenlei(String bname,String orderno,String pic,String describe){
		rolefenlei.click();
		roleadd1.click();
		rolebname.sendKeys(bname);
		roleorderno.sendKeys(orderno);
		rolepic.sendKeys(pic);
		roledescribe.sendKeys(describe);
		roleSubmit.click();
	}
	//操作方法之前台退出
		public void exit(){
			roletable.click();
			roletui.click();
			driver.close();
		}
	
	
	
	
	
	

}
