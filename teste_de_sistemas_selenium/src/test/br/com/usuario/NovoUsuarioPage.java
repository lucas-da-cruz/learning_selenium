package test.br.com.usuario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {

    private final WebDriver driver;

    public NovoUsuarioPage(WebDriver driver){
        this.driver = driver;
    }

    public void cadastra(String nome, String email){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebElement txtnome = driver.findElement(By.name("usuario.nome"));
        WebElement txtemail = driver.findElement(By.name("usuario.email"));

        txtnome.sendKeys(nome);
        txtemail.sendKeys(email);

        txtnome.submit();
    }

    public void cadastraSemNome(String email){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));

        txtEmail.sendKeys(email);
        txtEmail.submit();
    }

    public void cadastraSemNomeEEmail(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));

        txtEmail.submit();
    }
}
