package test.br.com.leilao;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.br.com.usuario.UsuarioPage;

import static org.junit.Assert.assertTrue;

public class LeiloesSystemTest {

    @Test
    public void deveCadastrarUmLeilao() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Devia estar no construtor
        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Lucas da Cruz", "lucas@hotmail.com");

        LeiloesPage leilao = new LeiloesPage(driver);
        leilao.visita();
        leilao.novo().preenche("Geladeira", 123, "Lucas da Cruz", true);

        assertTrue(leilao.existe("Geladeira", 123, "Lucas da Cruz", true));

        driver.close();
    }

    @Test
    public void testaInserirEEditarLeilao() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Devia estar no construtor
        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Lucas da Cruz", "lucas@hotmail.com");

        LeiloesPage leilao = new LeiloesPage(driver);
        leilao.visita();
        leilao.novo().preencheSemValorInicial("Play 3",  "Lucas da Cruz", true);

        assertTrue(driver.getPageSource().contains("Valor inicial deve ser maior que zero!"));

        driver.close();
    }

    @Test
    public void testaLeilaoSemValorInicial() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Devia estar no construtor
        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("joao", "lucas@hotmail.com");

        LeiloesPage leilao = new LeiloesPage(driver);
        leilao.visita();
        leilao.novo().preenche("Computador", 123, "joao", true);

        assertTrue(leilao.existe("Computador", 123, "joao", true));


        driver.close();
    }

}
