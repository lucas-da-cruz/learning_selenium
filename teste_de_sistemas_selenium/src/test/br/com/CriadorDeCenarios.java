package test.br.com;

import org.openqa.selenium.WebDriver;
import test.br.com.leilao.LeiloesPage;
import test.br.com.usuario.UsuarioPage;

class CriadorDeCenarios {

    private WebDriver driver;

    public CriadorDeCenarios(WebDriver driver) {
        this.driver = driver;
    }

    public CriadorDeCenarios umUsuario(String nome, String email) {
        UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra(nome, email);

        return this;
    }

    public CriadorDeCenarios umLeilao(String usuario,
                                      String produto,
                                      double valor,
                                      boolean usado) {
        LeiloesPage leiloes = new LeiloesPage(driver);
        leiloes.visita();
        leiloes.novo().preenche(produto, valor, usuario, usado);

        return this;
    }

}
