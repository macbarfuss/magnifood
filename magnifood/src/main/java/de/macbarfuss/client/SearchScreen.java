package de.macbarfuss.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Panel;

public final class SearchScreen extends AbstractScreen {

    private Panel contentPanel;

    public SearchScreen() { }

    @Override
    protected void buildUI() {
        contentPanel = new FlowPanel();
        contentPanel.add(new HTMLPanel("<h1>Searching</h1>"));

    }

    @Override
    public Panel getContentPanel() {
        return contentPanel;
    }

}
