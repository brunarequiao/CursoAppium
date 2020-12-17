package br.ce.wcaquino.appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Challenge {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void login() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\topi\\IdeaProjects\\CursoAppium\\src\\main\\resources\\CTAppium11-200120-201928.apk");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //abre formulário
        MobileElement open = driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
        open.click();
    }

    @After
    private void tearDown() {
        driver.quit();
    }

    @Test
    public void openForm() {

        //preenche nome
        MobileElement name = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='nome']"));
        name.sendKeys("Bruna");

        //seleciona jogo
        MobileElement game = driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='console']"));
        game.click();
        MobileElement select = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']"));
        select.click();

        //marca a checkbox
        driver.findElement(By.className("android.widget.CheckBox")).click();


        //desmarca o switch
        MobileElement uncheck = driver.findElement(By.className("android.widget.Switch"));
        uncheck.click();

        //salva
        driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();

        //valida todos os dados inseridos
        MobileElement compareName = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Bruna']"));
        assertEquals("Nome: Bruna", compareName.getText());

        MobileElement compareGame = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        assertEquals("Console: ps4", compareGame.getText());

        MobileElement slider = driver.findElement(By.xpath("//android.widget.TextView[@text='Slider: 25']"));
        assertEquals("Slider: 25", slider.getText());

        MobileElement switchCheck = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']"));
        assertTrue(switchCheck.getText().endsWith("Off"));

        MobileElement checkbox = driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
        assertEquals("Checkbox: Marcado", checkbox.getText());

        MobileElement date = driver.findElement(By.xpath("//android.widget.TextView[@text='Data: 01/01/2000']"));
        assertEquals("Data: 01/01/2000", date.getText());

        MobileElement hour = driver.findElement(By.xpath("//android.widget.TextView[@text='Hora: 06:00']"));
        assertEquals("Hora: 06:00", hour.getText());

    }
}
