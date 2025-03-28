module project528.bookstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens project528.bookstore to javafx.fxml;
    exports project528.bookstore;
}