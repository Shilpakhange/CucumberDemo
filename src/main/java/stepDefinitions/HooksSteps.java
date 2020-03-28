package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.runner.BaseTestRunner;
public class HooksSteps {

	WebDriver driver;

	@Before
	public void setUp()
	{
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
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Given("^user is on tasks page$")
	public void user_is_on_tasks_page()  {
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Tasks')]")).click();

		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Tasks')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Task')]")).click();
		
	}
	
//	@Before("@First")
//	public void beforefirst()
//	{
//		System.out.println("Precondition only for first scenario");
//	}
//
	@When("^user enters title and completion$")
	public void user_enters_title_and_completion(DataTable task) {
		List<List<String>>tsk=task.raw();

		driver.findElement(By.id("title")).sendKeys(tsk.get(0).get(0));
		driver.findElement(By.id("completion")).sendKeys(tsk.get(0).get(1));
		driver.findElement(By.xpath("//input[@type='submit'and @value='Save']")).click();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("^user verifies task is created for the below title$")
	public void user_verifies_task_is_created_for_the_below_title(DataTable taskval)  {
		List<List<String>>tsk=taskval.raw();
		String tit=tsk.get(0).get(0);

		driver.findElement(By.xpath("//a[contains(text(),'Tasks')]")).click();

//		List<WebElement>col=driver.findElements(By.xpath("//form[@name='TASKSEARCH']/table[2]/tbody/tr[2]/td/strong"));
//		System.out.println(col.size());
		List<WebElement> rows = driver.findElements(By.xpath("//form[@name='TASKSEARCH']/table[2]/tbody/tr"));
		System.out.println(rows.size());
		WebElement text = driver.findElement(By.xpath("//form[@name='TASKSEARCH']/table[@class='datacard']/tbody/tr[4]/td[2]/a"));
		String title = text.getText();
		System.out.println(title);
		String beforeX_path = "//form[@name='TASKSEARCH']/table[@class='datacard']/tbody/tr[";
		String Afterx_path = "]/td[2]/a";
		// for(int i=2;i<col.size()-6;i++)
		for (int j = 3; j <= rows.size(); j++)

		{
			WebElement text1 = driver.findElement(By.xpath(beforeX_path + j + Afterx_path));
			String tittask=text1.getText();
			System.out.println(text1.getText());
			if(tittask.equals(tit))
			{
				System.out.println("Task is created for the title:"+tit);
				break;
			}
		}
		
		
	}

//	@Given("^user is on case page$")
//	public void user_is_on_case_page() {
//	}
//
//	@When("^user enters title$")
//	public void user_enters_title() {
//	}
//
//	@Then("^user verifies case is created$")
//	public void user_verifies_case_is_created() {
//	}

	
}
