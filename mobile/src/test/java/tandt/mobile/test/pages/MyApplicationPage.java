package tandt.mobile.test.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import tandt.mobile.BaseMobilePage;
import tandt.mobile.annotations.FindElement;
import tandt.mobile.element.BaseMobileElement;
import tandt.mobile.element.LocatorType;

public class MyApplicationPage extends BaseMobilePage<MyApplicationPage> {
    private AppiumDriver<WebElement> driver;

    @FindElement(type = LocatorType.ID, value="edtUsername")
    private BaseMobileElement edtUsername;

    @FindElement(type = LocatorType.ID, value="edtPassword")
    private BaseMobileElement edtPassword;

    @FindElement(type = LocatorType.ID, value="chbRememberMe")
    private BaseMobileElement chbRememberMe;

    @FindElement(type = LocatorType.ID, value="btnLogin")
    private BaseMobileElement btnLogin;

    @FindElement(type = LocatorType.ID, value="txtErrorMessage")
    private BaseMobileElement txtErrorMessage;

    public MyApplicationPage(AppiumDriver<WebElement> driver) {
        super(driver);
        this.driver = driver;
    }

    public void login(String username, String password, boolean isCheck){
        edtUsername.setText(username);
        edtPassword.setText(password);
        if(isCheck){
            chbRememberMe.click();
        }
        btnLogin.click();
    }

    public boolean isErrorMessageDisplayed(){
        return txtErrorMessage.isDisplayed();
    }

    public String getMessage(){
        return txtErrorMessage.getText();
    }

}
