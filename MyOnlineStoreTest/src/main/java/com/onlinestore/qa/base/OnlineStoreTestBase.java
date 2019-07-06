package com.onlinestore.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.onlinestore.qa.util.OnlineStoreTestUtil;

public class OnlineStoreTestBase {
	
public	static WebDriver driver;
public 	static Properties prop ;
	
public static String filePath="E:\\WS_Ethans_CJ\\MyOnlineStoreTest\\src\\main\\java\\com\\onlinestore\\qa\\config\\\\configonlinestore.properties";
	
	public OnlineStoreTestBase() {
		
		prop  = new Properties();
		try {
			FileInputStream file = new FileInputStream(filePath);
			
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void browsweInitialization() {
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Sel 3.141\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Downloads\\geckodriver.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("firefox");
				capabilities.setPlatform(Platform.WINDOWS);
				capabilities.setCapability("marionette", false);
				FirefoxOptions options = new FirefoxOptions(capabilities);
				driver = new FirefoxDriver(options);
				
			}
			else if(browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "E:\\Sel 3.141\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			else {
				System.out.println("Invalid input : Please provide correct browser name");
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(OnlineStoreTestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(OnlineStoreTestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
			
		}
		
		
		
	}
	
	


