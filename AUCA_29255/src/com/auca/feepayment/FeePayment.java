package com.auca.feepayment;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.student.Student;
public class FeePayment extends Object implements Identifiable, Registrable {
    private String paymentId;
    private Student student;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String receiptNumber;
    public FeePayment(String paymentId, Student student, BigDecimal amount, LocalDate paymentDate, String paymentMethod, String receiptNumber) {  this.paymentId=paymentId; this.student=student; this.amount=amount; this.paymentDate=paymentDate; this.paymentMethod=paymentMethod; this.receiptNumber=receiptNumber; }
    public String getId(){return paymentId;} public String getDisplayName(){return String.valueOf(paymentId);} public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(paymentId==null||paymentId.isBlank()) throw new ValidationException("paymentId is required."); if(student==null) throw new ValidationException("student is required."); if(amount==null||amount.signum()<=0) throw new ValidationException("amount must be positive."); if(paymentDate==null) throw new ValidationException("paymentDate is required."); if(paymentMethod==null||paymentMethod.isBlank()) throw new ValidationException("paymentMethod is required."); if(receiptNumber==null||receiptNumber.isBlank()) throw new ValidationException("receiptNumber is required."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(paymentId);}
    public String getPaymentId(){return paymentId;} public void setPaymentId(String v){paymentId=v;}
    public Student getStudent(){return student;} public void setStudent(Student v){student=v;}
    public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
    public LocalDate getPaymentDate(){return paymentDate;} public void setPaymentDate(LocalDate v){paymentDate=v;}
    public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
    public String getReceiptNumber(){return receiptNumber;} public void setReceiptNumber(String v){receiptNumber=v;}
    public String toString(){return getRegistrationSummary();}
}
