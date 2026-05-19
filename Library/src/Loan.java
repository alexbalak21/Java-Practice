import java.util.Date;

public class Loan {
    private final Book book;
    private final User user;
    private final Date borrow_date;

    public Loan (Book book, User user, Date borrow_date){
        this.book = book;
        this.user = user;
        this.borrow_date = borrow_date;
    }

    public Book getBook(){
        return book;
    }

    public User getUser(){
        return user;
    }

    public Date getBorrowDate(){
        return borrow_date;
    }
    
}
