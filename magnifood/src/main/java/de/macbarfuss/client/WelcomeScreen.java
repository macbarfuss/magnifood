package de.macbarfuss.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

public final class WelcomeScreen extends AbstractScreen {

    private Panel contentPanel;

    public WelcomeScreen() {
    }

    @Override
    protected void buildUI() {
        contentPanel = new FlowPanel();
        contentPanel.add(new HTMLPanel("<h1>Welcome</h1>"));
        contentPanel.add(new Label("SessionID"));
    }

    @Override
    public Panel getContentPanel() {
        return contentPanel;
    }
}
