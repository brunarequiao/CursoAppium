package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragDropPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragDropTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragDropPage page = new DragDropPage();

    private String[] inicialStatus = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
            "e arraste para", "qualquer local desejado.",};

    @Test
    public void shouldDragAndDrop() {

        //acessar menu
        menu.clickDrag();

        //verificar estado inicial
        esperar(1000);
        Assert.assertArrayEquals(inicialStatus, page.getList());

        //arrastar


        //verificar estado


        //arrastar
    }
}
