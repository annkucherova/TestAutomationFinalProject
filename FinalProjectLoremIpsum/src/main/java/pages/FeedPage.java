package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FeedPage extends BasePage {

    @FindBy(xpath = "//div[@id='lipsum']//p")
    private List<WebElement> paragraphs;

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getParagraphs() {
        return paragraphs;
    }

}
