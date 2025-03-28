package project528.bookstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

class OwnerBooksState implements ScreenState {
    private ScreenContext context;

    public OwnerBooksState(ScreenContext context) {
        this.context = context;
    }

    @Override
    public void display() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        Label label = new Label("Owner Books Screen");

        TextField nameField = new TextField();
        nameField.setPromptText("Book Name");
        TextField priceField = new TextField();
        priceField.setPromptText("Book Price");
        Button addButton = new Button("Add Book");
        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                context.getBookStore().addBook(new Book(name, price));
                nameField.clear();
                priceField.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid price format.");
                alert.showAndWait();
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> context.setState(new OwnerStartState(context)));

        root.getChildren().addAll(label, nameField, priceField, addButton, backButton);
        Scene scene = new Scene(root, 400, 300);
        context.getStage().setScene(scene);
    }
}

