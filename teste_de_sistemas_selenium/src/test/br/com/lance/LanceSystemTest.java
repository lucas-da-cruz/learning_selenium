package test.br.com.lance;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.br.com.leilao.LeiloesPage;
import test.br.com.usuario.UsuarioPage;

public class LanceSystemTest {

    @Test
    public void deveFazerUmLance(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/apenas-teste/limpa");

        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
        usuarios.novo().cadastra("Jose Eduardo", "jose@eduardo.com");

        LeiloesPage leiloes = new LeiloesPage(driver);

        leiloes.visita();
        leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);

        //driver.get("http://localhost:8080/usuarios");

        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

        lances.lance("Jose Eduardo", 150);

        Assert.assertTrue(lances.existeLance("Jose Eduardo", 150));

        driver.close();
    }
}
