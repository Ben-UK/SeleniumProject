import org.openqa.selenium.By;
import org.openqa.selenium.Cookie.Builder;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.BuildInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	static WebDriver driver;
	static int locationOne;
	static int LocationTwo;
	static int locationThree;

	public static void main(String[] args) {
		{

			System.out.println("___Assert that the page loads correctly___");

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.get("file:///C:/Users/Administrator/Desktop/HTML/Sortable.html");

			WebElement one = driver.findElement(By.name("one"));
			WebElement two = driver.findElement(By.name("two"));
			WebElement three = driver.findElement(By.name("three"));

			locationOne = one.getLocation().getX();
			LocationTwo = two.getLocation().getX();
			locationThree = three.getLocation().getX();

			if (LocationTwo > locationThree)
				System.out.println("---Page Loaded Correctly---" + "\n---Elements are in the correct order---");

			else
				System.out.println("---Error Page not loaded correctly---");

			Actions builder = new Actions(driver);
			builder.dragAndDrop(two, three).perform();

			locationOne = one.getLocation().getX();
			LocationTwo = two.getLocation().getX();
			locationThree = three.getLocation().getX();

			if (locationThree > LocationTwo)
				System.out.println("---Page Changed Correctly---");

			else
				System.out.println("---Error Page not changed correctly---");

		}
	}

}
