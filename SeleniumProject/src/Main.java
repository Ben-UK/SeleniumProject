import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	static WebDriver driver;
	static WebDriver driver2;

	public static void main(String[] args) {
		{

			System.out.println("___Attempting to Log Into Facebook using Chrome___");

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe" );

			driver = new ChromeDriver();

			driver.get("http://www.facebook.com/");
			String email = "user";
			String pass = "password";

			WebElement emailBox = driver.findElement(By.name("email"));
			WebElement passBox = driver.findElement(By.name("pass"));
			WebElement loginbutton = driver.findElement(By.id("loginbutton"));

			emailBox.sendKeys(email);
			passBox.sendKeys(pass);
			loginbutton.click();

			WebDriverWait wait = new WebDriverWait(driver, 5);
			boolean testElement = false;

			try {
				System.out.println("Attempting Login in Chrome...");
				testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div"),
						"The email address or phone number that you've entered doesn't match any account. Sign up for an account."));

			}

			catch (Exception e) {

				e.printStackTrace();
				testElement = false;

			}

			if (testElement)
				System.out.println("---Facebook sucesfully stopped the login due to incorrect password in Chrome---");

			else
				System.out.println("---Facebook let you login with just \"admin\" and \"password\" in Chrome---");

		}

		{

			System.out.println("___Attempting to Log Into Facebook using Firefox___");

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");

			driver2 = new FirefoxDriver();

			driver2.get("http://www.facebook.com/");
			String email = "user";
			String pass = "password";

			WebElement emailBox = driver2.findElement(By.name("email"));
			WebElement passBox = driver2.findElement(By.name("pass"));
			WebElement loginbutton = driver2.findElement(By.id("loginbutton"));

			emailBox.sendKeys(email);
			passBox.sendKeys(pass);
			loginbutton.click();

			WebDriverWait wait = new WebDriverWait(driver2, 5);
			boolean testElement = false;

			try {
				System.out.println("Attempting Login in Firefox...");
				testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div"),
						"The email address or phone number that you've entered doesn't match any account. Sign up for an account."));

			}

			catch (Exception e) {

				e.printStackTrace();
				testElement = false;

			}

			if (testElement)
				System.out.println("---Facebook sucesfully stopped the login due to incorrect password in Firefox---");

			else
				System.out.println("---Facebook let you login with just \"admin\" and \"password\" in Firefox---");
			driver.close();
			driver2.close();
			System.out.println("Exiting...");
			System.exit(0);
		}
	}

}
