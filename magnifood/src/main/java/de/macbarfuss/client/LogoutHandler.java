package de.macbarfuss.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class LogoutHandler implements ClickHandler {

    public LogoutHandler() {
    }

    public void onClick(final ClickEvent event) {
        showProcessing(true);
        logout();
    }

    /**
     * Deactivate controls and showing a process bar.
     * 
     * @param state
     *            whether the processing has to be shown or hidden.
     */
    private void showProcessing(final boolean state) {
        // TODO add modal dialog with progress bar
        // logoutBtn.setEnabled(!state);
    }

    /**
     * Performs the logout.
     */
    private void logout() {
        // LoginService.Util.getInstance().closeSession(getSessionID(),
        // new AsyncCallback<UserSessionInfo>() {
        //
        // @Override
        // public void onFailure(final Throwable caught) {
        // showProcessing(false);
        // // TODO show general error message on screen.
        // }
        //
        // @Override
        // public void onSuccess(final UserSessionInfo result) {
        // showProcessing(false);
        // AbstractScreen.setSessionInfo(result);
        // Window.Location.reload();
        // }
        // }
        // );
    }
}
