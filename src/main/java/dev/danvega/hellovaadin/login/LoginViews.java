package dev.danvega.hellovaadin.login;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginViews extends Composite<LoginOverlay> {

    public LoginViews(){
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("Fahbabs");
        loginOverlay.setDescription("Pharmacy Management System");
        loginOverlay.setOpened(true);

        loginOverlay.addLoginListener(event -> {
            if ("user".equals(event.getUsername())) {
                UI.getCurrent().navigate("user");
            }else if ("dashboard".equals(event.getUsername())){
                UI.getCurrent().navigate("dashboard");
            } else {
                Notification.show("Wrong credentials");
            }
        });

    }

}
