package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PracticeSteps {
	
	WebDriver driver;
	
	@Before("@Firefox")
	public void setupFF() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pmurp\\eclipse-workspace\\WebdriverUniversityFramework\\src\\test\\java\\resources\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@Before("@Chrome")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pmurp\\eclipse-workspace\\WebdriverUniversityFramework\\src\\test\\java\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@After()
	public void teardown() throws Throwable {
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
	
	
	@Given("^user navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String url) throws Throwable {
		driver.get(url);
	}

	@Given("^user clicks on the login portal button$")
	public void user_clicks_on_the_login_portal_button() throws Throwable {
		WebElement element = driver.findElement(By.id("login-portal"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
	}

	@Given("^user enters \"([^\"]*)\" username$")
	public void user_enters_username(String username) throws Throwable {
        for (String windHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windHandle);
        }
        Thread.sleep(2000); //deelete if it doesn't work
        //driver.findElement(By.id("text")).sendKeys(username); 
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
	}

	@Given("^user enters \"([^\"]*)\"$")
	public void user_enters(String password) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("^the user should be prompted with the following prompt alert \"([^\"]*)\"$")
	public void the_user_should_be_prompted_with_the_following_prompt_alert(String message) throws Throwable {
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""), message.toLowerCase().replaceAll("\\s", ""));
		//replace followed by reg ex for replace any space with "" - guess this means no spaces?
		alert.accept();	
	}
	
	@Given("^I access webdriverunivirsity$")
	public void i_access_webdriverunivirsity() throws Throwable {
		driver.get("http://webdriveruniversity.com/");
	}

	@When("^I click on the contact us button$")
	public void i_click_on_the_contact_us_button() throws Throwable {
		driver.findElement(By.xpath("//a[@id='contact-us']/div/div[1]")).click();
	}

	@When("^I enter first name$")
	public void i_enter_first_name() throws Throwable {
		String winHandleBefore = driver.getWindowHandle();
		for (String windHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		driver.findElement(By.cssSelector("input[name = 'first_name']")).sendKeys("Paul");
	}

	@When("^I enter last name$")
	public void i_enter_last_name(DataTable arg1) throws Throwable {
		List <List <String>> data = arg1.raw();
		driver.findElement(By.cssSelector("input[name = 'last_name']")).sendKeys(data.get(0).get(3));
	}

	@When("^I enter an email address$")
	public void i_enter_an_email_address() throws Throwable {
		driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys("blag@blagmail.com");
	}

	@When("^I enter comments$")
	public void i_enter_comments(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0) + "\n");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1) + "\n");
		//driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(1).get(0) + "\n");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(1).get(1));
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Throwable {
		//driver.findElement(By.cssSelector("input[value = 'SUBMIT']")).click();
	}

	@Then("^the information should successfully be submitted via the contact us form$")
	public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Throwable {

	}

	@When("^I enter an invalid first name$")
	public void i_enter_an_invalid_first_name() throws Throwable {

	}

	@When("^I enter an invalid last name$")
	public void i_enter_an_invalid_last_name() throws Throwable {

	}

	@When("^I click on the reset button$")
	public void i_click_on_the_reset_button() throws Throwable {

	}

	@Then("^all information that was listed on the contact form will be removed$")
	public void all_information_that_was_listed_on_the_contact_form_will_be_removed() throws Throwable {

	}

}
