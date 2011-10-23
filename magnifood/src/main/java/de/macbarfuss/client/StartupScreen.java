package de.macbarfuss.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StartupScreen {

    private final Button loginButton = new Button("Login");

    private final Panel contentPanel = new VerticalPanel();

    private final TextBox userNameField = new TextBox();

    private final TextBox passphraseField = new PasswordTextBox();

    public StartupScreen() {
        contentPanel.setWidth("50%");
        prepareLoginGroup();
        RootPanel.get().add(contentPanel);
    }

    // U I   P R E P A R A T I O N
    private void prepareLoginGroup() {
        contentPanel.add(new Label("Username:"));
        contentPanel.add(userNameField);

        contentPanel.add(new Label("Password:"));
        contentPanel.add(passphraseField);

        prepareLoginButton();
        contentPanel.add(loginButton);
    }

    private void prepareLoginButton() {
        loginButton.addClickHandler(new LoginHandler());
    }
}
