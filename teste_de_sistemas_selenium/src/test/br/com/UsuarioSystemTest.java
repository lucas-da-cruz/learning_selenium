package test.br.com;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import test.br.com.usuario.UsuarioPage;

import static org.junit.Assert.assertTrue;

public class UsuarioSystemTest {

    private ChromeDriver driver;
    private UsuarioPage usuarios;

    @Test
    public void testaInserirUsuarioComCodigoEncapsulado() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Lucas da cruz", "lucas@lucas.com");

        assertTrue(usuarios.existeNaListagem("Lucas da Cruz", "lucas@lucas.com"));
    }

    @Test
    public void testaInserirUsuarioDeManeiraLocal(){
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

        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
        botaoSalvar.click();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
        driver.close();
    }

}
