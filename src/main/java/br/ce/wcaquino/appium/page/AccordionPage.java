package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selectOption1() {
        clickByText("Opção 1");
    }

    public String getOption1Value() {
        return getTxt(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
    }
}
