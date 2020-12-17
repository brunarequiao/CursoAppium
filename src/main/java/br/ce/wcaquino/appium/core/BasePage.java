package br.ce.wcaquino.appium.core;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class BasePage {
    public void write(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public String getTxt(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicks(By by) {
        getDriver().findElement(by).click();
    }

    public void clickByText(String txt){
        clicks(By.xpath("//*[@text='"+txt+"']"));
    }

    public void selectCombo(By by, String value){
        //Clica na combo
        getDriver().findElement(by).click();

        //Escolhe a opção Nintendo
        clickByText(value);
    }

    public boolean isCheckMarked(By by) {

        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existElementByText(String texto) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elements.size() > 0;
    }

    public String getAlertTitle() {
        return getTxt(By.id("android:id/alertTitle"));
    }

    public String getAlertMessage() {
        return getTxt(By.id("android:id/message"));
    }

    public void taps(int x, int y) {
        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.tap(new PointOption().withCoordinates(x,y)).perform();
    }

    public void scrollDown() {
        scroll(0.9,0.1);
    }

    public void scrollUp() {
        scroll(0.1,0.9);
    }

    public void swipeLeft() {
        swipe(0.1,0.9);
    }

    public void swipeRight() {
        swipe(0.9,0.1);
    }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.press(new PointOption().withCoordinates(x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(new PointOption().withCoordinates(x,end_y))
                .release()
                .perform();
    }

    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();
        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.press(new PointOption().withCoordinates(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(new PointOption().withCoordinates(end_x,y))
                .release()
                .perform();

    }

    public void swipeElement(MobileElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.press(new PointOption().withCoordinates(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(new PointOption().withCoordinates(end_x,y))
                .release()
                .perform();
    }

    public void longClick(By by) {
        WebElement test = getDriver().findElement(by);
        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(test))).perform();
    }
}
