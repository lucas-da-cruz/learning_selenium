package test.br.com.usuario;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class UsuarioSystemTest {
    @Test
    public void testaInserirUsuarioDeManeiraLocal(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Cenario
        //definindo o endereco web para testar a pagina
        driver.get("http://localhost:8080/usuarios");

        //Pegando os elemento de input pelo nome
        WebElement linkNovoUsuario = driver.findElement(By.linkText("Novo Usuário"));
        linkNovoUsuario.click();

        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        nome.sendKeys("Joao Silva");
        email.sendKeys("joao@silva.com");

        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
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

        //validacao
        driver.close();
    }

    @Test
    public void testaInserirUsuarioSemNome() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/usuarios");
        driver.findElement(By.linkText("Novo Usuário")).click();

        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        email.sendKeys("joao@silva.com");

        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
        botaoSalvar.click();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        driver.close();
    }

    @Test
    public void testaInserirUsuarioSemNomeEEmail() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/usuarios/new");

        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
        botaoSalvar.click();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
        driver.close();
    }

}
