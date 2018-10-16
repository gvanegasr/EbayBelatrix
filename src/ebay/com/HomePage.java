package ebay.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Enrique\\IdeaProjects\\Ebay\\Libraries\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        options.addArguments("start-maximized");
        DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().deleteAllCookies();
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("shoes");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"e1-35\"]/a/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String resultnum = driver.findElement(By.xpath("//*[@id=\"cbelm\"]/div[3]/h1/span[1]")).getText();
        System.out.println(resultnum);
        driver.findElement(By.xpath("//*[@id=\"DashSortByContainer\"]/ul[1]/li/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"SortMenu\"]/li[3]/a")).click();


        ArrayList<String> namesList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.xpath("//div[@class='gvtitle']"));
        for(WebElement we:elementList){
            namesList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:namesList){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        System.out.println(sortedList);

        ArrayList<String> priceList = new ArrayList<>();
        List<WebElement> intList= driver.findElements(By.xpath("//div[@class='prc']"));
        for(WebElement we:intList){
            priceList.add(we.getText());
        }
        ArrayList<String> sortedInt = new ArrayList<>();
        for(String s:priceList){
            sortedInt.add(s);
        }
        Collections.sort(sortedInt);
        Collections.reverse(sortedInt);
        System.out.println(sortedInt);
    }
}
