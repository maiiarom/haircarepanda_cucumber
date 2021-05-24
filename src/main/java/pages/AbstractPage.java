package pages;

import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(ProviderForDriver.INSTANCE.getDriver(), this);
    }

    public abstract void waitForLoad();
}
