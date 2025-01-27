package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MapPageBase extends AbstractPage {

    public MapPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isZoomButtonPresent(ZoomButton zoomBth);

    public abstract boolean isOpened();

    public abstract int getZoomBtnYCoordinate(ZoomButton zoomBtn);

    public abstract boolean isZoomInAboveZoomOut();
}
