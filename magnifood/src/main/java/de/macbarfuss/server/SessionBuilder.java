package de.macbarfuss.server;

import java.util.HashMap;
import java.util.Map;

import de.macbarfuss.shared.UserSessionInfo;

public final class SessionBuilder {

    final static Map<String, String> mockKeyStorage = new HashMap<String, String>();
    final static Map<String, UserSessionInfo> mockSessionStorage =
            new HashMap<String, UserSessionInfo>();

    static {
        mockKeyStorage.put("Testuser1", "testkey");
    }
    
    public static Boolean isValidSession(final UserSessionInfo prospect) {
        return mockSessionStorage.containsKey(prospect.getSessionID());
    }

    public static UserSessionInfo getUserSessionInfo(
            final String username, final String passphrase) {
        if (isValidUsernameAndPassphrase(username, passphrase)) {
            return new UserSessionInfo(username, getNewSessionId());
        } else {
            return new UserSessionInfo(username, "", "Username and/or passphrase not valid.");
        }
    }

    private static boolean isValidUsernameAndPassphrase(
            final String username, final String passphrase) {
        return mockKeyStorage.containsKey(username)
                && mockKeyStorage.get(username).equals(passphrase);
    }

    private static String getNewSessionId() {
        return "-1";
    }

    public static void cancelSession(final UserSessionInfo sessionInfo) {
        mockSessionStorage.remove(sessionInfo.getSessionID());
    }
}
