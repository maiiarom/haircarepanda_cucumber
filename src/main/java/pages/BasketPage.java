package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

public class BasketPage extends AbstractPage{
    @FindBy(css="[src*=\"logo.png\"]")
    private WebElement pageLogo;
    @FindBy(css=".biger-text >.delete")
    private WebElement deleteIcon;
    @FindBy(css=".px20")
    private WebElement shoppingCart;
    @FindBy(css=".plus")
    private WebElement plusIcon;
    @FindBy(css=".quantity-box input")
    private WebElement productQuantity;
    @FindBy(css=".text-center.pull-right")
    private WebElement productPrice;

    public BasketPage() {
        super();
        waitForLoad();
    }

    @Override
    public void waitForLoad(){
        Waiters.waitForElementToBeVisible(pageLogo, Constants.TIME_LOAD_ELEMENT);
    }

    public void deleteIconClick(){
        deleteIcon.click();
    }

    public void plusIconClick(){
        plusIcon.click();
        Waiters.waitForElementToBeVisible(productQuantity, 5);
    }

    public String getTextShoppingCart(){
        Waiters.waitForElementToBeVisible(shoppingCart, Constants.TIME_LOAD_ELEMENT);
        return shoppingCart.getText();
    }

    public void confirmDeletion(){
        Alert alert = ProviderForDriver.INSTANCE.getDriver().switchTo().alert();
        alert.accept();
    }

    public int getValueProductQuantity(){
        Waiters.waitForElementToBeVisible(productQuantity, 5);
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }

    public double getValueProductPrice(){
        char space = ' ';
        String priceString = productPrice.getText();
        int spaceIndex = priceString.indexOf(space);
        priceString = priceString.substring(0, spaceIndex);
        priceString = priceString.replace(",", ".");
        return Double.parseDouble(priceString);
    }

    public WebElement getProductQuantity() {
        return productQuantity;
    }
}
