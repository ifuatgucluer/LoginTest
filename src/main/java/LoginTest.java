
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // ChromeDriver yolunu belirtin
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        driver.get("https://www.example.com/login");

        // Kullanıcı adı ve şifre alanlarını bulun
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Kullanıcı adı ve şifreyi doldurun
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password123");

        // Giriş butonuna tıklayın
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Başarılı giriş mesajını kontrol edin
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assert successMessage.isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
