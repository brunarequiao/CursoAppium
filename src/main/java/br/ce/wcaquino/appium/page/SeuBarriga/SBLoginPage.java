package br.ce.wcaquino.appium.page.SeuBarriga;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {

    public void setEmail(String email) {
        write(By.className("android.widget.EditText"), email);
    }

    public void setPwd(String pwd) {
        write(By.xpath("//android.widget.EditText[2]"), pwd);
    }

    public void enter(){
        clickByText("ENTRAR");
    }


}
