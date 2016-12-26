/**
 * author QiaoMei
 * function �������ҳ�����
 */
package com.stu.qiaomei;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommentPage {
	//��¼�û���
	@FindBy(id="loginuser")
	public WebElement inputUName;
	//��¼����
	@FindBy(id="loginpwd")
	public WebElement inputUPwd;
	//�ύ��ť
	@FindBy(xpath="//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input")
	public WebElement submit;
	//�˳�
	@FindBy(linkText="�˳�")
	public WebElement linkQuit;
	//ѡ��ͼƬ
	@FindBy(xpath="//*[@id='nav_cen']/div[8]/a/img")
	public WebElement selectImg;
	//�����ı���
	@FindBy(name="content")
	public WebElement commentText;
	//�����ύ��ť
	@FindBy(xpath="//*[@id='addEva']/input[2]")
	public WebElement commentBtn;
}
