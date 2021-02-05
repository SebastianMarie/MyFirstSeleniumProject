
import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
    private  WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }
    @Test
    public void registerTest() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test");
        driver.findElement(By.cssSelector("a.skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title*='Log']")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Sebastian");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Marie");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("sebastian.rgs@hotmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("IronMaiden1");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("IronMaiden1");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement helloMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li"));
        Assert.assertTrue(helloMessage.isDisplayed());
        String message = helloMessage.getText();
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.",message);


    }
    @After
    public void close() {
        driver.close();
    }
}