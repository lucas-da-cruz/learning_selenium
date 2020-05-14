package test.br.com.usuario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.br.com.URLDaAplicacao;

public class UsuarioPage {

    private WebDriver driver;

    public UsuarioPage(WebDriver driver){
        this.driver = driver;
    }

    public void visita(){
        //Url que limpa a base de dados antes de iniciar a base.
        //Busca o dominio de uma classe só
        driver.get(new URLDaAplicacao() +"/apenas-teste/limpa");
        driver.get("http://localhost:8080/usuarios");
    }

    public NovoUsuarioPage novo(){
        driver.findElement(By.linkText("Novo Usuário")).click();
        return new NovoUsuarioPage(driver);
    }

    public boolean existeNaListagem(String nome, String email){
        return driver.getPageSource().contains(nome) &&
                driver.getPageSource().contains(email);
    }

    public void deletaUsuarioNaPosicao(int posicao) {
        driver.findElements(By.tagName("button")).get(posicao-1).click();
        // pega o alert que está aberto
        Alert alert = driver.switchTo().alert();
        // confirma
        alert.accept();
    }

    public void editarUsuarioNaPosicao(int posicao, String nome, String email) {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        driver.findElements(By.linkText("editar")).get(posicao-1).click();

        WebElement txtnome = driver.findElement(By.name("usuario.nome"));
        WebElement txtemail = driver.findElement(By.name("usuario.email"));

        txtnome.clear();
        txtemail.clear();

        txtnome.sendKeys(nome);
        txtemail.sendKeys(email);

        txtnome.submit();
    }
}
