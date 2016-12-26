/**
 * author QiaoMei
 * function 添加评论页面对象
 */
package com.stu.qiaomei;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommentPage {
	//登录用户名
	@FindBy(id="loginuser")
	public WebElement inputUName;
	//登录密码
	@FindBy(id="loginpwd")
	public WebElement inputUPwd;
	//提交按钮
	@FindBy(xpath="//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input")
	public WebElement submit;
	//退出
	@FindBy(linkText="退出")
	public WebElement linkQuit;
	//选择图片
	@FindBy(xpath="//*[@id='nav_cen']/div[8]/a/img")
	public WebElement selectImg;
	//评论文本框
	@FindBy(name="content")
	public WebElement commentText;
	//评论提交按钮
	@FindBy(xpath="//*[@id='addEva']/input[2]")
	public WebElement commentBtn;
}
