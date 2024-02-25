package dev.danvega.hellovaadin.dashboard;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldBase;
import com.vaadin.flow.router.Route;

import java.awt.*;


@Route("dashboard")
public class dashboardSidebar extends VerticalLayout{

    public dashboardSidebar () {

        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
            taskField.setValue("");
        });
        addButton.addClickShortcut(Key.ENTER);

        Font pharmacyLogo = null;
        H2 pharmacyName;
        TextFieldBase<TextField, String> searchBar;
            add(
                new H1("Vaadin Todo"),
                todosList,
                new HorizontalLayout(
                        taskField,
                        addButton
                )
            );



    }

}
