package FirstSeleniumScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoreCheckout {

	public StoreCheckout() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("https://kgen.io/gamer/");
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id='signin-button'])[1]")));

		driver.findElement(By.xpath(
				"(//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-x40fzr'][normalize-space()='Store'])[1]"))
				.click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("app-iframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//button[@class='add-to-cart-btn']")));
		WebElement element = driver.findElement(By.xpath("//div//button[@class='add-to-cart-btn']"));

		// Scroll to the desired element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		WebElement elementInFrame = driver.findElement(By.xpath("//div//button[@class='add-to-cart-btn']"));

		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Perform hover action on the element
		actions.moveToElement(elementInFrame).perform();

		// Click on the element after hover
		elementInFrame.click();


		driver.switchTo().defaultContent();
		js.executeScript("window.scrollTo(0, 0)");

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("app-iframe")));

		driver.findElement(By.xpath("/html/body/app-root/div/app-store/div/app-tab-controls/div/div/div/div/span[2]"))
				.click();

		// login started

		driver.switchTo().defaultContent();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id=':r2:'])[1]")));

		driver.findElement(By.xpath("(//input[@id=':r2:'])[1]")).sendKeys("9876543210");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Verify'])[1]")));
		driver.findElement(By.xpath("(//button[normalize-space()='Verify'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp-input-0']")));
		driver.findElement(By.xpath("//input[@id='otp-input-0']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='otp-input-1']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='otp-input-2']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='otp-input-3']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='otp-input-4']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='otp-input-5']")).sendKeys("1");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Submit'])[1]")));
		driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
		// login completed

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("app-iframe")));
		WebElement buttonn = driver.findElement(By.className("payment-button"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonn);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-button")));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.className("payment-button")));
		button.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-verify-email-dialog/div/div[2]/div/div/div[1]/button")));
		driver.findElement(By.xpath(
				"//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-verify-email-dialog/div/div[2]/div/div/div[1]/button"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/div/app-cart-confirmation/div/div/div/div/div/div[3]/button")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-cart-confirmation/div/div/div/div/div/div[3]/button"))
				.click();

		try {
			Thread.sleep(30000); // 5000 milliseconds = 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		 driver.close();
	}

}
