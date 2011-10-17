package de.macbarfuss.client;

import com.google.gwt.user.cellview.client.CellBrowser;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public final class IngredientScreen extends AbstractScreen {

    private Panel contentPanel;

    public IngredientScreen() { }

    @Override
    protected void buildUI() {
        contentPanel = new VerticalPanel();
        contentPanel.add(new HTMLPanel("<h1>Ingredients</h1>").asWidget());

        final HorizontalPanel horizontalPanel = new HorizontalPanel();
        contentPanel.add(horizontalPanel);
        horizontalPanel.add(new HTMLPanel("<h1>Ingredients2</h1>").asWidget());
        final CellBrowser browser = new CellBrowser(new IngredientTreeMockUpModel(), null);
//        browser.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
        horizontalPanel.add(browser.asWidget());
        horizontalPanel.add(new HTMLPanel("<h1>Ingredients3</h1>").asWidget());

        contentPanel.add(new Label("Bottom"));
    }

    @Override
    public Panel getContentPanel() {
        return contentPanel;
    }

}
