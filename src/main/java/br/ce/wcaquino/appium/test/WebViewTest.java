package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void shouldDoLogin() {
        //acessar menu
        menu.accessSbHibrid();
        esperar(3000);
        page.webContext();

        //preencher email
        page.setEmail("dammitbruna@gmail.com");

        //senha
        page.setSenha("123");


        //entrar
        page.enter();

        //verificar
        Assert.assertEquals("Bem vindo, Bruna!", page.getMessage());


    }

}
