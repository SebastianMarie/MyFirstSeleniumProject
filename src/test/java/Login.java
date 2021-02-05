
import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    private  WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void login() {

        driver.findElement(By.cssSelector("a.skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title*='Log']")).click();
        driver.findElement(By.cssSelector("input[name*='username']")).sendKeys("sebastian.rgs@hotmail.com");
        driver.findElement(By.cssSelector("input[name*='password']")).sendKeys("IronMaiden1");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement helloMessage = driver.findElement(By.cssSelector("p strong"));
        Assert.assertTrue(helloMessage.isDisplayed());
        String message = helloMessage.getText();
        Assert.assertEquals("Hello, Sebastian Marie!",message);
    }
    @Test

    public void invalidEmailLogin() {
        driver.findElement(By.cssSelector("a.skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title*='Log']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sebastian.rg@hotmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("IronMaiden1");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement errorMessage = driver.findElement(By.cssSelector("p strong"));
        String message2 = errorMessage.getText();
        Assert.assertEquals("Invalid login or password.",message2);
    }
    @Test
    public void invalidPasswordLogin() {
        driver.findElement(By.cssSelector("a.skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title*='Log']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sebastian.rg@hotmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("IroMaiden1");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement errorMessage = driver.findElement(By.cssSelector("p strong"));
        String message2 = errorMessage.getText();
        Assert.assertEquals("Invalid login or password.",message2);
    }



    @After
    public void close() {
        driver.close();
    }

}