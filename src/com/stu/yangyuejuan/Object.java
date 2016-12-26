/**
 * ��Ծ�� 
 * �����
 */
package com.stu.yangyuejuan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webtest.core.BaseTest;

public class Object extends BaseTest{
	//��̨
	//��¼�����û���
	@FindBy(id="username")
	public WebElement g;
	//��¼��������
	@FindBy(id="password")
	public WebElement inputUPwd;
	//��¼����SUBMIT
	@FindBy(xpath=".//*[@id='loginform']/p[3]/button")
	public WebElement SUBMIT;
	//��ʳ����
	@FindBy(linkText="��ʳ����")
	public WebElement CateManage;
	//��ʳ���������
	@FindBy(linkText="���")
	public WebElement CateAdd;
	//��ʳ��������ӡ�����ʳ����
	@FindBy(className="input-xxlarge")
	public WebElement CateName;
	//��ʳ��������ӡ�����ʳ�۸�
	@FindBy(name="price")
	public WebElement CatePrice;
	//��ʳ��������ӡ�������ʽ
	@FindBy(name="orderno")
	public WebElement CateOrderno;
	//��ʳ��������ӡ�����������
	@FindBy(id="selection2")
	public WebElement CateSelection;
	//��ʳ��������ӡ�����ʳͼƬ
	@FindBy(name="pic")
	public WebElement CatePic;
	//��ʳ��������ӡ�����ʳ����
	@FindBy(name="describe")
	public WebElement CateDescribe;
	//��ʳ��������ӡ���Submit
	@FindBy(xpath="html/body/div[1]/div[2]/div[4]/div/div/form/p[7]/button[1]")
	public WebElement CateSubmit;
	
	public Object(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
}
