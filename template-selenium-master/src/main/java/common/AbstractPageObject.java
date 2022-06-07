package common;

import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPageObject {

    public AbstractPageObject() {
        PageFactory.initElements(BaseTest.getDriver(), this);
    }
}
