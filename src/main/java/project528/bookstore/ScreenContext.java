package project528.bookstore;

import javafx.stage.Stage;

class ScreenContext {
    private Stage stage;
    private BookStore bookStore;
    private ScreenState currentState;

    public ScreenContext(Stage stage, BookStore bookStore) {
        this.stage = stage;
        this.bookStore = bookStore;
    }

    public void setState(ScreenState state) {
        this.currentState = state;
        currentState.display();
    }

    public Stage getStage() { return stage; }
    public BookStore getBookStore() { return bookStore; }
}

