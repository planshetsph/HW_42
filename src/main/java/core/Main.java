package core;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	private static final String URL = "https://www.facebook.com/";
	private static String email;
	private static String password;
	public static By byCopyright = By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span");
	public static By byEmail = By.id("email");
	public static By byPassword = By.id("pass");
	public static By byLogin = By.xpath("//*[@id='u_0_2' or @id='u_0_8']");
	public static By byTimeline = By.xpath("//span[contains(@class,'_1vp5')]");
	public static By byFriends = By.xpath("//a[@data-tab-key='friends']");
	public static By bySettings = By.id("userNavigationLabel");
	public static By byLogout = By.xpath("//li[contains(.,'Log Out')]");

	public static void main(String[] args) {

		String os = System.getProperty("os.name");

		if (!os.toUpperCase().contains("WINDOWS")) {
			throw new IllegalArgumentException("The OS is " + os + ", but requered WINDOWS");
		}

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter facebook email:");
		email = scanner.nextLine();
		System.out.println("Enter facebook password:");
		password = scanner.nextLine();
		scanner.close();

		Firefox.test(URL, email, password);

	}

	public static boolean isElementPresent(WebDriverWait wait, By by) {
		List<WebElement> elements = null;

		try {
			elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		} catch (Exception e) {
			System.out.println("Element " + by.toString() + " is not found!");
			return false;
		}

		if (elements.size() > 1) {
			System.out.println("Element " + by.toString() + " is not unique!");
			return false;
		}

		WebElement element = elements.get(0);

		if (!element.isDisplayed()) {
			System.out.println("Element " + by.toString() + " is not displayed!");
			return false;
		}

		return true;
	}

	public static void output(String browser, String title, boolean isCopyrightExist, Dimension copyrightDimension,
			Point copyrightPoint, String copyright, boolean isEmailExist, Dimension emailDimension, Point emailPoint,
			boolean isPasswordExist, Dimension passwordDimension, Point passwordPoint, boolean isLoginExist,
			Dimension loginDimension, Point loginPoint, boolean isTimelineExist, Dimension timelineDimension,
			Point timelinePoint, boolean isFriendsExist, Dimension friendsDimension, Point friendsPoint, String friends,
			boolean isSettingsExist, Dimension settingsDimension, Point settingsPoint, boolean isLogoutExist,
			Dimension logoutDimension, Point logoutPoint) {
		System.out.println("01. Browser is: " + browser);
		System.out.println("02. Title of the page: " + title);
		System.out.println("03. Element [Copyright]: " + (isCopyrightExist ? "Exists" : "Not Exists"));

		if (isCopyrightExist) {
			System.out.println("04. Size of Copyright Text: " + copyrightDimension.toString());
			System.out.println("05. Location of Copyright Text: " + copyrightPoint.toString());
		}

		System.out.println("06. Element [Email Field]: " + (isEmailExist ? "Exists" : "Not Exists"));

		if (isEmailExist) {
			System.out.println("07. Size of Email Field: " + emailDimension.toString());
			System.out.println("08. Location of Email Field: " + emailPoint.toString());
		}

		System.out.println("09. Element [Password Field]: " + (isPasswordExist ? "Exists" : "Not Exists"));

		if (isPasswordExist) {
			System.out.println("10. Size of Password Field: " + passwordDimension.toString());
			System.out.println("11. Location of Password Field: " + passwordPoint.toString());
		}

		System.out.println("12. Element [Login Button]: " + (isLoginExist ? "Exists" : "Not Exists"));

		if (isLoginExist) {
			System.out.println("13. Size of Login Button: " + loginDimension.toString());
			System.out.println("14. Location of Login Button: " + loginPoint.toString());
		}

		System.out.println("15. Element [Timeline Button]: " + (isTimelineExist ? "Exists" : "Not Exists"));

		if (isTimelineExist) {
			System.out.println("16. Size of Timeline Button: " + timelineDimension.toString());
			System.out.println("17. Location of Timeline Button: " + timelinePoint.toString());
		}

		System.out.println("18. Element [Friends Button]: " + (isFriendsExist ? "Exists" : "Not Exists"));

		if (isFriendsExist) {
			System.out.println("19. Size of Friends Button: " + friendsDimension.toString());
			System.out.println("20. Location of Friends Button: " + friendsPoint.toString());
		}

		System.out.println("21. Element [Account Settings]: " + (isSettingsExist ? "Exists" : "Not Exists"));

		if (isSettingsExist) {
			System.out.println("22. Size of Account Settings: " + settingsDimension.toString());
			System.out.println("23. Location of Account Settings: " + settingsPoint.toString());
		}

		System.out.println("24. Element [Log Out Button]: " + (isLogoutExist ? "Exists" : "Not Exists"));

		if (isLogoutExist) {
			System.out.println("25. Size of Log Out Button: " + logoutDimension.toString());
			System.out.println("26. Location of Log Out Button: " + logoutPoint.toString());
		}

		System.out.println("27. Copyright: " + copyright);
		System.out.println("28. You have " + friends + " friends");
	}

}
