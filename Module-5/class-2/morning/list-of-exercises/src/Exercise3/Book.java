package Exercise3;

public class Book extends LibraryObject {
    private String title;
    private String author;
    private String genre;

    public Book() {
        super();
        this.author = "Unknown";
        this.genre = "Unknown";
        this.title = "Unknown";
    }

    public Book(String title, String author, String genre) {
        super();
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return this.title + ", " + this.genre + ", " + this.author + ", " + this.identifier;
    }
}
