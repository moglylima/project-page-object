package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.BasePage;

public class PreCadastroPage extends BasePage {

    private By inputName = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");

    private By inputPassword = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");

    private By btnSingUp = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    public PreCadastroPage(WebDriver driverBrowser) {
        super(driverBrowser);
    }

    public void fillInName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void fillInPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickButtonSingUp() {
        driver.findElement(btnSingUp).click();
    }
}
