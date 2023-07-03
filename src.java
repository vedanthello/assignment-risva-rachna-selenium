import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentRisvaRachnaSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();

		// search for Wrist Watches in search box
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Wrist Watches");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		// Select 'Analogue' under Display
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement analogueCheckbox = driver.findElement(By.xpath("//li[@aria-label='Analogue']//input"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", analogueCheckbox);
		
		// Select 'Leather' under Band Material
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement leatherCheckbox = driver.findElement(By.xpath("//li[@aria-label='Leather']//input"));
		executor.executeScript("arguments[0].click();", leatherCheckbox);
		
		// Select 'Titan' under Brand
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement titanCheckbox = driver.findElement(By.xpath("//li[@aria-label='Titan']//input"));
		executor.executeScript("arguments[0].click();", titanCheckbox);
		
		// Select '25% Off or more' under Discount
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='25% Off or more']")).click();
		
		// Get the name of fifth element from search result
		Thread.sleep(10000);
		WebElement fifthElement = driver.findElements(By.xpath("//div[contains(@data-cel-widget, 'search_result_')]")).get(5);
		WebElement nameOfFifthElement = fifthElement.findElement(By.xpath(".//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		System.out.println("Fifth element name - " + nameOfFifthElement.getText());
		
		driver.close();

	}

}
