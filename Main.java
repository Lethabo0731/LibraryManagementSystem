public class Main {

    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        // Add book
        bookDAO.addBook("Java Programming", "James Gosling");

        // Add user
        userDAO.addUser("Lethabo", "lethabo@email.com");

        // View books
        bookDAO.viewBooks();

        // Borrow book
        transactionDAO.borrowBook(1,1);

        // Return book
        transactionDAO.returnBook(1);
    }
}