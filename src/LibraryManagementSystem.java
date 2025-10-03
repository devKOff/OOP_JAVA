import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a book in the library.
 * Each book has a unique ID, title, author, and an availability status.
 */
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // New books are available by default
    }

    // --- Getter and Setter Methods ---
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: '" + title + "', Author: '" + author + "', Available: " + (isAvailable ? "Yes" : "No");
    }
}

/**
 * Represents a library member.
 * Each member has a unique ID, a name, and a list of books they have borrowed.
 */
class Member {
    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // --- Getter Methods ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Adds a book to the member's list of borrowed books.
     * @param book The book to be borrowed.
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Removes a book from the member's list of borrowed books.
     * @param book The book to be returned.
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: '" + name + "', Borrowed Books: " + borrowedBooks.size();
    }
}

/**
 * Manages the library's collections of books and members, and library operations.
 */
class Library {
    private List<Book> books;
    private List<Member> members;
    private int nextBookId = 1;
    private int nextMemberId = 1;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    /**
     * Adds a new book to the library's catalog.
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public void addBook(String title, String author) {
        books.add(new Book(nextBookId++, title, author));
        System.out.println("Book added successfully!");
    }

    /**
     * Registers a new member with the library.
     * @param name The name of the member.
     */
    public void registerMember(String name) {
        members.add(new Member(nextMemberId++, name));
        System.out.println("Member registered successfully!");
    }

    /**
     * Finds a book in the library by its ID.
     * @param bookId The ID of the book to find.
     * @return The Book object if found, otherwise null.
     */
    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    /**
     * Finds a member in the library by their ID.
     * @param memberId The ID of the member to find.
     * @return The Member object if found, otherwise null.
     */
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    /**
     * Issues a book to a member.
     * @param bookId The ID of the book to be issued.
     * @param memberId The ID of the member borrowing the book.
     */
    public void issueBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("Error: Book not found.");
            return;
        }
        if (member == null) {
            System.out.println("Error: Member not found.");
            return;
        }

        if (book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(book);
            System.out.println("Book '" + book.getTitle() + "' has been issued to " + member.getName() + ".");
        } else {
            System.out.println("Error: Book is currently not available.");
        }
    }

    /**
     * Processes the return of a book from a member.
     * @param bookId The ID of the book being returned.
     * @param memberId The ID of the member returning the book.
     */
    public void returnBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("Error: Book not found.");
            return;
        }
        if (member == null) {
            System.out.println("Error: Member not found.");
            return;
        }

        if (member.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            member.returnBook(book);
            System.out.println("Book '" + book.getTitle() + "' has been returned by " + member.getName() + ".");
        } else {
            System.out.println("Error: This member did not borrow this book.");
        }
    }

    /**
     * Displays a list of all books in the library's catalog.
     */
    public void displayAllBooks() {
        System.out.println("\n--- Library Catalog ---");
        if (books.isEmpty()) {
            System.out.println("The library has no books.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        System.out.println("---------------------\n");
    }

    /**
     * Displays a list of all registered library members.
     */
    public void displayAllMembers() {
        System.out.println("\n--- Registered Members ---");
        if (members.isEmpty()) {
            System.out.println("There are no registered members.");
        } else {
            for (Member member : members) {
                System.out.println(member);
                if (!member.getBorrowedBooks().isEmpty()) {
                    System.out.println("  Borrowed Books:");
                    for (Book book : member.getBorrowedBooks()) {
                        System.out.println("    - " + book.getTitle());
                    }
                }
            }
        }
        System.out.println("------------------------\n");
    }
}


/**
 * The main class that runs the Library Management System application.
 * It provides a command-line interface for the user to interact with the library.
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Adding some initial data for demonstration
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");
        library.registerMember("Alice");
        library.registerMember("Bob");


        do {
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Add a new Book");
            System.out.println("2. Register a new Member");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display all Books");
            System.out.println("6. Display all Members");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        library.addBook(title, author);
                        break;
                    case 2:
                        System.out.print("Enter member name: ");
                        String name = scanner.nextLine();
                        library.registerMember(name);
                        break;
                    case 3:
                        System.out.print("Enter Book ID to issue: ");
                        int issueBookId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Member ID: ");
                        int issueMemberId = Integer.parseInt(scanner.nextLine());
                        library.issueBook(issueBookId, issueMemberId);
                        break;
                    case 4:
                        System.out.print("Enter Book ID to return: ");
                        int returnBookId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Member ID: ");
                        int returnMemberId = Integer.parseInt(scanner.nextLine());
                        library.returnBook(returnBookId, returnMemberId);
                        break;
                    case 5:
                        library.displayAllBooks();
                        break;
                    case 6:
                        library.displayAllMembers();
                        break;
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                choice = -1; // Reset choice to continue loop
            }

        } while (choice != 0);

        scanner.close();
    }
}

