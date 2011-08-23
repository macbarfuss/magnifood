package de.macbarfuss.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public final class Screen {

    private static Screen singleton;

    private final Button logoutBtn = new Button("Logout");

    private Panel contentPanel = new FlowPanel();

    private final VerticalPanel vPanel = new VerticalPanel();
    private final FlowPanel buttonBar = new FlowPanel();

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

        buttonBar.add(homeButton);
        homeButton.addClickHandler(new SwitchScreenHandler(new WelcomeScreen()));

        final Button searchButton = new Button("Search");
        buttonBar.add(searchButton);
        searchButton.addClickHandler(new SwitchScreenHandler(new SearchScreen()));

        prepareLogoutButton();
    }

    private void prepareLogoutButton() {
        buttonBar.add(logoutBtn);
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
        RootPanel.get().add(newContentPanel);
    }

// H A N D L E R S
    public void showHome() {
        homeButton.click();
    }

    private class LogoutHandler implements ClickHandler {

        public LogoutHandler() { }

        public void onClick(final ClickEvent event) {
            showProcessing(true);
            logout();
        }

        /**
         * Deactivate controls and showing a process bar.
         *
         * @param state whether the processing has to be shown or hidden.
         */
        private void showProcessing(final boolean state) {
            // TODO add modal dialog with progress bar
//            logoutBtn.setEnabled(!state);
        }

        /**
         * Performs the logout.
         */
        private void logout() {
//            LoginService.Util.getInstance().closeSession(getSessionID(),
//                new AsyncCallback<UserSessionInfo>() {
//
//                    @Override
//                    public void onFailure(final Throwable caught) {
//                        showProcessing(false);
//                        // TODO show general error message on screen.
//                    }
//
//                    @Override
//                    public void onSuccess(final UserSessionInfo result) {
//                        showProcessing(false);
//                        AbstractScreen.setSessionInfo(result);
//                        Window.Location.reload();
//                    }
//                }
//            );
        }
    }

    public void show(final AbstractScreen newScreen) {
        setContentPanel(newScreen.getContentPanel());
    }
}
