public class Book extends LibraryItem implements Borrowable {

    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author, boolean isAvailable) {
        super(id, title);
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String toString(){
        return  String.format("{\"id\": %d, \"title\": \"%s\", \"author\": \"%s\", \"isAvailable\": %b}", getId(), getTitle(), author, isAvailable);
    }

    @Override
    public void borrow(User user) {
        if (!isAvailable) throw new RuntimeException("Book is unavalable");
        this.isAvailable = false;
    }

    @Override
    public void returnBook() {
        this.isAvailable = true;
    }
}

