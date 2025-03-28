package project528.bookstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class OwnerStartState implements ScreenState {
    private ScreenContext context;

    public OwnerStartState(ScreenContext context) {
        this.context = context;
    }

    @Override
    public void display() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Button booksButton = new Button("Books");
        Button customersButton = new Button("Customers");
        Button logoutButton = new Button("Logout");

        booksButton.setOnAction(e -> context.setState(new OwnerBooksState(context)));
        customersButton.setOnAction(e -> context.setState(new OwnerCustomersState(context)));
        logoutButton.setOnAction(e -> context.setState(new LoginState(context)));

        root.getChildren().addAll(booksButton, customersButton, logoutButton);
        Scene scene = new Scene(root, 300, 200);
        context.getStage().setScene(scene);
    }
}
