package br.ce.wcaquino.appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class CalculatorHardwareTest {
    @Test
    public void shouldSumTwoValues() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Asus");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.asus.calculator");
        desiredCapabilities.setCapability("appActivity", "com.asus.calculator.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        MobileElement el2 = (MobileElement) driver.findElementById("com.asus.calculator:id/digit2");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("mais");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.asus.calculator:id/digit2");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("igual");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("4");
        el6.click();
        assertEquals("4", el6.getText());

        driver.quit();
    }
}
