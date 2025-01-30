package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);		
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement numTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtcpassword;

@FindBy(xpath="//label[normalize-space()='Yes']")
WebElement chkdSuscribe;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

@FindBy(xpath="//a[normalize-space()='Continue']")
WebElement nxtbtnContinue;

public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastname.sendKeys(lname);
}

public void setEmail(String email) {
	txtemail.sendKeys(email);
}

public void setTelephone(String telephone)
{
	numTelephone.sendKeys(telephone);
}

public void setPassword(String pwd) {
	txtpassword.sendKeys(pwd);
}

public void setConfirmPassword(String cpwd) {
	txtcpassword.sendKeys(cpwd);
}

public void clickSubscribe() {
	chkdSuscribe.click();
}
public void setPrivacyPolicy() {
	chkPolicy.click();
}

public void clickContinue() {
	btnContinue.click();
}			

public String getConfirmationMsg()
{
	try {
		return (msgConfirmation.getText());
	} catch(Exception e) {
		return(e.getMessage());
	}
}

public void clickbnxtbtnContinue()
{
	nxtbtnContinue.click();	
}

}
