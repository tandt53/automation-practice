package tandt.cucumber.test.mobile;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import tandt.cucumber.test.mobile.components.AndroidComponent;
import tandt.cucumber.test.mobile.components.HomeComponent;
import tandt.cucumber.test.mobile.components.IosComponent;

public class HomePageBinder extends AbstractModule {
    @Override
    protected void configure() {
        bind(HomeComponent.class).annotatedWith(Names.named("android")).to(AndroidComponent.class).in(Scopes.SINGLETON);
        bind(HomeComponent.class).annotatedWith(Names.named("ios")).to(IosComponent.class).in(Scopes.SINGLETON);
    }
}
