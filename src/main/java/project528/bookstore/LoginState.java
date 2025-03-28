package project528.bookstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

class LoginState implements ScreenState {
    //initial login state
    private ScreenContext context;

    public LoginState(ScreenContext context) {
        this.context = context;
    }

    @Override
    public void display() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label userLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            if (username.equals("admin") && password.equals("admin")) {
                context.setState(new OwnerStartState(context));
            } else {
                boolean found = false;
                for (Customer c : context.getBookStore().getCustomers()) {
                    if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                        context.setState(new CustomerStartState(context, c));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid credentials");
                    alert.showAndWait();
                }
            }
        });

        root.getChildren().addAll(userLabel, usernameField, passLabel, passwordField, loginButton);
        Scene scene = new Scene(root, 300, 200);
        context.getStage().setScene(scene);
    }
}
