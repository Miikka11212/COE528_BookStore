package project528.bookstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

class OwnerCustomersState implements ScreenState {
    private ScreenContext context;

    public OwnerCustomersState(ScreenContext context) {
        this.context = context;
    }

    @Override
    public void display() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        Label label = new Label("Owner Customers Screen");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Customer Username");

        TextField passwordField = new TextField();
        passwordField.setPromptText("Customer Password");

        Button addButton = new Button("Add Customer");
        addButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            if (!username.isEmpty() && !password.isEmpty()) {
                context.getBookStore().addCustomer(new Customer(username, password));
                usernameField.clear();
                passwordField.clear();
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> context.setState(new OwnerStartState(context)));

        root.getChildren().addAll(label, usernameField, passwordField, addButton, backButton);
        Scene scene = new Scene(root, 400, 300);
        context.getStage().setScene(scene);
    }
}
