package dev.danvega.hellovaadin.login;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("login")
public class LoginViews extends Composite<LoginOverlay> {

    public LoginViews(){
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("Fahbabs");
        loginOverlay.setOpened(true);

//        TextField firstName = new TextField("First name");
//        TextField lastName = new TextField("Last name");
//        EmailField email = new EmailField("email");
//
//        from(){
//            var saveButton = new Button("Save");
//            add(firstName, lastName, email, saveButton);
//        };
    }

//    public LoginViews() {
//        VerticalLayout layout = getContent();
//        layout.add(
//                new LoginForm()
//        );
//        layout.setAlignItems(FlexComponent.Alignment.CENTER);
//    }
}
