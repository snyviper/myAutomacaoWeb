import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class AutomacaoBatista {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup(){
        // Setar as propriedades do Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,100);
        // Abrir o browser e acessar a URL
        driver.get("https://automacaocombatista.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Começar Automação Web']")).click();
        //Maximizando o Borwser no Windows
        driver.manage().window().maximize();
    }

    @Test
    public void criarUsuario(){
        Random random = new Random();
        String email = random.nextInt(10000)+"@gmail.com.br";

        // Identificando um elemento e preenchendo o campo com um texto
        driver.findElement(By.xpath("//a[text()='Formulário']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Criar Usuários']"))));
        driver.findElement(By.xpath("//a[text()='Criar Usuários']")).click();
        driver.findElement(By.id("user_name")).sendKeys("Gustavo");
        driver.findElement(By.id("user_lastname")).sendKeys("Costa");
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_address")).sendKeys("Rua dos Morros nº 0");
        driver.findElement(By.id("user_university")).sendKeys("UTFPR - Medianeira");
        driver.findElement(By.id("user_profile")).sendKeys("QA externo");
        driver.findElement(By.id("user_gender")).sendKeys("Masculino");
        driver.findElement(By.id("user_age")).sendKeys("24");

        // Clicando no botao Criar
        driver.findElement(By.name("commit")).click();

        // Atribuindo o texto da mensagem na tela para a variável
        String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();

        // Validando se a mensagem que eu necessito está sendo exibida na tela
        Assertions.assertEquals("Usuário Criado com sucesso", mensagem);
    }

    @Test
    public void radioCheckBox(){
        driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Radio e Checkbox']"))));
        driver.findElement(By.xpath("//a[text()='Radio e Checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='red']")).click();
        driver.findElement(By.xpath("//label[@for='blue']")).click();
        driver.findElement(By.xpath("//label[@for='yellow']")).click();
        driver.findElement(By.xpath("//label[@for='green']")).click();
        driver.findElement(By.xpath("//label[@for='purple']")).click();
        driver.findElement(By.xpath("//label[@for='grey']")).click();
        driver.findElement(By.xpath("//label[@for='black']")).click();
        driver.findElement(By.xpath("//label[@for='white']")).click();
    }

    @Test
    public void select(){
        driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Dropdown e Select']")));

        driver.findElement(By.xpath("//a[text()='Dropdown e Select']")).click();

        driver.findElement(By.xpath("//label[text()='Desenho Favorito']/preceding-sibling::div[@class='select-wrapper']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Dragon Ball']")));
        driver.findElement(By.xpath("//span[text()='Dragon Ball']")).click();

        driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']/ancestor::ul/preceding-sibling::input")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Ronaldinho Gaucho']")));
        //WebElement segundoCombo1 = driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']"));
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[0].click();",segundoCombo1);
        driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']")).click();

        WebElement listaSelecao = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select listaDesenhoFavorito = new Select(listaSelecao);

        listaDesenhoFavorito.selectByIndex(1);
        //listaDesenhoFavorito.selectByValue("2");
        //listaDesenhoFavorito.selectByVisibleText("Internet Explorer");
    }

    @AfterAll
    public static void fecharBrowser(){
        // Fechando o navegador
        driver.quit();
    }
}
