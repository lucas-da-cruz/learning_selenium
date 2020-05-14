package test.br.com.lance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {

    private WebDriver driver;

    public DetalhesDoLeilaoPage(WebDriver driver){
        this.driver = driver;
    }

    public void lance(String usuario, double valor){
        WebElement txtValor = driver.findElement(By.name("lance.valor"));
        Select cbUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));

        cbUsuario.selectByVisibleText(usuario);
        txtValor.sendKeys(String.valueOf(valor));

        driver.findElement(By.id("btnDarLance")).click();
    }

    public boolean existeLance(String usuario, double valor){
        //Essa classe do selenium, recebe o driver que estã
        //sendo utilizado, e realiza uma pequena pausa para então executar a proxima ação
        //Falamos que no max 10 seg o texto usuario vai ter na tabela lanceDados
        boolean temUsuario = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("lancesDados")), usuario));

        if(temUsuario){
            return driver.getPageSource().contains(String.valueOf(valor));
        }
        return false;
    }

}

