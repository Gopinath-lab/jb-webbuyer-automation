package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.basepage.BasePage;

public class WebElements extends BasePage {
	
	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	private WebElement emailpasslogin;
	
	public WebElement getEmailpasslogin() {
		return emailpasslogin;
	}

	public void setEmailpasslogin(WebElement emailpasslogin) {
		this.emailpasslogin = emailpasslogin;
	}

	public WebElement getUname() {
		return uname;
	}

	public void setUname(WebElement uname) {
		this.uname = uname;
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement uname;
	
	public WebElements(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

}
