package serviceNow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClassServiceNow{
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void runUpdateIIncident() throws InterruptedException
	{
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev102686.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().frame(0);
		//driver.findElement(By.linkText("Sign up and Start Building")).click();
		driver.switchTo().frame("gsft_main");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("8eah3nLbUMID");
		driver.findElement(By.xpath("//button[@name='not_important']")).click();
		driver.findElement(By.id("filter")).sendKeys("Incident" ,Keys.ENTER);*/
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		driver.switchTo().frame("gsft_main");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("existing incident",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select urgencyelement = new Select(urgency);
		List<WebElement> urgencyopt = urgencyelement.getOptions();
		String text = urgencyopt.get(0).getText();
		urgencyopt.get(0).click();
		System.out.println(text);
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select stateopt = new Select(state);
		List<WebElement> statelist = stateopt.getOptions();
		String text2 = statelist.get(1).getText();
		statelist.get(1).click();
		System.out.println(text2);
		if(text2.contains("progress"))
		{
			System.out.println("you clicked progress");
		}
		else
		{
			System.out.println("you have not clicked progress");
		}
		driver.findElement(By.xpath("//button[@name='not_important']")).click();
		
		
	}

}
