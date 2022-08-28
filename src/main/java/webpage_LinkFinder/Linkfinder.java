package webpage_LinkFinder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Linkfinder {

    public int linkfinder(String link) {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(link);
        List<WebElement> allWebLinks = driver.findElements(By.tagName("a"));
        System.out.println("Amount of weblinks on website: " + allWebLinks.size());

        driver.quit();
        return allWebLinks.size();
    }
}
