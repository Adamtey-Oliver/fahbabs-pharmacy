package dev.danvega.hellovaadin.despenseForm;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("dispense")
public class DespenseForm extends VerticalLayout {

    TextField customerName = new TextField("customer name");
    TextField selectDate = new TextField("select date");
    TextField amount = new TextField("Amount");
    TextField quantity = new TextField("Quantity");

    Select category = new Select();
    TextField medicine = new TextField("Medicine");

    public DespenseForm () {
        HorizontalLayout topRow = new HorizontalLayout();
        topRow.add(customerName, selectDate, amount, quantity);

        HorizontalLayout bottomRow = new HorizontalLayout();
        bottomRow.add(category, medicine, quantity);

        VerticalLayout form = new VerticalLayout();
        form.add(topRow, bottomRow);

        add(form);

        add(new H1("Hello World"));
    }
}
