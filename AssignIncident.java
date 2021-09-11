package serviceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClassServiceNow{
	@Test
	public void runAssignIncident() throws InterruptedException
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
		//driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		//driver.switchTo().frame("gsft_main");
		Thread.sleep(1000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-500)");
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text() = 'Open'])[1]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("existing incident",Keys.ENTER);
		//WebElement table = driver.findElement(By.id("incident_table"));
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> windowHandlesset = driver.getWindowHandles();
		List<String> windowhandleList = new ArrayList<String>(windowHandlesset);
		driver.switchTo().window(windowhandleList.get(1));
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("software",Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		//driver.switchTo().window(windowhandleList.get(0));
		Thread.sleep(2000);
		//driver.switchTo().frame("gsft_main");
		driver.switchTo().window(windowhandleList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.assigned_to")).click();
		Set<String> windowHandlesset1 = driver.getWindowHandles();
		List<String> windowhandleList1 = new ArrayList<String>(windowHandlesset1);
		driver.switchTo().window(windowhandleList1.get(1));
		WebElement name = driver.findElement(By.xpath("//a[@class='glide_ref_item_link']"));
		String text3 = name.getText();
		System.out.println(text3);
		name.click();
		driver.switchTo().window(windowhandleList1.get(0));
		driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getText();
		System.out.println(text);
		if(text.contains("Software"))
		{
			System.out.println("you have assigngroup to Software");
		}
		else
		{
			System.out.println("you have not assigngroup to Software");
		}
		
		String text2 = driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']")).getText();
		if(text3.equals(text2))
		{
			System.out.println("You have assign to "+text3+ "");
		}
		else
		{
			System.out.println("You have  not assign to "+text3+ "");
		}
		driver.findElement(By.xpath("(//button[@class='form_action_button  action_context btn btn-default'])[1]")).click();
		
	
	}
	
	

}
