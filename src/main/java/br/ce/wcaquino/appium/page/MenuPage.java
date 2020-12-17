package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {

    public void accessForm() {
        clickByText("Formulário");
      //  WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
    }

    public void accessAlert() {
        clickByText("Alertas");
    }

    public void accessSplash() {
        clickByText("Splash");
    }

    public void accessTabs() {
        clickByText("Abas");
    }

    public void accessAccordion() {
        clickByText("Accordion");
    }

    public void accessClick() {
        clickByText("Cliques");
    }

    public void accessSwipe() {
        clickByText("Swipe");
    }

    public void clickDrag() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clickByText("Drag and drop");
    }

    public void accessSbHibrid() {
        clickByText("SeuBarriga Híbrido");
    }

    public void accessSbNative() {
        clickByText("SeuBarriga Nativo");
    }
}
