package de.macbarfuss.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.macbarfuss.shared.UserSessionInfo;

@RemoteServiceRelativePath("sessions")
public interface SessionService extends RemoteService {

    UserSessionInfo startSession(String username, String passphrase);

    void stopSession(UserSessionInfo sessionInfo);
}
