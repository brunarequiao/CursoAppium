package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage accord = new AccordionPage();

    @Test
    public void shouldInteractWithAccordion () {

        //acessa menu
        menu.accessAccordion();

        //clica opção 1
        accord.selectOption1();


        //verifica texto opção 1
        Assert.assertEquals("Esta é a descrição da opção 1", accord.getOption1Value());
    }
}
