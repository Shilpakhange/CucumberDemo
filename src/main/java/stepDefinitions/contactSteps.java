package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class contactSteps {

	WebDriver driver;

	@Given("^User is on home page$")
	public void user_is_on_home_page() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

		driver.findElement(By.name("username")).sendKeys("shilpaabc");
		driver.findElement(By.name("password")).sendKeys("Sh$ln9606");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginButton);

	}

	@When("^contacts tab is present on the contacts page$")
	public void contacts_tab_is_present_on_the_contacts_page() {
		driver.switchTo().frame("mainpanel");
		boolean flag = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).isDisplayed();
		assertTrue(flag);
	}

	@Then("^user mouse hover to the contacts page$")
	public void user_mouse_hover_to_the_contacts_page() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();

	}

	@Then("^user clicks on New Contact link$")
	public void user_clicks_on_New_Contact_link() {
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}

	@Then("^user selects title$")
	public void user_selects_title() {
		
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		sel.selectByVisibleText("Mr.");
	}

	@Then("^user enters firtname and lastname$")
	public void user_enters_firtname_and_lastname() {
		driver.findElement(By.name("first_name")).sendKeys("shilpa");
		driver.findElement(By.id("surname")).sendKeys("Khandge");
		
	}

	@Then("^user clicks save button\\.$")
	public void user_clicks_save_button(){
		driver.findElement(By.xpath("//form[@id='contactForm']/table/tbody/tr/td/input[2]")).click();
	}
	

	@Then("^verify new contact is added$")
	public void verify_new_contact_is_added(){
	
		boolean b=(driver.findElement(By.xpath("//td[contains(text(),'Mr. shilpa Khandge')]")).isDisplayed());
		assertTrue(b);
	}

}
