public class Book {


    private final String title;
    private final String author;
    private final int yearOfPublishing;

    public Book(String title, String author, int yearOfPublishing) {

        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYearOfpublishing() {
        return this.yearOfPublishing;
    }
}
