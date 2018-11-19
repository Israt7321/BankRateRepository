package pack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends Abstract{
@Before
public void OpenBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\AllDriver\\chromedriver.exe");
	driver =new ChromeDriver();

	driver.get("https://www.bankrate.com");
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}
@After
public void CloseBrowser() {
	driver.close();
}
}
