package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox {

	private static final String DRIVER_PATH = "./resources/windows/geckodriver.exe";

	public static void test(String url, String email, String password) {

		System.setProperty("webdriver.gecko.driver", DRIVER_PATH);

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		FirefoxOptions options = new FirefoxOptions();
		options.merge(capabilities);

		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		String title = driver.getTitle();
		boolean isCopyrightExist = Main.isElementPresent(wait, Main.byCopyright);
		Dimension copyrightDimension = null;
		Point copyrightPoint = null;
		String copyright = null;

		if (isCopyrightExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byCopyright));
			copyrightDimension = element.getSize();
			copyrightPoint = element.getLocation();
			copyright = element.getText();
		}

		boolean isEmailExist = Main.isElementPresent(wait, Main.byEmail);
		Dimension emailDimension = null;
		Point emailPoint = null;

		if (isEmailExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byEmail));
			emailDimension = element.getSize();
			emailPoint = element.getLocation();
		} else {
			throw new NoSuchElementException("Element " + Main.byEmail + " is not Found!");
		}

		boolean isPasswordExist = Main.isElementPresent(wait, Main.byPassword);
		Dimension passwordDimension = null;
		Point passwordPoint = null;

		if (isPasswordExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byPassword));
			passwordDimension = element.getSize();
			passwordPoint = element.getLocation();
		} else {
			throw new NoSuchElementException("Element " + Main.byPassword + " is not Found!");
		}

		boolean isLoginExist = Main.isElementPresent(wait, Main.byLogin);
		Dimension loginDimension = null;
		Point loginPoint = null;

		if (isLoginExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byLogin));
			loginDimension = element.getSize();
			loginPoint = element.getLocation();
		} else {
			throw new NoSuchElementException("Element " + Main.byLogin + " is not Found!");
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(Main.byEmail)).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(Main.byEmail)).sendKeys(email);
		wait.until(ExpectedConditions.presenceOfElementLocated(Main.byPassword)).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(Main.byPassword)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(Main.byLogin)).click();

		WebDriverWait wait2 = new WebDriverWait(driver, 20);

		boolean isTimelineExist = Main.isElementPresent(wait2, Main.byTimeline);
		Dimension timelineDimension = null;
		Point timelinePoint = null;

		if (isTimelineExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byTimeline));
			timelineDimension = element.getSize();
			timelinePoint = element.getLocation();
			element.click();
		} else {
			throw new NoSuchElementException("Element " + Main.byTimeline + " is not Found!");
		}

		boolean isFriendsExist = Main.isElementPresent(wait2, Main.byFriends);
		Dimension friendsDimension = null;
		Point friendsPoint = null;
		String friends = null;

		if (isFriendsExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byFriends));
			friendsDimension = element.getSize();
			friendsPoint = element.getLocation();
			friends = element.getText();
			friends = friends.replaceAll("\\D+", "");
		}

		boolean isSettingsExist = Main.isElementPresent(wait, Main.bySettings);
		Dimension settingsDimension = null;
		Point settingsPoint = null;

		if (isSettingsExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.bySettings));
			settingsDimension = element.getSize();
			settingsPoint = element.getLocation();
			element.click();
		} else {
			throw new NoSuchElementException("Element " + Main.bySettings + " is not Found!");
		}

		boolean isLogoutExist = Main.isElementPresent(wait, Main.byLogout);
		Dimension logoutDimension = null;
		Point logoutPoint = null;

		if (isLogoutExist) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Main.byLogout));
			logoutDimension = element.getSize();
			logoutPoint = element.getLocation();
			element.click();
		} else {
			throw new NoSuchElementException("Element " + Main.byLogout + " is not Found!");
		}

		driver.quit();

		Main.output("Firefox", title, isCopyrightExist, copyrightDimension, copyrightPoint, copyright, isEmailExist,
				emailDimension, emailPoint, isPasswordExist, passwordDimension, passwordPoint, isLoginExist,
				loginDimension, loginPoint, isTimelineExist, timelineDimension, timelinePoint, isFriendsExist,
				friendsDimension, friendsPoint, friends, isSettingsExist, settingsDimension, settingsPoint,
				isLogoutExist, logoutDimension, logoutPoint);

	}
}
