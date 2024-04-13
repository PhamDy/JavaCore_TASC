package Collection;

public class Book implements Comparable<Book> {
    private int id;
    private String name, author, publisher;
    private int quantity;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Book b) {
        if (this.id > b.id) {
            return 1;
        } else if (this.id < b.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
