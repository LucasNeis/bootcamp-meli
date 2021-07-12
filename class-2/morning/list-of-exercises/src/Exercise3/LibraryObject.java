package Exercise3;

public abstract class LibraryObject {
    protected static int universalCount = 0;
    protected int identifier;
    public LibraryObject() {
        this.identifier = universalCount;
        universalCount++;
    }
}
