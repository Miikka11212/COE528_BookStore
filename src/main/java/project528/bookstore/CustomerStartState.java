package project528.bookstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

class CustomerStartState implements ScreenState {
    private ScreenContext context;
    private Customer customer;

    public CustomerStartState(ScreenContext context, Customer customer) {
        this.context = context;
        this.customer = customer;
    }

    @Override
    public void display() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label welcomeLabel = new Label("Welcome " + customer.getUsername() +
                ". You have " + customer.getPoints() + " points. Your status is " + customer.getStatus());
        root.getChildren().add(welcomeLabel);

        // display title price and two buttons for purchasing
        for (Book book : context.getBookStore().getBooks()) {
            HBox bookRow = new HBox(10);
            Label bookLabel = new Label(book.getName() + " - Price: " + book.getPrice());

            Button buyButton = new Button("Buy");
            Button redeemButton = new Button("Buy with Points");

            // normal purchase, every 1 dollar worth 10 points
            buyButton.setOnAction(e -> {
                double price = book.getPrice();
                int earnedPoints = (int)(price * 10);
                customer.addPoints(earnedPoints);
                context.setState(new CustomerCostState(context, customer, price, book.getName(), false));
            });

            // purchase with points, calculation points every 100 points = 1 dollar discount
            redeemButton.setOnAction(e -> {
                double price = book.getPrice();
                int possibleDiscount = customer.getPoints() / 100;
                int discount = (int)Math.min(price, possibleDiscount);
                double finalCost = price - discount;
                int pointsRedeemed = discount * 100;
                customer.redeemPoints(pointsRedeemed);
                int earnedPoints = (int)(finalCost * 10);
                customer.addPoints(earnedPoints);
                context.setState(new CustomerCostState(context, customer, finalCost, book.getName(), true));
            });

            bookRow.getChildren().addAll(bookLabel, buyButton, redeemButton);
            root.getChildren().add(bookRow);
        }

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> context.setState(new LoginState(context)));
        root.getChildren().add(logoutButton);

        Scene scene = new Scene(root, 600, 400);
        context.getStage().setScene(scene);
    }
}

