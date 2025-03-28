package project528.bookstore;

import java.util.ArrayList;
import java.util.List;

class BookStore {
    private List<Book> books;
    private List<Customer> customers;

    public BookStore() {
        books = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public List<Book> getBooks() { return books; }
    public List<Customer> getCustomers() { return customers; }

    public void addBook(Book book) { books.add(book); }
    public void addCustomer(Customer customer) { customers.add(customer); }
}
