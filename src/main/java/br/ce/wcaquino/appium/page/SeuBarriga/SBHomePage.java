package br.ce.wcaquino.appium.page.SeuBarriga;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {

    public String getAccountBalace(String account) {
        return getTxt(By.xpath("//*[@text='"+account+"']/following-sibling::android.widget.TextView"));
    }
}
