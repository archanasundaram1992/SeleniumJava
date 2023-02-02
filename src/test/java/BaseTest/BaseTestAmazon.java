package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageEvent.LaunchingPage;

public class BaseTestAmazon {

	
	public static WebDriver driver;
	public static LaunchingPage launchingPage;
	
	@BeforeTest
	public static void BeforeTestMethod()
	{
	
		
	}
	
	@BeforeMethod
	public LaunchingPage LaunchApplication() throws IOException
	{
		driver = InitializeDriver();
		goToBrowser();
		launchingPage =new LaunchingPage(driver);
		return launchingPage;
	}
	
	@AfterMethod
	public static void CloseBrowsers()
	{
		driver.quit();
	}
	
	@AfterTest
	public static void AfterTestMethod()
	{
		
	}
	
	public static Properties ReadPropertiesFile() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("E:\\Java_workspace\\SeleniumJavaFrameworkAmazon\\propertiesFile.properties");
		prop.load(input);
		return prop;
	}
	
	public static WebDriver InitializeDriver() throws IOException
	{

		Properties prop = ReadPropertiesFile();
		String BrowserName = prop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		else
		{
			//default
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public static void goToBrowser() throws IOException 
	{
		Properties prop = ReadPropertiesFile();
		String url = prop.getProperty("url");
		driver.get(url);

				
	}
	
	public static String getScreenshotMethod(String testcaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file =new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
		
		
	}
}
