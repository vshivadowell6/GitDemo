package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FindElementsCls {
	WebDriver driver;
	public WebElement wb,sf;
	Select sel, seldrop;

	public FindElementsCls(WebDriver driver) {

		this.driver = driver;
	}


	public WebElement findElementByLocators (String locatorType, String locator)
	throws Exception{
		WebElement element = null;
		if(locatorType.equals("id")) {
			element = driver.findElement(By.id(locator));
		}
		else if(locatorType.equals("css")) {
			element = driver.findElement(By.cssSelector(locator));
		}
		else if(locatorType.equals("xpath")) {
			element = driver.findElement(By.xpath(locator));
		}
		else if(locatorType.equals("linkText")) {
			element = driver.findElement(By.linkText(locator));
		}
		else if(locatorType.equals("name")) {
			element = driver.findElement(By.name(locator));
		}
		else if(locatorType.equals("ClassName")) {
			element = driver.findElement(By.className(locator));
		}
		return element;
	}


	public WebElement GetWebElements(String locatorType, String locator) throws Exception
	{
		FindElementsCls fe = new FindElementsCls(driver);
		wb = fe.findElementByLocators(locatorType, locator);
		return wb;
	}

	public WebElement TextField_Type(String locatorType, String locator) throws Exception
	{
		FindElementsCls fe = new FindElementsCls(driver);
		wb = fe.findElementByLocators(locatorType, locator);
		return wb;
	}

	public WebElement Button_Type(String locatorType, String locator) throws Exception
	{
		FindElementsCls fe = new FindElementsCls(driver);
		wb = fe.findElementByLocators(locatorType, locator);
		return wb;
	}

	public WebElement Link_Type(String locatorType, String locator) throws Exception
	{
		FindElementsCls fe = new FindElementsCls(driver);
		wb = fe.findElementByLocators(locatorType, locator);
		return wb;
	}

	public Select selecFromdown_OneValue(String locatorType, String locator) throws Exception
	{
		FindElementsCls fe = new FindElementsCls(driver);
		sel = fe.selecFromdown1(locatorType, locator);
		return sel;
	}

	public Select selecFromdown1(String locatorType, String locator) throws Exception
	{
		FindElementsCls fe = new FindElementsCls(driver);
		sf = fe.findElementByLocators(locatorType, locator);
		seldrop = new Select(sf);
		return seldrop;
	}

	public void SelectDromDropDownWithHover(String menutitle, String menuitem, String locatorType)
	throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = findElementByLocators(locatorType, menuitem);
		//First we find menu title for Hover and we hover on it
		actions.moveToElement(menuHoverLink).perform();
		// find our menu item
		WebElement menuItemElement = findElementByLocators(locatorType, menuitem);
		actions.moveToElement(menuItemElement);
		actions.click().build().perform();
	}
}

