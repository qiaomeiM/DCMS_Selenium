package com.stu.zhangxiaohe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class po {
	WebDriver driver = null;
	@FindBy(id="username")
	public WebElement inputName;
	
	@FindBy(id="password")
	public WebElement inputPwd;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/form/p[3]/button")
	public WebElement clickLogin;
	
	@FindBy(linkText="�������")
	public WebElement clickDisplay;
	
	@FindBy(linkText="һ������--�б�")
	public WebElement clickListo;
	
	@FindBy(linkText="һ�����--���")
	public WebElement clickAddo;
	
	@FindBy(linkText="��������--�б�")
	public WebElement clickListt;
	
	@FindBy(linkText="��������--���")
	public WebElement clickAddt;
	
	public void Po(){
		System.setProperty("webdriver.firefox.bin", "D:\\huohu\\firefox.exe");
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
		public void open(String url){
			driver.get(url);
		}

		public void login(String username,String password){
			inputName.sendKeys(username);
			inputPwd.sendKeys(password);
			clickLogin.click();
		}
		public void orderOne(String dinnername){
			clickDisplay.click();
			clickListo.click();
			clickAddo.click();
			clickListt.click();
			clickAddt.click();
			
		}
		
	}

	
	


