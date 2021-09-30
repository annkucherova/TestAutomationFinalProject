package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FeedPage;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;

    HomePage homePage;
    FeedPage feedPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void TestsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User switches language to 'Russian'")
    public void switchLanguageToRussian() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnRussianLanguageButton();
    }

    @Then("User checks that the first paragraph contains the word {string}")
    public void checkFirstParagraphContainsExpectedWord(final String expectedWord) {
        homePage = pageFactoryManager.getHomePage();
        assertTrue(homePage.getParagraphs().get(0).getText().contains(expectedWord));
    }

    @When("User clicks on 'Generate Lorem Ipsum' button")
    public void clickOnGenerateLoremIpsumButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnGenerateButton();
    }

    @Then("User checks that the first paragraph starts with text {string}")
    public void checkFirstParagraphStartsWithExpectedText(final String expectedText) {
        feedPage = pageFactoryManager.getFeedPage();
        feedPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(feedPage.getParagraphs().get(0).getText().startsWith(expectedText));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
