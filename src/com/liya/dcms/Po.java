package com.liya.dcms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webtest.core.BaseTest;

/**
 * 作者：李娅
 * 时间：2016年12月7日
 * 功能：页面元素及其操作方法类
**/
public class Po{
	WebDriver driver = null;
	@FindBy(name="username")
	public WebElement inputName;
	
	@FindBy(id="loginpwd")
	public WebElement inputPwd;
	
	@FindBy(xpath="//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input")
	public WebElement clickLogin;
	
	@FindBy(id="header_seach")
	public WebElement inputSearch;
	
	@FindBy(id="header_sub")
	public WebElement clickSearch;
	
	@FindBy(linkText="+���ﳵ")
	public WebElement clickShopping;
	
	@FindBy(linkText="���ﳵ")
	public WebElement enterShopping;
	
	@FindBy(className="in")
	public WebElement clickSelect;
	
	@FindBy(id="createForms")
	public WebElement clickSubmit;
	
	@FindBy(className="inp22")
	public WebElement clickAffirm;
	
	@FindBy(className="inp22")
	public WebElement clickAccomplish;
	
	@FindBy(linkText="�˳�")
	public WebElement clickExit;
	
	public Po(){
		System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	//��������֮��ҳ��
	public void open(String url){
		driver.get(url);
	}

	public void login(String username,String password){
		inputName.sendKeys(username);
		inputPwd.sendKeys(password);
		clickLogin.click();
	}

	public void orderOne(String dinnername){
		inputSearch.sendKeys(dinnername);
		clickSearch.click();
		clickShopping.click();
		enterShopping.click();
		clickSelect.click();
		clickSubmit.click();
		clickAffirm.click();
		clickAccomplish.click();
	}
	//操作方法之退出
	public void exit(){
		clickExit.click();
		driver.close();
	}
}
