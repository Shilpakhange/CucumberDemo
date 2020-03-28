package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateDealsSteps {

	WebDriver driver;

	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");

	}

	@When("^title of the login page is CRM software for customer relationship management, sales, and support\\.$")
	public void title_of_the_login_page_is_CRM_software() {
		String title = driver.getTitle();
		assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credential) {
		for (Map<String, String> data : credential.asMaps(String.class, String.class)) {

			driver.findElement(By.name("username")).sendKeys(data.get("username"));
			driver.findElement(By.name("password")).sendKeys(data.get("password"));

		}
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginButton);

	}

	@Then("^user is on homepage$")
	public void user_is_on_homepage() {
		String title1 = driver.getTitle();
		assertEquals("CRMPRO", title1);
	}

	@Then("^user mouse hovet to the deal tab$")
	public void user_mouse_hovet_to_the_deal_tab() {
		driver.switchTo().frame("mainpanel");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
	}

	@Then("^user click on New Deal link$")
	public void user_click_on_New_Deal_link() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
	}

	@Then("^user fills the deals detail$")
	public void user_fills_the_deals_detail(DataTable Dealdetail) throws InterruptedException {
		for (Map<String, String> Dealdata : Dealdetail.asMaps(String.class, String.class)) {
			
			driver.findElement(By.id("title")).sendKeys(Dealdata.get("title"));
			driver.findElement(By.id("amount")).sendKeys(Dealdata.get("amount"));
			driver.findElement(By.id("probability")).sendKeys(Dealdata.get("probability"));
			driver.findElement(By.id("commission")).sendKeys(Dealdata.get("commision"));

			//			driver.findElement(By.xpath("//form[@id='prospectForm']/table/tbody/tr/td/input[1]")).click();
			driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement Dealstab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Deals')]")));

			Actions act = new Actions(driver);
			act.moveToElement(Dealstab).build().perform();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();




		}
	}

//	@Then("^user click on save button$")
//	public void user_click_on_save_button() {
//		driver.findElement(By.xpath("//form[@id='prospectForm']/table/tbody/tr/td/input[1]")).click();
//
//	}

	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
