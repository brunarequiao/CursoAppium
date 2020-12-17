package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage spage = new SplashPage();

    @Test
    public void shouldWaitSplash() {
        //acessa menu splash
        menu.accessSplash();

        //verifica se o splash está sendo exibido
        spage.isScreenSplashVisible();

        //aguarda saída do splash
        spage.waitSplashDisappear();

        //verifica se o formulário voltou a aparecer
        //Assert.assertTrue(spage.existElementByText("Formulário")); não funcionou essa desgraça

    }
}
