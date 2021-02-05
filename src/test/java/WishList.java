
import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class WishList {
    private  WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }
    @Test
    public void wishList() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test");
        driver.findElement(By.cssSelector("a.skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title*='Log']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sebastian.rgs@hotmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("IronMaiden1");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector(" #header-account > div > ul > li:nth-child(2) > a")).click();
        WebElement helloMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span"));
        Assert.assertTrue(helloMessage.isDisplayed());
        String message = helloMessage.getText();
        Assert.assertEquals("Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.",message);

    }
    @After
    public void close() {
        driver.close();
    }
}