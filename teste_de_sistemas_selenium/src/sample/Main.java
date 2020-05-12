package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lucas da Cruz\\Documents\\chromer_driver\\chromedriver.exe");

        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com.br");

        //buscando o elemento de text por nome do html
        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Caelum");

        //Submetendo o form
        campoDeTexto.submit();
    }
}
