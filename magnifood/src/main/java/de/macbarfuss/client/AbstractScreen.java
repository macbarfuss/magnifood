package de.macbarfuss.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractScreen {

// A T T R I B U T E S
//    private static UserSessionInfo sessionInfo;

//    private final Button logoutBtn = new Button("Logout");

    private static final String H1_ID = "heading";
    private final FlowPanel buttonBar = new FlowPanel();
    private final FlowPanel contentPanel = new FlowPanel();


// C O N S T R U C T O R

    public AbstractScreen() {
        final VerticalPanel vPanel = new VerticalPanel();
        vPanel.setBorderWidth(1);
        vPanel.setWidth("100%");
        RootPanel.get().add(vPanel);

        buttonBar.setHeight("50px");
        vPanel.add(buttonBar);

//        prepareLogoutButton();

        vPanel.add(contentPanel);

        prepareHeading();

        setHeadline("");

        buildUI();
    }

private void prepareHeading() {
    HTML heading = new HTML(Document.get().createHElement(1).getString());
    heading.getElement().setId(H1_ID);
    contentPanel.add(heading);
}

// U I   P R E P A R A T I O N
    private void prepareLogoutButton() {
//        buttonBar.add(logoutBtn);
//        logoutBtn.addClickHandler(new LogoutHandler());
    }

// G E T T E R S
    protected static String getSessionID() {
//        return sessionInfo.getSessionID();
        return "";
    }

    protected static String getUsername() {
//        return sessionInfo.getUsername();
        return "";
    }

    public final FlowPanel getContentPanel() {
        return contentPanel;
    }

    public Widget getElementByID(Panel haystack, String needle) {
        Widget element = null;
        for (Widget prospect : haystack) {
            if (prospect.getElement().getId().equals(needle)) {
                element = prospect;
            } else {
                if (prospect instanceof Panel) {
                    element = getElementByID((Panel) prospect, needle);
                }
            }
            if (element != null) {
                return element;
            }
        }
        return null;
    }


// S E T T E R S
//    protected static void setSessionInfo(final UserSessionInfo newSessionInfo) {
//        AbstractScreen.sessionInfo = newSessionInfo;
//    }

    public final void setHeadline(final String headline) {
        Widget heading = getElementByID(getContentPanel(), H1_ID);
        heading.getElement().setInnerText(headline);
    }


// A B S T R A C T   B E H A V I O U R
    /**
     * user interface initial definition.
     */
    protected abstract void buildUI();


// H A N D L E R   C L A S S E S
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

}
