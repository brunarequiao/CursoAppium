package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.TabPage;
import org.junit.Assert;
import org.junit.Test;

public class TabTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private TabPage tab = new TabPage();

    @Test
    public void shouldInteractWithTabs() {
        //acessa menu abas
        menu.accessTabs();

        //verifica que está na aba 1
        Assert.assertTrue(tab.tabOne());

        //acessa aba 2
        tab.selectTabTwo();

        //verifica que está na aba 2
        Assert.assertTrue(tab.tabTwo());
    }
}
