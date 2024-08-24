package JavaScriptConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptProgram {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		WebElement username = driver.findElement(By.cssSelector("#email"));
		executor.executeScript("arguments[0].setAttribute('value','vignesh')", username);
		WebElement password = driver.findElement(By.cssSelector("#pass"));
		executor.executeScript("arguments[0].setAttribute('value','pass123')", password);
        Object username1 =executor.executeScript("return arguments[0].getAttribute('value')", username);
		System.out.println(username1);
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		executor.executeScript("arguments[2].click()", username,password,login);
		WebElement errormessage = driver.findElement(By.cssSelector("._9ay7"));
		Object gettext = executor.executeScript("return arguments[0].textcontent", errormessage);
		System.out.println(gettext);
		
	}

}
