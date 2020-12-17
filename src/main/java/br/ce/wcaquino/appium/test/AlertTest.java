package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage alert = new AlertPage();

    @Before
    public void setup() {
        //acessar menu alerta
        menu.accessAlert();
    }

    @Test
    public void shouldConfirmAlert() {

        //clica em alerta confirm
        alert.clickAlertConfirm();

        //verifica os textos
        Assert.assertEquals("Info", alert.getAlertTitle());
        Assert.assertEquals("Confirma a operação?", alert.getAlertMessage());

        //confirma alerta
        alert.confirm();

        //verifica nova mensagem
        Assert.assertEquals("Confirmado", alert.getAlertMessage());

        //sai
        alert.exit();
    }

    @Test
    public void shouldClickOutAlert() {

        //clicar alerta simples
        alert.clickSimpleAlert();

        //clicar fora da caixa
        esperar(1000);

        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.tap(new PointOption().withCoordinates(121,141)).perform();

        //verificar que o alerta foi fechado
        assertEquals(false, alert.existElementByText("Pode clicar no OK ou fora da caixa para sair"));
    }
}
