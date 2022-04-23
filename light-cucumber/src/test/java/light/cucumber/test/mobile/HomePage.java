package light.cucumber.test.mobile;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import light.cucumber.test.mobile.components.HomeComponent;
import light.mobile.page.BasePage;
import light.mobile.page.PageFactory;

@ScenarioScoped
public class HomePage extends BasePage<HomePage> {

    private HomeComponent homeComponent;

    @Inject
    public HomePage(PageFactory pageManager){
        homeComponent = pageManager.create(HomeComponent.class);
    }

    public void login(String username, String password) {
        homeComponent.login(username, password, true);
    }

    public String getMessage(){
        return homeComponent.getMessage();
    }
}