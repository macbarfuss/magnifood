package de.macbarfuss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

public final class WelcomeScreen extends AbstractScreen implements EntryPoint {

    public WelcomeScreen() { }

    @Override
    protected void buildUI() {
        setHeadline("Welcome");

        final Panel contentPanel = getContentPanel();

        contentPanel.add(new Label("User"));
        contentPanel.add(new Label("SessionID"));
    }

    public void onModuleLoad() { }
}
