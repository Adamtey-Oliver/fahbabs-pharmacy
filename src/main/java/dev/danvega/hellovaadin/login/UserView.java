package dev.danvega.hellovaadin.login;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("user")
public class UserView extends VerticalLayout {
    public UserView() {
        add(new H2("Welcome User!"));
    }
}
