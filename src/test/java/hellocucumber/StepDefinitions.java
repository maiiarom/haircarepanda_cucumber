package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import pages.BasketPage;
import pages.ProductsPage;
import pages.MainPage;
import pages.ProviderForDriver;
import utils.Waiters;

public class StepDefinitions {
    MainPage mainPage;
    ProductsPage productsPage;
    BasketPage basketPage;
    int quantityInitial;
    int quantityResult;
    double priceInitial;

    @Given("I login as non registered user on haircarepanda")
    public void i_login_as_non_registered_user_on_haircarepanda() {
        mainPage = new MainPage();
    }

    @Given("I select category {string}")
    public void i_select_category(String string) {
        if (string.equals("gummies")) {
            productsPage = mainPage.navigateProductsPage();
        }
    }

    @Given("I put cursor on product")
    public void i_put_cursor_on_product() {
        Actions action = new Actions(ProviderForDriver.INSTANCE.getDriver());
        action.moveToElement(productsPage.getProductTitleInList()).perform();
    }

    @Given("I add product {string} to basket")
    public void i_add_product_to_basket(String string) {
        if (string.equals("gummies")) {
            productsPage = mainPage.navigateProductsPage();
        }
        Actions action = new Actions(ProviderForDriver.INSTANCE.getDriver());
        action.moveToElement(productsPage.getProductTitleInList()).perform();
        productsPage.buyNowButtonClick();
    }

    @When("I tap on Buy now button")
    public void i_tap_on_buy_now_button() {
        productsPage.buyNowButtonClick();
    }

    @Then("the basket page is displayed with selected previously product")
    public void the_basket_page_is_displayed_with_selected_previously_product() {
        Assert.assertTrue(productsPage.getTextProductTitleInBasket().contains("Hair Care Panda Vegan Gummies"));
    }

    @Given("I navigate to basket")
    public void i_navigate_to_basket() {
        basketPage = productsPage.navigateBasketPage();
    }

    @When("I tap on delete icon near product name")
    public void i_tap_on_delete_icon_near_product_name() {
        basketPage.deleteIconClick();
        basketPage.confirmDeletion();
    }

    @Then("the message Your shopping cart is empty An empty basket is a sad basket is displayed")
    public void the_message_your_shopping_cart_is_empty_an_empty_basket_is_a_sad_basket_is_displayed() {
        Assert.assertTrue(basketPage.getTextShoppingCart().contains("Your shopping cart is empty"));
        Assert.assertTrue(basketPage.getTextShoppingCart().contains("An empty basket is a sad basket"));
    }

    @When("I tap on + icon near product name")
    public void i_tap_on_icon_near_product_name() throws InterruptedException {
        quantityInitial = basketPage.getValueProductQuantity();
        priceInitial = basketPage.getValueProductPrice();
        basketPage.plusIconClick();
    }

    @Then("the quantity of products is increased")
    public void the_quantity_of_products_is_increased() {
        String quantityCheckString = String.valueOf(quantityInitial + 1);
        Waiters.waitForChangedValue(basketPage.getProductQuantity(), 5, "value", quantityCheckString);
        quantityResult = basketPage.getValueProductQuantity();
        Assert.assertEquals(quantityInitial + 1, quantityResult);
    }

    @Then("the price is calculated correctly")
    public void the_price_is_calculated_correctly() {
        double priceResult = basketPage.getValueProductPrice();
        Assert.assertTrue(priceResult == priceInitial * quantityResult);

    }
}