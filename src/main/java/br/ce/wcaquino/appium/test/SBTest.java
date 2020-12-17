package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SeuBarriga.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage page = new SBLoginPage();
    private SBMenuPage menuSB = new SBMenuPage();
    private SBAccountsPage accountSB = new SBAccountsPage();
    private SBMovementPage movement = new SBMovementPage();
    private SBHomePage homeSB = new SBHomePage();
    private SBResumoPage resumoSB = new SBResumoPage();

    @Before
    public void setup() {
        menu.accessSbNative();
        page.setEmail("bruna@teste.io");
        page.setPwd("123");
        page.enter();
    }

    @Test
    public void shouldInsertAccountSuccess() {
        //entrar em contas
        menuSB.accessAccounts();

        //digitar nome
        accountSB.setAccount("Conta de automação");

        //salvar
        accountSB.save();

        //verificar mensagem
        Assert.assertTrue(accountSB.existElementByText("Conta adicionada com sucesso"));
    }

    @Test
    public void shouldDeleteAccount() {
        //entrar em contas
        menuSB.accessAccounts();

        //clique longo na conta
        accountSB.selectAccount("Conta de teste");

        //excluir
        accountSB.delete();

        //verificar mensagem
        Assert.assertTrue(accountSB.existElementByText("Conta excluída com sucesso"));
    }

    @Test
    public void shouldValidateMov() {
        //validar descrição
        menuSB.accessMovement();
        movement.save();
        Assert.assertTrue(movement.existElementByText("Descrição é um campo obrigatório"));

        //validar interessado
        movement.setDescription("Descrição de teste");
        movement.save();
        Assert.assertTrue(movement.existElementByText("Interessado é um campo obrigatório"));

        //validar valor
        movement.setInterested("Bruna");
        movement.save();
        Assert.assertTrue(movement.existElementByText("Valor é um campo obrigatório"));

        //validar conta
        movement.setValue("1256");
        movement.save();
        Assert.assertTrue(movement.existElementByText("Conta é um campo obrigatório"));

        //inserir com sucesso
        movement.setAccount("Conta de automação");
        movement.save();
        Assert.assertTrue(movement.existElementByText("Movimentação cadastrada com sucesso"));

    }

    @Test
    public void shouldUpdateBalanceWhenDeleteMovement() {

        //verificar saldo
        Assert.assertEquals("534.00", homeSB.getAccountBalace("Conta para saldo"));

        //ir para resumo
        menuSB.accessResume();

        //excluir movimentação
        resumoSB.deleteMovement("Movimentacao 3, calculo saldo");

        //validar mensagem
        Assert.assertTrue(resumoSB.existElementByText("Movimentação removida com sucesso!"));

        //voltar pra home
        menuSB.accessHome();

        //atualizar saldo
        esperar(1000);
        homeSB.scroll(0.2, 0.9);

        //verificar saldo
        Assert.assertEquals("-1000.00", homeSB.getAccountBalace("Conta para saldo"));
    }

}
