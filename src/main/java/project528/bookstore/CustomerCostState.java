package project528.bookstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

class CustomerCostState implements ScreenState {
    private ScreenContext context;
    private Customer customer;
    private double totalCost;
    private String bookName;
    private boolean redeemed; // true if points redemption was applied

    public CustomerCostState(ScreenContext context, Customer customer, double totalCost, String bookName, boolean redeemed) {
        this.context = context;
        this.customer = customer;
        this.totalCost = totalCost;
        this.bookName = bookName;
        this.redeemed = redeemed;
    }

    @Override
    public void display() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label bookLabel = new Label("You purchased: " + bookName);
        Label costLabel = new Label("Total Cost: " + totalCost + (redeemed ? " (with points redemption)" : ""));
        Label pointsLabel = new Label("Your new Points: " + customer.getPoints() + " | Status: " + customer.getStatus());
        Button backButton = new Button("Back to Store");
        backButton.setOnAction(e -> context.setState(new CustomerStartState(context, customer)));

        root.getChildren().addAll(bookLabel, costLabel, pointsLabel, backButton);
        Scene scene = new Scene(root, 400, 200);
        context.getStage().setScene(scene);
    }
}
