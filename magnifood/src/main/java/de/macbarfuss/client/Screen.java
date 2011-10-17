package de.macbarfuss.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public final class Screen {

    private static final int BUTTON_SIZE = 10;

    private static Screen singleton;

    private final Button logoutBtn = new Button("Logout");

    private Panel contentPanel = new FlowPanel();

    private final VerticalPanel vPanel = new VerticalPanel();
    private final DockLayoutPanel buttonBar = new DockLayoutPanel(Unit.EM);

    private final Button homeButton = new Button("Home");

    private Screen() {
        vPanel.setBorderWidth(1);
        vPanel.setWidth("100%");
        RootPanel.get().add(vPanel);
    }

    public static Screen getInstance() {
        if (singleton == null) {
            singleton = new Screen();
        }
        return singleton;
    }

    // U I   P R E P A R A T I O N
    public void prepareButtonBar() {
        buttonBar.setHeight("50px");
        vPanel.add(buttonBar);

        buttonBar.addWest(homeButton, BUTTON_SIZE);
        homeButton.addClickHandler(new SwitchScreenHandler(new WelcomeScreen()));

        final Button ingredientButton = new Button("Ingredients");
        buttonBar.addWest(ingredientButton, BUTTON_SIZE);
        ingredientButton.addClickHandler(new SwitchScreenHandler(new IngredientScreen()));

        prepareLogoutButton();

        final Label userName = new Label("eingeloggt als: MacBarfuss");
        buttonBar.addEast(userName, BUTTON_SIZE);
    }

    private void prepareLogoutButton() {
        buttonBar.addEast(logoutBtn, BUTTON_SIZE);
        logoutBtn.addClickHandler(new LogoutHandler());
    }

// G E T T E R S
    public Panel getContentPanel() {
        return contentPanel;
    }

// S E T T E R S
    public void setContentPanel(final Panel newContentPanel) {
        contentPanel.removeFromParent();
        contentPanel = newContentPanel;
        vPanel.add(newContentPanel);
    }

// H A N D L E R S
    public void showHome() {
        homeButton.click();
    }

    public void show(final AbstractScreen newScreen) {
        setContentPanel(newScreen.getContentPanel());
    }
}
