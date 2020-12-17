package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class DragDropPage extends BasePage {

    public void drag(String origem, String destino) {
        MobileElement inicia = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement finaliza = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
    }

    public String[] getList() {
        List<MobileElement> elements = DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            retorno[i] = elements.get(i).getText();
//            System.out.print("\"" + retorno[i] + "\", ");
        }
        return retorno;
    }
}
