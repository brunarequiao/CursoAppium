package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import org.openqa.selenium.By;

import java.util.Set;

public class WebViewPage extends BasePage {

    public void webContext() {
        Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();

       // for(String value: contextHandles){
       //     System.out.println(value);
       // }

        DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
    }

    public void setEmail(String valor) {
        DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void setSenha(String pwd) {
        DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(pwd);
    }

    public void enter() {
        clicks(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
        return getTxt(By.xpath("//div[@class='alert.alert-success']"));
    }
}
