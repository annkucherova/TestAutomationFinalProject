package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[text()='Pyccкий']")
    private WebElement russianLanguageButton;

    @FindBy(xpath = "//div[@id='Panes']//p")
    private List<WebElement> paragraphs;

    @FindBy(xpath = "//input[@name='generate']")
    private WebElement generateButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnRussianLanguageButton() {
        russianLanguageButton.click();
    }

    public List<WebElement> getParagraphs() {
        return paragraphs;
    }

    public void clickOnGenerateButton() {
        generateButton.click();
    }
}
