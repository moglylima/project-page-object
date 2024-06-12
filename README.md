# Projeto de Automação de Testes com Page Objects

Este projeto demonstra o uso do padrão Page Object em testes de automação utilizando Selenium WebDriver com Java. O padrão Page Object ajuda a organizar o código de teste, melhorando a manutenção e a legibilidade.

## Ambiente de Testes
Por se tratar de um ambiente simples, como o foco é apenas há configuração de um ambiente de testes usando selenium, foi realizada uma pequena iteração com um formulário onde:
1. Será aberto a página de Login;
2. Preenchimento dos campos `name` e `Email Address`;
3. Click no Botão de `Signup`;
4. Verificação se ocorreu o redirecionamento para próxima tela, onde é verificado se contem o seguinte trecho `Enter Account Information`.
## Estrutura do Projeto

- `src/main/java/com/example/pages`: Contém classes que representam páginas específicas da aplicação, onde serão construídos métodos visando apenas iterações com a página(preenchimento de campus, clicks em botões e etc), isso visando reuso de código.
- `src/main/java/com/example/support`: Contém classes de configuração e utilitários.
- `src/test/java/com/example/test`: Contém classes de testes onde serão realizadas as asserções/verificações.

## Configuração do Ambiente

1. **Instalar JDK**: Versão 17.
2. **Editor/IDE**: VS Code.
3. **Adicionar dependências do Selenium**: Utilizando Maven, adicione as seguinted dependênciad ao `pom.xml`.:

**Selenium**
```
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.20.0</version>
</dependency>

```
**Junit**
```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```
4. **Baixar WebDriver**: Baixe o driver correspondente ao navegador que você deseja utilizar(Edge, Chrome ou Firefox).
    
## Estrutura de Classes

### BasePage

A classe `BasePage` contém métodos e propriedades comuns a todas as páginas.
```java
package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}
```
### WebSetup
A classe `WebSetup` contém a configuração necessária visando uso do driver, inicializar o navegador, bem como fechar o mesmo.
```java
package com.example.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSetup {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
```


### PreCadastroPage
A classe `PreCadastroPage` contém todos os atributos e métodos necessários para iteração com a página que será testada.
```java
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
```

## Como Executar os Testes

1. **Clone o repositório**:
```
mvn clean test
```
2. **Configurar o caminho do WebDriver**: Edite a classe `WebSetup` com o caminho correto do WebDriver baixado.
    ```java
    System.setProperty("webdriver.chrome.driver", "/caminho/para/seu/chromedriver");
    ```

3. **Executar os testes**: Utilize IDE ou linha de comando. 

    **Usando terminal:**

       mvn clean test
