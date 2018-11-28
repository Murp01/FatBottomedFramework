package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PracticeSteps {
	
	WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pmurp\\eclipse-workspace\\WebdriverUniversityFramework\\src\\test\\java\\resources\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
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
	public void i_enter_last_name() throws Throwable {
		driver.findElement(By.cssSelector("input[name = 'last_name']")).sendKeys("Murphy");
	}

	@When("^I enter an email address$")
	public void i_enter_an_email_address() throws Throwable {
		driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys("blag@blagmail.com");
	}

	@When("^I enter comments$")
	public void i_enter_comments(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0) + "\n");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1));
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Throwable {

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
