package de.macbarfuss.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public final class SwitchScreenHandler implements ClickHandler {

    private AbstractScreen targetScreen;

    public SwitchScreenHandler(final AbstractScreen newScreen) {
        targetScreen = newScreen;
    }

    public void onClick(final ClickEvent event) {
        targetScreen.show();
    }
}
