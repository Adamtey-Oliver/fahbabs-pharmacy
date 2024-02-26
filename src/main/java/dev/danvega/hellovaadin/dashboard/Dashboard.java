package dev.danvega.hellovaadin.dashboard;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("dashboard")
public class Dashboard extends VerticalLayout {

    private VerticalLayout todosList;
    private Grid<String> grid;
    private TextField taskField;

    public Dashboard() {
        // Initialize components
        todosList = new VerticalLayout();
        taskField = new TextField();
        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
            taskField.setValue("");
        });

        // Create sidebar with a white background
        VerticalLayout sidebar = new VerticalLayout(
                new H2("Dashboard"),
                createSidebarButton("Category"),
                createSidebarButton("Products"),
                createSidebarButton("Purchase"),
                createSidebarButton("Records"),
                createSidebarButton("Dispense", true)
        );
        sidebar.getStyle().set("background-color", "#FFFFFF");
        sidebar.setWidth("200px");
        sidebar.setHeightFull();

        // Create header with a white background at the top
        HorizontalLayout header = new HorizontalLayout();
        H1 headerContent = new H1("Header content");
        headerContent.getStyle().set("margin", "auto"); // Center the header content
        header.add(headerContent, createSearchButton());
        header.getStyle().set("background-color", "white");

        // Set up the main content area with a Grid
        grid = new Grid<>();
        grid.addColumn(String::toString).setHeader("Column 1");
        grid.addColumn(String::toString).setHeader("Column 2");
        grid.addColumn(String::toString).setHeader("Column 3");

        // Sample data
        grid.setItems("Row 1", "Row 2", "Row 3", "Row 4");

        // Style the main content area
        VerticalLayout mainContent = new VerticalLayout(
                grid,
                new HorizontalLayout(
                        taskField,
                        addButton
                )
        );
        mainContent.getStyle().set("background-color", "#FBF9F9");
        mainContent.getStyle().set("width", "536px");
        mainContent.getStyle().set("height", "301px");
        mainContent.getStyle().set("border-radius", "4px");
        mainContent.getStyle().set("margin", "auto"); // Center the content
        mainContent.setAlignItems(Alignment.CENTER);
        mainContent.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        mainContent.setHeightFull();

        // Set up the main layout
        add(
                header,
                new HorizontalLayout(
                        sidebar,
                        mainContent
                )
        );
        setSizeFull();
        setAlignItems(Alignment.STRETCH);
        setFlexGrow(1, mainContent);
        setMargin(false);
        setPadding(false);
        setSpacing(false);
    }

    private Button createSidebarButton(String caption) {
        Button button = new Button(caption, event -> updateContent(caption));
        button.setThemeName("icon-button");
        return button;
    }

    private Button createSidebarButton(String caption, boolean isActive) {
        Button button = new Button(caption, event -> updateContent(caption));
        button.setThemeName("icon-button");
        if (isActive) {
            button.getStyle().set("background-color", "white");
        }
        return button;
    }

    private HorizontalLayout createDropdownMenu() {
        // Example dropdown menu
        Button menuItem1 = new Button("Item 1");
        Button menuItem2 = new Button("Item 2");
        HorizontalLayout menu = new HorizontalLayout(menuItem1, menuItem2);
        menu.getStyle().set("padding-left", "20px");
        menu.setAlignItems(Alignment.CENTER);
        menu.setVisible(false); // Set to visible based on your logic
        return menu;
    }

    private Button createSearchButton() {
        Button searchButton = new Button("Search");
        // Add search functionality if needed
        return searchButton;
    }

    private void updateContent(String sidebarItem) {
        // Update the content based on the selected sidebar item
        grid.setItems(sidebarItem + " - Row 1", sidebarItem + " - Row 2", sidebarItem + " - Row 3", sidebarItem + " - Row 4");
    }
}
