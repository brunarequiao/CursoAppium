package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.FormPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FormTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;

    private MenuPage menu = new MenuPage();
    private FormPage page = new FormPage();

    @Before
    public void login() {
        menu.accessForm();
    }

    @Test
    public void shouldFillTextField() {

        page.writeName("Bruna");

        assertEquals("Bruna", page.getName());
    }

    @Test
    public void shouldInteractWithCombo() {

        //Escolhe opção
        page.selectCombo("Nintendo Switch");

        //Verifica opção selecionada
        assertEquals("Nintendo Switch", page.getComboValue());
    }

    @Test
    public void shouldInteractWithSwitchAndCheckbox() {

        //Verifica status dos elementos
        assertFalse(page.isCheckMarked());
        assertTrue(page.isSwitchMarked());

        //Clica nos elementos
        page.clickCheck();
        page.clickSwitch();

        //Verifica status alterados
        assertTrue(page.isCheckMarked());
        assertFalse(page.isSwitchMarked());
    }

    @Test
    public void shouldChangeDate () {
        page.clickByText("01/01/2000");
        page.clickByText("20");
        page.clickByText("OK");

        Assert.assertTrue(page.existElementByText("20/2/2000"));
    }

    @Test
    public void shouldChangeTime () {
        page.clickByText("06:00");
        page.clicks(MobileBy.AccessibilityId("10"));
        page.clicks(MobileBy.AccessibilityId("40"));
        page.clickByText("OK");
        Assert.assertTrue(page.existElementByText("10:40"));
    }

    @Test
    public void shouldInteractSeekbar() {
        //clicar no seekbar
        page.clickSeekbar(0.25);

        //salvar
        page.save();

        //obter o valor
    }
}
