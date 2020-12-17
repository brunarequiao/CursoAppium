package br.ce.wcaquino.appium.page.SeuBarriga;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMenuPage extends BasePage {

    public void accessAccounts() {
        clickByText("CONTAS");
    }

    public void accessMovement() {
        clickByText("MOV...");
    }

    public void accessResume() {
        clickByText("RESUMO");
    }

    public void accessHome() {
        clickByText("HOME");
    }
}
