package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class ClickPage extends BasePage {

    public void longClick() {
        longClick(By.xpath("//*[@text='Clique Longo']"));

    }

    public String getFieldText() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
