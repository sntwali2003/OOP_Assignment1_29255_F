package com.auca.bookloan;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; 
public class BookLoan implements Identifiable, Registrable {
 private String loanId;
 private com.auca.student.Student student;
 private com.auca.librarybook.LibraryBook book;
 private java.time.LocalDate borrowedDate;
 private java.time.LocalDate dueDate;
 private java.time.LocalDate returnedDate;
 public BookLoan(String loanId, com.auca.student.Student student, com.auca.librarybook.LibraryBook book, java.time.LocalDate borrowedDate, java.time.LocalDate dueDate, java.time.LocalDate returnedDate){this.loanId=loanId;this.student=student;this.book=book;this.borrowedDate=borrowedDate;this.dueDate=dueDate;this.returnedDate=returnedDate;}
 public String getId(){return loanId;} public String getDisplayName(){return book.getTitle()+" borrowed by "+student.getDisplayName();} public boolean isActive(){return true;}
 public void validate() throws ValidationException {if(loanId==null||loanId.isBlank()||student==null||book==null||borrowedDate==null||dueDate==null||!dueDate.isAfter(borrowedDate)||(returnedDate!=null&&returnedDate.isBefore(borrowedDate)))throw new ValidationException("Invalid loan dates or references.");}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getDisplayName()+" ["+getId()+"]";}
 public String getLoanId(){return loanId;} public void setLoanId(String v){loanId=v;}
 public com.auca.student.Student getStudent(){return student;} public void setStudent(com.auca.student.Student v){student=v;}
 public com.auca.librarybook.LibraryBook getBook(){return book;} public void setBook(com.auca.librarybook.LibraryBook v){book=v;}
 public java.time.LocalDate getBorrowedDate(){return borrowedDate;} public void setBorrowedDate(java.time.LocalDate v){borrowedDate=v;}
 public java.time.LocalDate getDueDate(){return dueDate;} public void setDueDate(java.time.LocalDate v){dueDate=v;}
 public java.time.LocalDate getReturnedDate(){return returnedDate;} public void setReturnedDate(java.time.LocalDate v){returnedDate=v;}
 public String toString(){return "BookLoan ["+getId()+"] "+getDisplayName();}
}
