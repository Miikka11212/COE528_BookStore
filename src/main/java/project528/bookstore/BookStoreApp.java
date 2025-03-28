package project528.bookstore;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

//main class
public class BookStoreApp extends Application {

    private ScreenContext screenContext;
    private BookStore bookStore;

    @Override
    public void start(Stage primaryStage) {
        // initialising some books and user for demo
        bookStore = new BookStore();
        bookStore.addBook(new Book("Java Programming", 50));
        bookStore.addBook(new Book("Design Patterns", 70));
        bookStore.addBook(new Book("Algorithms", 80));

        bookStore.addCustomer(new Customer("john", "john"));

        // initialise context with login stage
        screenContext = new ScreenContext(primaryStage, bookStore);
        screenContext.setState(new LoginState(screenContext));
        primaryStage.setTitle(" Welcome to the Book Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




