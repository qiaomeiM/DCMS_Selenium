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
	@FindBy(id="username")//��̨��¼�û���
	public WebElement roleusername;
	@FindBy(id="password")//��̨��¼����
	public WebElement rolepassword;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/form/p[3]/button")//��̨��¼SUBMIT
	public WebElement roleSUBMIT;
	@FindBy(xpath="linkText=�������")//�������
	public WebElement rolefenlei;
	@FindBy(linkText="һ������ --- ���")//һ������ --- ���
	public WebElement roleadd1;
	@FindBy(linkText="�������� --- ���")//�������� --- ���
	public WebElement roleadd2;
	@FindBy(name="bname")//һ������ --- ����µķ�������
	public WebElement rolebname;
	@FindBy(name="orderno")//һ������ --- ����µ�������
	public WebElement roleorderno;
	@FindBy(name="pic")//һ������ --- ����µķ���ͼ��
	public WebElement rolepic;
	@FindBy(name="describe")//һ������ --- ����µ�����
	public WebElement roledescribe;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[4]/div/div/form/p[5]/button[1]")//һ������ --- ����µ�Submit
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
	//��������֮��ҳ��
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
	//��������֮ǰ̨�˳�
		public void exit(){
			roletable.click();
			roletui.click();
			driver.close();
		}
	
	
	
	
	
	

}
