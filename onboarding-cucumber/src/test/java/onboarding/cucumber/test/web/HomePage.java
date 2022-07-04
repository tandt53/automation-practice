package onboarding.cucumber.test.web;

import onboarding.ui.element.Element;
import onboarding.ui.element.WaitStrategy;
import onboarding.web.BaseWebPage;
import onboarding.web.annotations.FindElement;
import onboarding.web.element.WebLocatorType;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseWebPage<HomePage> {

    @FindElement(type = WebLocatorType.XPATH, value = "//*[@class='gLFyf gsfi']", waitUntil = WaitStrategy.VISIBILITY)
    private Element searchField;

    @FindBy(id = "_fZl")
    private org.openqa.selenium.WebElement searchButton;

    public void search(String keyword) {
        searchField.setText(keyword);
        searchField.submit();
    }
}