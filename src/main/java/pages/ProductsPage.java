package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

public class ProductsPage extends AbstractPage{
    @FindBy(css="[href*=\"hair-care-panda-vegan-gummies\"] >.txt")
    private WebElement productTitleInList;
    @FindBy(css=".name-cell")
    private WebElement productTitleInBasket;
    @FindBy(css=".row.row-product-thumbs a > span.txt > span.btn.btn-primary > strong")
    private WebElement buyNowButton;
    @FindBy(css="[src*=\"logo.png\"]")
    private WebElement pageLogo;
    @FindBy(css=".table-cart-small-footer > a")
    private WebElement myBasketButton;

    public ProductsPage() {
        super();
        waitForLoad();
    }

    @Override
    public void waitForLoad(){
        Waiters.waitForElementToBeVisible(pageLogo, Constants.TIME_LOAD_ELEMENT);
    }

    public void buyNowButtonClick(){
        buyNowButton.click();
    }

    public String getTextProductTitleInBasket(){
        Waiters.waitForElementToBeVisible(productTitleInBasket, 5);
        return productTitleInBasket.getText();
    }

    public WebElement getProductTitleInBasket() {
        return productTitleInBasket;
    }

    public WebElement getProductTitleInList() {
        return productTitleInList;
    }

     public String getTextProductTitleInList(){
        return productTitleInList.getText();
    }

    public void myBasketButtonClick(){
        Waiters.waitForElementToBeVisible(myBasketButton, 5);
        myBasketButton.click();
    }

    public BasketPage navigateBasketPage(){
        myBasketButtonClick();
        return new BasketPage();
    }

    public WebElement getMyBasketButton() {
        return myBasketButton;
    }

    public WebElement getBuyNowButton() {
        return buyNowButton;
    }

    public WebElement getPageLogo() {
        return pageLogo;
    }
}
