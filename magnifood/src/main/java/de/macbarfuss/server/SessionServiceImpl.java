package de.macbarfuss.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.macbarfuss.client.SessionService;
import de.macbarfuss.shared.UserSessionInfo;

public class SessionServiceImpl extends RemoteServiceServlet implements SessionService {

    private static final long serialVersionUID = -8592844472294919736L;

    public UserSessionInfo startSession(String username, String passphrase) {
        return SessionBuilder.getUserSessionInfo(username, passphrase);
    }

    public void stopSession(UserSessionInfo sessionInfo) {
        // TODO check if user has appropriate rights
        SessionBuilder.cancelSession(sessionInfo);     
    }
}
