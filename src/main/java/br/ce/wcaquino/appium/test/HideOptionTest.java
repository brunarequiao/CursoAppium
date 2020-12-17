package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HideOptionTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void shouldFindHideOption() {

        //scroll down
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        menu.scrollDown();

        //clicar menu
        menu.clickByText("Opção bem escondida");

        //verificar mensagem
        Assert.assertEquals("Você achou essa opção", menu.getAlertMessage());

        //sair
        menu.clickByText("OK");
    }
}
