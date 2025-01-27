package com.mfp.android.components;


import com.mfp.common.componentsBase.BottomNavigationBarBase;
import com.mfp.common.enums.BottomBarButton;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BottomNavigationBarBase.class)
public class BottomNavigationBar extends BottomNavigationBarBase implements ICustomTypePageFactory {

    @FindBy(id = "com.myfitnesspal.android:id/action_%s")
    private ExtendedWebElement menuIcon;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/bottomNavigationBar']/child::*")
    private ExtendedWebElement container;

    public BottomNavigationBar(WebDriver driver) {
        super(driver);
    }
    public BottomNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AbstractPage clickMenuIcon (BottomBarButton barButton){
        menuIcon.format(barButton.getValue()).click();
        return initPage(getDriver(), barButton.getPageClass());
    }

    @Override
    public boolean isBottomNavBarPresent (){
        return container.isPresent();
    }

    @Override
    public Boolean isBottomNavBarClickable(BottomBarButton bottomBarButton){
        return Boolean.parseBoolean(menuIcon.format(bottomBarButton.getValue()).getAttribute("clickable"));
    }
}
