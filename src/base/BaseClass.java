package base;

import java.io.FileReader;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Constants.Constants;

@SuppressWarnings("unused")
public class BaseClass {
	//public static final Class URL = null;
	public static WebDriver driver;
	public static Properties prop = new  Properties();

	@BeforeSuite
	//@Test(groups = {"Login","Register"})
	public void setup() throws Exception
	{
		String projectPath = Constants.PROJECTP_PATH;
		System.out.println("Java Version is: "+System.getProperty("java.version"));
		if (driver == null)
		{
			FileReader fr = new FileReader(projectPath+"/src/config.properties");
			prop.load(fr);
			//System.out.println("Driver is NULL");
		}

		if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			// System.out.println("It is "+prop.getProperty("browserName")+" browser");
			// System.out.println(prop.getProperty("testurl"));
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			System.out.println("Chrome Driver Path" + System.getProperty("user.dir"));
			//+ "/bin/drivers/chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver",
			// "C:/Users/1000020344/Downloads/chromedriver.exe");
			// driver = new ChromeDriver();
			// ==============================='

			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*");
			  //options.addArguments("--disable notifications");
			  //options.setExperimentalOption("excludeSwitches",
			  Arrays.asList("disable-popup-blocking"); // options.setHeadless(true);
			  //options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
			  DesiredCapabilities cp = new DesiredCapabilities();
			  cp.setCapability(ChromeOptions.CAPABILITY, options);
			  options.merge(cp);

			// ===============================
			driver = new ChromeDriver(options); // Passing options as parameters.
			driver.get(prop.getProperty("testurl"));
			 System.out.println("====================");
			driver.manage().window().maximize();
			System.out.println("URL Opened Successfully");
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Seems
			// this is Deprecated
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("PageLoadTimeout = "+driver.manage().timeouts().getPageLoadTimeout());
			System.out.println("ImplicitWaitTimeout = "+driver.manage().timeouts().getImplicitWaitTimeout());
		}

		if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
			System.out.println("It is " + prop.getProperty("browserName") + " browser");
			// System.out.println(prop.getProperty("testurl"));
			// System.out.println("projectPath = "+projectPath);
			System.setProperty("webdriver.gecko.driver",
			System.getProperty("user.dir") + "/bin/drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Users\\1000020344\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			// System.out.println("URL Opened Successfully");
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Seems
			// this is Deprecated
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		if (prop.getProperty("browserName").equalsIgnoreCase("Edge")) {
			System.out.println("It is " + prop.getProperty("browserName") + " browser");
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/bin/drivers/msedgedriver.exe");

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(EdgeOptions.CAPABILITY, options);
			options.merge(cp);

			driver = new EdgeDriver(options);
			// driver.navigate().to((prop.getProperty("testurl")));
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			// driver.manage().window().fullscreen();
			// System.out.println("URL Opened Successfully");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}}

	@AfterSuite
	public void teardown()
{
	//driver.close();
		driver.quit();
	System.out.println("teardown executed");
}
		}



