package com.auca.librarybook;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
public class LibraryBook extends Object implements Identifiable, Registrable {
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    public LibraryBook(String bookId, String isbn, String title, String author, int totalCopies, int availableCopies) {  this.bookId=bookId; this.isbn=isbn; this.title=title; this.author=author; this.totalCopies=totalCopies; this.availableCopies=availableCopies; }
    public String getId(){return bookId;} public String getDisplayName(){return String.valueOf(title);} public boolean isActive(){return availableCopies > 0;}
    public void validate() throws ValidationException { if(bookId==null||bookId.isBlank()) throw new ValidationException("bookId is required."); if(isbn==null||isbn.isBlank()) throw new ValidationException("isbn is required."); if(title==null||title.isBlank()) throw new ValidationException("title is required."); if(author==null||author.isBlank()) throw new ValidationException("author is required."); if(totalCopies<1) throw new ValidationException("Invalid totalCopies."); if(availableCopies<0) throw new ValidationException("Invalid availableCopies."); if(availableCopies>totalCopies) throw new ValidationException("Available copies cannot exceed total copies."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(title);}
    public String getBookId(){return bookId;} public void setBookId(String v){bookId=v;}
    public String getIsbn(){return isbn;} public void setIsbn(String v){isbn=v;}
    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getAuthor(){return author;} public void setAuthor(String v){author=v;}
    public int getTotalCopies(){return totalCopies;} public void setTotalCopies(int v){totalCopies=v;}
    public int getAvailableCopies(){return availableCopies;} public void setAvailableCopies(int v){availableCopies=v;}
    public String toString(){return getRegistrationSummary();}
}
