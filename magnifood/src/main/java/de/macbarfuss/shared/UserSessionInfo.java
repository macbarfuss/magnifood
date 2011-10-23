package de.macbarfuss.shared;

public final class UserSessionInfo {

    private final String username;
    private final String sessionID;
    private String statusMessage;

    public UserSessionInfo(final String theUsername, final String theSessionID) {
        username = theUsername;
        sessionID = theSessionID;
    }
    
    public UserSessionInfo(
            final String theUsername, final String theSessionID, final String message) {
        username = theUsername;
        sessionID = theSessionID;
        statusMessage = message;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getMessage() {
        return statusMessage;
    }

    public void setMessage(final String newMessage) {
        statusMessage = newMessage;
    }
}
