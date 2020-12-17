package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;

public class TabPage extends BasePage {
    public boolean tabOne() {
        return existElementByText("Este é o conteúdo da Aba 1");
    }

    public boolean tabTwo() {
        return existElementByText("Este é o conteúdo da Aba 2");
    }

    public void selectTabTwo() {
        clickByText("ABA 2");
    }
}
