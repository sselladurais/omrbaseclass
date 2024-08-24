package org.junit;

import java.io.IOException;

import org.libgobal.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Product extends BaseClass{

	@BeforeClass
	public static void beforeClass (){
		browserLaunch();
		enterApplnUrl("https://omrbranch.com/");
		maximizeWindow();
		implictWait();
	}

	@Test
	public void productBooking() throws IOException, InterruptedException
	{
		
		WebElement txtEmail=findElementById("email");
		sendKeys(txtEmail,getCellData("hello",1,0));
		WebElement textpass = findElementById("pass");
		sendKeys(textpass,getCellData("hello",1,1));
		WebElement login = findelementByXpath(("(//button[@type='submit'])[1]"));
		javaScriptclick(login);
		WebElement welcome = findelementByXpath("//a[@data-testid='username']");
		String productTextname = elementGetText(welcome);
		//System.out.println(productTextname);
		//Assert.assertEquals("Welcome SELLA",productTextname);
		Assert.assertEquals("Verify", "Welcome SELLA", productTextname);
		//Assert.assertEquals("verify after login", "Welcome SELLA", productTextname);
	}
}
