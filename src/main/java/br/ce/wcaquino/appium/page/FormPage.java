package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FormPage extends BasePage {

    public void writeName(String name) {
        write(MobileBy.AccessibilityId("nome"), name);
    }

    public String getName() {
        return getTxt(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String value) {
        selectCombo(MobileBy.AccessibilityId("console"), value);
    }

    public String getComboValue() {
        return getTxt(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickCheck() {
        clicks(By.className("android.widget.CheckBox"));
    }

    public void clickSwitch() {
        clicks(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarked() {
        return isCheckMarked(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarked() {
        return isCheckMarked(MobileBy.AccessibilityId("switch"));
    }

    public void save() {
        clickByText("SALVAR");
    }

    public void clickSeekbar(double position) {
        int delta = 55;
        MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height / 2);

        int xini = seek.getLocation().x + delta;
        int x = (int) (xini + ((seek.getSize().width - 2*delta)* position));

        taps(x,y);


    }


}
