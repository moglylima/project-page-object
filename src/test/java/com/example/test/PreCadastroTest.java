package com.example.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;

import com.example.pages.PreCadastroPage;
import com.example.support.WebSetup;

public class PreCadastroTest {

    private WebDriver driver;
    private PreCadastroPage preCadastroPage;

    @Before
    public void setUp() {
        driver = WebSetup.getDriver();
        preCadastroPage = new PreCadastroPage(driver);
        preCadastroPage.navigateTo("https://automationexercise.com/login");
    }

    @Test
    public void testPreCadastro() {
        preCadastroPage.fillInName("Teste 01");
        preCadastroPage.fillInPassword("12aasdsad3456@gmail.com");
        preCadastroPage.clickButtonSingUp();

        assertTrue(driver.getPageSource().contains("Enter Account Information"));
    }

    @After
    public void tearDown() {
        WebSetup.closeDriver();
    }
}
