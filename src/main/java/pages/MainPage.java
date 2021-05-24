package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

public class MainPage extends AbstractPage{

    // page elements
    @FindBy(css="[href*=\"zelki\"] .borders")
    private WebElement categoryGummies;
    @FindBy(css="[src*=\"logo.png\"]")
    private WebElement pageLogo;
    @FindBy(css=".col-12.col-sm-3.btn-wrap>button")
    private WebElement cookiesButton;

    public MainPage() {
        super();
        waitForLoad();
        cookiesButtonClick();
    }

    @Override
    public void waitForLoad(){
        Waiters.waitForElementToBeVisible(pageLogo, Constants.TIME_LOAD_ELEMENT);
    }

    public void cookiesButtonClick(){
        cookiesButton.click();
    }

    public void categoryGummiesClick(){
        categoryGummies.click();
    }

    public ProductsPage navigateProductsPage(){
        categoryGummiesClick();
        return new ProductsPage();
    }

    public WebElement getCategoryGummies() {
        return categoryGummies;
    }

    public WebElement getPageLogo() {
        return pageLogo;
    }
}
