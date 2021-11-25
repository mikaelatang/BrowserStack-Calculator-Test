package BrowserStackTests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	static AppiumDriver<MobileElement> driver;
	
	static String userName = System.getenv("BROWSERSTACK_USERNAME");
	static String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	static String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");

	public static void main(String[] args) {
		try {
			openCalculator();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			runTest();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			quitCalculator();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void openCalculator() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("app", "bs://d5c60badda837ff9e00e4037fa0f33fe1df98dc9");
	    cap.setCapability("device", "Samsung Galaxy S8");
	    cap.setCapability("build", buildName);
	    cap.setCapability("os_version", "7.0");
	    cap.setCapability("project", "Ran From Jenkins");
	    cap.setCapability("browserstack.debug", "true");
	    
	    driver = new AppiumDriver<MobileElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), cap);
	    System.out.println("Application started");
	}
	
	public static void runTest() {
		MobileElement six = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
		MobileElement eight = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		MobileElement times = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		MobileElement minus = driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
		MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		MobileElement mode = driver.findElement(By.id("com.google.android.calculator:id/mode"));
		
		six.click();
		times.click();
		eight.click();
		equals.click();
		
		six.click();
		minus.click();
		eight.click();
		equals.click();
		mode.click();
		
		System.out.println("SUCCESS");
	}
	
	public static void quitCalculator() {
		driver.quit();
	}

}
