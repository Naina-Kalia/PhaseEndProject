package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.com.driver", "chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
driver.get("https://www.amazon.com/");
WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
search.sendKeys("samsung phones");
search.click();
WebElement click1=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
click1.click();
List<WebElement>phones=driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
for(WebElement phones1:phones) {
System.out.println(phones1.getText());
List<WebElement>price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
for(WebElement cost:price) {
System.out.println(cost.getText());

TakesScreenshot tsobj=(TakesScreenshot)driver;
File Fileobj=tsobj.getScreenshotAs(OutputType.FILE);
File FileObjScreenshot=new File("image.png");
FileUtils.copyFile(Fileobj, FileObjScreenshot);
}
}
}
}