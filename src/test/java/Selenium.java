import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Selenium {

    private static WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver,100);

    @BeforeAll
    public static void setup(){
        // Setar as propriedades do Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Abrir o browser e acessar a URL
        driver.get("https://automacaocombatista.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Começar Automação Web']"));
        //Maximizando o Borwser no Windows
        driver.manage().window().maximize();
    }

    @Test
    public void criarUsuario(){
        Random random = new Random();
        String email = random.nextInt(10000)+"@gmail.com.br";

        driver.findElement(By.xpath("//a[text()='Formulário']")).click();
        driver.findElement(By.xpath("//a[text()='Criar Usuários']")).click();

        // Identificando um elemento e preenchendo o campo com um texto
        driver.findElement(By.id("user_name")).sendKeys("Gustavo");
        driver.findElement(By.id("user_lastname")).sendKeys("Costa");
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_address")).sendKeys("Rua dos Morros nº 0");
        driver.findElement(By.id("user_university")).sendKeys("UTFPR - Medianeira");
        driver.findElement(By.id("user_profile")).sendKeys("QA externo");
        driver.findElement(By.id("user_gender")).sendKeys("Masculino");
        driver.findElement(By.id("user_age")).sendKeys("24");
        driver.findElement(By.name("commit")).click();


        String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();
        Assertions.assertEquals("Usuário Criado com sucesso", mensagem);
    }

    @Test
    public void radioCheckBox(){
        driver.findElement(By.xpath("//a[text()='Busca de Elementos']")).click();
        WebElement link = driver.findElement(By.xpath("//a[text()='Radio e Checkbox']"));
        wait.until(ExpectedConditions.visibilityOf(link));
        driver.findElement(By.xpath("//a[text()='Radio e Checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='red']")).click();
        driver.findElement(By.xpath("//label[@for='blue']")).click();
        driver.findElement(By.xpath("//label[@for='yellow']")).click();
        driver.findElement(By.xpath("//label[@for='green']")).click();
        driver.findElement(By.xpath("//label[for='purple']")).click();
        driver.findElement(By.xpath("//label[for='gray']")).click();
        driver.findElement(By.xpath("//label[for='black']")).click();
        driver.findElement(By.xpath("//label[for='white']")).click();

    }

    @AfterAll
    public static void fecharBrowser(){
        // Fechando o navegador
        driver.quit();
    }
}
