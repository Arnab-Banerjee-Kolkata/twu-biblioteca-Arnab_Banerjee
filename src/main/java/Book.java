import java.util.Objects;

public class Book extends Item {


    private final String title;
    private final String author;
    private final int yearOfPublishing;

    public Book(String title, String author, int yearOfPublishing) {

        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getDetails() {
        return title + " " + author + " " + yearOfPublishing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfPublishing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing &&
                title.equals(book.title) &&
                author.equals(book.author);
    }
}
