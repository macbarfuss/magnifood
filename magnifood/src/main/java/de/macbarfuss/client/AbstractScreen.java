package de.macbarfuss.client;

import com.google.gwt.user.client.ui.Panel;


public abstract class AbstractScreen {

// A T T R I B U T E S
//    private static UserSessionInfo sessionInfo;


// C O N S T R U C T O R

    public AbstractScreen() {
        buildUI();
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


// S E T T E R S
//    protected static void setSessionInfo(final UserSessionInfo newSessionInfo) {
//        AbstractScreen.sessionInfo = newSessionInfo;
//    }

// S T A T E   C H E C K E R S

// A B S T R A C T   B E H A V I O U R
    protected abstract void buildUI();

    public abstract Panel getContentPanel();


// H A N D L E R   C L A S S E S

    public final void show() {
        Screen.getInstance().show(this);
    }

}
