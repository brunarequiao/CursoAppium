package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.ClickPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ClickTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private ClickPage cpage = new ClickPage();

    @Test
    public void getlongClick() {

        //acessar menu
        menu.accessClick();

        //clique longo
        cpage.longClick();

        //verifica
        Assert.assertEquals("Clique Longo", cpage.getFieldText());



    }
}
