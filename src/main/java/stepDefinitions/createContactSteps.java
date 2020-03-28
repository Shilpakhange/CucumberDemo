package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class createContactSteps {
	WebDriver driver;

	@Given("^user on login page$")
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

	@When("^the login page title is CRM software for customer relationship management, sales, and support\\.$")
	public void title_of_the_login_page_is_CRM() {
		String title = driver.getTitle();
		assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user provide \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

	}

	@Then("^user clicks on submit button$")
	public void user_clicks_on_login_button() {
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginButton);
	}

	@Then("^after login page title is CRMPRO$")
	public void title_of_the_login_page_is_CRMPRO() {
		String title1 = driver.getTitle();
		assertEquals("CRMPRO", title1);
	}

	@Then("^user mousehover the contacts button\\.$")
	public void user_mousehover_the_contacts_button() {
		driver.switchTo().frame("mainpanel");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
	}

	@Then("^user clicks on create new contact link\\.$")
	public void user_clicks_on_create_new_contact_link() {
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}

	@Then("^user enters contact details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_contact_details(String firstname, String lname, String comapny) {
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.id("surname")).sendKeys(lname);
		driver.findElement(By.name("client_lookup")).sendKeys(comapny);
	}

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() {
		driver.findElement(By.xpath("//form[@id='contactForm']/table/tbody/tr/td/input[2]")).click();
	}

	@Then("^shut the browser$")
	public void close_the_browser(){
		driver.quit();
	}

}
