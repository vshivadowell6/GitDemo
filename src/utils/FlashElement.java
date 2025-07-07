package utils;

//import javax.jws.soap.SOAPBinding.Style;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlashElement {
	public static void highLighterWebElementMethod(WebElement element, WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// String bgcolor = element.getCssVale("backgroundColor");
		int i;
		for (i = 0; i < 3; i++) {
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid green;');",
					element);
			Thread.sleep(150);
			js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
					element);
			Thread.sleep(150);
		}
	}

	public static void highLighterWebElementMethod1(WebElement element, WebDriver driver, String color)
			throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// String bgcolor = element.getCssVale("backgroundColor");
		int i;

		if (color.equalsIgnoreCase("yellow")) {
			for (i = 0; i < 3; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid green;');",
						element);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
						element);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						element);
				Thread.sleep(150);
			}

		} else if (color.equalsIgnoreCase("green")) {
			for (i = 0; i < 3; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid green;');",
						element);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						element);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
						element);
				Thread.sleep(150);
			}
		} else if (color.equalsIgnoreCase("pink")) {
			for (i = 0; i < 3; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid green;');",
						element);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						element);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid red;');",
						element);
				Thread.sleep(150);
			}
		}
	}

}
