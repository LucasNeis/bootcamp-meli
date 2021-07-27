package Exercise3;

public class MainBook {
    public static void main(String[] args) {
        Book b0 = new Book("The Hitchhiker's Guide to The Galaxy","Douglas Adams", "Science Fiction");
        Book b1 = new Book("Foundation", "Isaac Asimov", "Science Fiction");
        Book b2 = new Book("The Hobbit", "John Ronald Reuel Tolkien", "Fantasy");
        Book b3 = new Book();
        System.out.println(b0);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
