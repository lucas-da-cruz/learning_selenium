package test.br.com;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class UsuarioSystemTest {

    @Test
    public void testaInserirUsuario() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //Cenario
        //definindo o endereco web para testar a pagina
        driver.get("http://localhost:8080/usuarios/new");

        //Pegando os elemento de input pelo nome
        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        //inputando informacoes no input
        nome.sendKeys("Joao silva");
        email.sendKeys("joao@silva.com");

        //Acao
        //submetendo o form
        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
        //executando a acao do click
        botaoSalvar.click();

        //Poderia realizar o submit por qualquer elemento
        //da pasta
        //email.submit();

        //validacao
        //Garantir que o usuario foi inserido
        boolean achouNome = driver.getPageSource().contains("Joao silva");
        boolean achouEmail = driver.getPageSource().contains("joao@silva.com");

        assertTrue(achouNome);
        assertTrue(achouEmail);

        driver.close();
    }


    @Test
    public void testaInserirUsuarioSemNome() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/usuarios/new");

        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        email.sendKeys("joao@silva.com");

        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
        botaoSalvar.click();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        driver.close();
    }
}
