package pages;

import org.openqa.selenium.WebDriver;

public class PageBase {

    protected static WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

}
