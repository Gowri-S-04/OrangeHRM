package com.orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localdriver;

	public LoginPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	WebElement username;
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	WebElement login;
	@FindBy(xpath = "//*[@id=\"welcome\"]")
	WebElement welcome;
	@FindBy(xpath = "//*[@id=\"welcome-menu\"]/ul/li[3]/a")
	WebElement logout;

	public void userName(String uname) {
		username.sendKeys(uname);
	}

	public void passWord(String pwd) {
		password.sendKeys(pwd);
	}

	public void login() {
		login.click();
	}

	public void welcome() {
		welcome.click();
	}

	public void logout() {
		logout.click();
	}
}
