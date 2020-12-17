package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;

public class AlertPage extends BasePage {
    public void clickAlertConfirm() {
        clickByText("ALERTA CONFIRM");
    }

    public void clickSimpleAlert () {
        clickByText("ALERTA SIMPLES");
    }

    public void confirm() {
        clickByText("CONFIRMAR");
    }

    public void exit() {
        clickByText("SAIR");
    }

}
