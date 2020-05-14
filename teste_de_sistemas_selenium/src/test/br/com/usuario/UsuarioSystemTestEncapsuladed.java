package test.br.com.usuario;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsuarioSystemTestEncapsuladed {

    @Test
    public void testaInserirUsuarioComCodigoEncapsulado() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Lucas da cruz", "lucas@lucas.com");

        assertTrue(usuarios.existeNaListagem("Lucas da cruz", "lucas@lucas.com"));
    }

    @Test
    public void testaInserirUsuarioSemNomeEncapsulado() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastraSemNome("Lucas da cruz");

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        driver.close();
    }

    @Test
    public void testaInserirUsuarioSemNomeEEmailEncapsulado() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastraSemNomeEEmail();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
        driver.close();
    }

    @Test
    public void deveDeletarUmUsuario() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        UsuarioPage usuarios = new UsuarioPage(driver);

        usuarios.visita();
        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
        assertTrue(usuarios.existeNaListagem ("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));

        usuarios.deletaUsuarioNaPosicao(1);

        assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
        driver.close();
    }

    @Test
    public void deveEditarUsuario(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        UsuarioPage usuarios = new UsuarioPage(driver);

        usuarios.visita();
        usuarios.novo().cadastra("Joao", "ronaldo2009@terra.com.br");
        assertTrue(usuarios.existeNaListagem ("Joao", "ronaldo2009@terra.com.br"));

        usuarios.editarUsuarioNaPosicao(1, "Joao Silva", "ronaldo@terra.com");

        assertTrue(usuarios.existeNaListagem("Joao Silva", "ronaldo@terra.com"));
        driver.close();
    }

}
