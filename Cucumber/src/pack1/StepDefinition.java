package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends Abstract{
	//Mortgage calculator
	@Given("^User is on BankRate WebPage$")
	public void user_is_on_BankRate_WebPage() throws Throwable {
		driver.get("https://www.bankrate.com");

	}

	@Given("^User move on Mortgage manue and select  Mortgage calculation$")
	public void user_move_on_Mortgage_manue_and_select_Mortgage_calculation() throws Throwable {
		WebElement Mg =driver.findElement(By.linkText("MORTGAGES"));
		Actions act = new Actions(driver);
		act.moveToElement(Mg).perform();
		driver.findElement(By.linkText("Mortgage calculator")).click();
		Thread.sleep(1000);

	}

	@When("^User input HomePrice$")
	public void user_input_HomePrice() throws Throwable {
		driver.findElement(By.id("homePrice")).clear();
		driver.findElement(By.id("homePrice")).sendKeys("250000");
		Thread.sleep(2000);

	}

	@When("^User input DownPayment and percentage$")
	public void user_input_DownPayment_and_percentage() throws Throwable {
		driver.findElement(By.name("downPaymentDollarAmount")).clear();
		driver.findElement(By.name("downPaymentDollarAmount")).sendKeys("10000");
		driver.findElement(By.name("downPaymentPercent")).clear();
		driver.findElement(By.name("downPaymentPercent")).sendKeys("4.00");
		Thread.sleep(2000);

	}

	@When("^User select the duration and interest rate$")
	public void user_select_the_duration_and_interest_rate() throws Throwable {
		driver.findElement(By.name("termInYears")).clear();
		driver.findElement(By.name("termInYears")).sendKeys("30");
		driver.findElement(By.name("termInMonths")).clear();
		driver.findElement(By.name("termInMonths")).sendKeys("360");
		driver.findElement(By.name("interestRate")).clear();
		driver.findElement(By.name("interestRate")).sendKeys("4.86");
		Thread.sleep(2000);

	}

	@When("^User click on calculate button$")
	public void user_click_on_calculate_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"mortgage-calculator\"]/div[1]/div/div[2]/div[1]/div[4]/div[2]/button"))
		.click();
	}

	@Then("^The user will found the mortgage amount in dollar$")
	public void the_user_will_found_the_mortgage_amount_in_dollar() throws Throwable {
		String rslt1 =driver.findElement(By.xpath("//*[@id=\"mortgage-calculator\"]/div[1]/div/div[2]/div[2]/div[1]/p"))
				.getText().replace("$","");   //.replaceAll("[^0-9].","");
		System.out.println("Estimated Monthly payment is: "+rslt1);
		//Assert.assertEquals(rslt1,"1,267.92");
		Thread.sleep(1000);

	}
	//Saving calculator:
	@Given("^User will nevigate to Banking manue select Saving Calculator$")
	public void user_will_nevigate_to_Banking_manue_select_Saving_Calculator() throws Throwable {
		driver.get("https://www.bankrate.com");
		WebElement bnk =driver.findElement(By.linkText("BANKING"));
		//Submanu Handling
		Actions act = new Actions(driver);
		act.moveToElement(bnk).perform();
		
		driver.findElement(By.linkText("Savings calculator")).click();
		
	}
	@When("^user enter Initial Amopunt \"(.*?)\",Monthly Deposit\"(.*?)\"$")
	public void user_enter_Initial_Amopunt_Monthly_Deposit(String IntAmnt, String MnthDp) throws Throwable {
		driver.findElement(By.id("initialAmount")).clear();
		driver.findElement(By.id("initialAmount")).sendKeys(IntAmnt);
		driver.findElement(By.id("monthlyDeposit")).clear();
		driver.findElement(By.id("monthlyDeposit")).sendKeys(MnthDp);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
	}

	@When("^user enter Annual Interest \"(.*?)\" ,Number of years\"(.*?)\"$")
	public void user_enter_Annual_Interest_Number_of_years(String AnnInt, String NmYr) throws Throwable {
		driver.findElement(By.id("annualInterest")).clear();
		driver.findElement(By.id("annualInterest")).sendKeys(AnnInt);
		driver.findElement(By.id("numberOfYears")).clear();
		driver.findElement(By.id("numberOfYears")).sendKeys(NmYr);
		
	}
	@When("^user will click on calculate button$")
	public void user_will_click_on_calculate_button() throws Throwable {
		driver.findElement(By.id("calculate")).click();
	}

	@Then("^user will get the result of TotalAmount \"(.*?)\"$")
	public void user_will_get_the_result_of_TotalAmount(String ExpRslt) throws Throwable {
	    String ActRslt =driver.findElement(By.id("finalSavingsBalance")).getText();//.replaceAll("[^0-9].","");
		System.out.println("Actual result of two years saving is: "+ActRslt);
		Assert.assertEquals(ActRslt, ExpRslt);
		
	}

}
