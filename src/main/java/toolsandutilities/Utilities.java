package toolsandutilities;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {
	public static WebDriver driver;
	public static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class.getName());
	static final String STRMSGERROR = "Error: ";
	
	public static void openUrl(String strUrl){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get(strUrl);
		driver.manage().window().maximize();
	}

	public static boolean isElementPresent(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (NoSuchElementException | TimeoutException e) {
			LOGGER.error(STRMSGERROR, e);
			return false;
		}
	}

	public static WebElement el(By by) {
		return driver.findElement((By) by);
	}

	public static String base64Screenshot(){
		return "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	public static List<WebElement> els(By by) {
		return driver.findElements((By) by);
	}

	public static void wt(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			LOGGER.error(STRMSGERROR, e);
			Thread.currentThread().interrupt();
		}
	}

	public static void waitForElement(By by, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(by),
				ExpectedConditions.elementToBeSelected(by), 
				ExpectedConditions.presenceOfNestedElementLocatedBy(by, null)));
	}
		
	public static void closeExplorer() {
		driver.close();
	}
	
	public static void closeProcess() {
		driver.quit();
	}
	
	public static void type(By by, String str) {
		el(by).sendKeys(str);
	}
	
	public static void click(By by) {
		el(by).click();
	}

	public static void robotSendKeys(String strPath) throws AWTException {
		StringSelection strSelection = new StringSelection(strPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		Robot objRobot = new Robot();
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		objRobot.keyPress(KeyEvent.VK_CONTROL);
		objRobot.keyPress(KeyEvent.VK_V);
		objRobot.keyRelease(KeyEvent.VK_CONTROL);
		objRobot.keyRelease(KeyEvent.VK_V);
		wt(1000);
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static String getText(By by) {
		return el(by).getText();
	}

	public static void selectByVisibleText(By by, String str) {
		Select objSelect = new Select(el(by));
		objSelect.selectByVisibleText(str);
	}

	public static String getDateYYYYMMDDHHMMSS() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}