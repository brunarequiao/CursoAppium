package br.ce.wcaquino.appium.page.SeuBarriga;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SBResumoPage extends BasePage {

    public void deleteMovement(String desc) {
        MobileElement element = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));

        swipeElement(element, 0.9, 0.1 );

        clickByText("Del");
    }
}
