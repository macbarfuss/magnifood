package de.macbarfuss.client;

import com.google.gwt.core.client.EntryPoint;

public final class Magnifood implements EntryPoint {

    public Magnifood() { }

    public void onModuleLoad() {
        Screen.getInstance().prepareButtonBar();
        Screen.getInstance().show(new WelcomeScreen());
    }
}
