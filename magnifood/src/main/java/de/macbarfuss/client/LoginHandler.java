package de.macbarfuss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class LoginHandler implements ClickHandler {

    public void onClick(ClickEvent event) {
        // TODO replace with call to SessionService and session handling.

        SessionServiceAsync sessionService = GWT.create(SessionService.class);

        Screen.getInstance().prepareButtonBar();
        Screen.getInstance().showHome();
    }
}
