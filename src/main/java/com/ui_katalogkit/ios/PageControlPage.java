package com.ui_katalogkit.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.ui_katalogkit.common.PageControlPageBase;
import com.ui_katalogkit.common.UiCatalogPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PageControlPageBase.class)
public class PageControlPage extends PageControlPageBase {
    public PageControlPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Page Control\"]")
    private ExtendedWebElement pageName;

    @Override
    public boolean isOpened() {
        return pageName.isElementPresent();
    }
}
