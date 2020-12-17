package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void shouldSwipe() {

        //acessar menu
        menu.accessSwipe();

        //verificar texto
        Assert.assertTrue(menu.existElementByText("Mova a tela para"));

        //swipe p direita
        menu.swipeRight();

        //verifica texto 2
        Assert.assertEquals(true, menu.existElementByText("E veja se"));

        //clica botão seta a direita
        menu.clickByText("›");

        //verifica texto 3
        Assert.assertTrue(menu.existElementByText("Chegar até o fim!"));

        //swipe
        menu.swipeLeft();

        //clicar botão seta a esquerda
        menu.clickByText("‹");

        //verifica texto
        Assert.assertTrue(menu.existElementByText("a esquerda"));
    }
}
