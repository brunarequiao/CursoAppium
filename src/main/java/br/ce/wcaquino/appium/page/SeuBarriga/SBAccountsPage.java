package br.ce.wcaquino.appium.page.SeuBarriga;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBAccountsPage extends BasePage {

    public void setAccount(String name) {
        write(By.className("android.widget.EditText"), name);
    }

    public void save() {
        clickByText("SALVAR");
    }

    public void selectAccount(String account) {
        longClick(By.xpath("//*[@text='"+account+"']"));
    }

    public void delete() {
        clickByText("EXCLUIR");
    }
}
