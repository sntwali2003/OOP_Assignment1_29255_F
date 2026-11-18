package com.auca.feepayment;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; 
public class FeePayment implements Identifiable, Registrable {
 private String paymentId;
 private com.auca.student.Student student;
 private java.math.BigDecimal amount;
 private java.time.LocalDate paymentDate;
 private String paymentMethod;
 private String receiptNumber;
 public FeePayment(String paymentId, com.auca.student.Student student, java.math.BigDecimal amount, java.time.LocalDate paymentDate, String paymentMethod, String receiptNumber){this.paymentId=paymentId;this.student=student;this.amount=amount;this.paymentDate=paymentDate;this.paymentMethod=paymentMethod;this.receiptNumber=receiptNumber;}
 public String getId(){return paymentId;} public String getDisplayName(){return student.getDisplayName()+" - "+amount;} public boolean isActive(){return true;}
 public void validate() throws ValidationException {if(paymentId==null||paymentId.isBlank()||student==null||amount==null||amount.signum()<=0||paymentDate==null||paymentMethod==null||paymentMethod.isBlank()||receiptNumber==null||receiptNumber.isBlank())throw new ValidationException("Invalid payment; amount must be positive.");}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getDisplayName()+" ["+getId()+"]";}
 public String getPaymentId(){return paymentId;} public void setPaymentId(String v){paymentId=v;}
 public com.auca.student.Student getStudent(){return student;} public void setStudent(com.auca.student.Student v){student=v;}
 public java.math.BigDecimal getAmount(){return amount;} public void setAmount(java.math.BigDecimal v){amount=v;}
 public java.time.LocalDate getPaymentDate(){return paymentDate;} public void setPaymentDate(java.time.LocalDate v){paymentDate=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
 public String getReceiptNumber(){return receiptNumber;} public void setReceiptNumber(String v){receiptNumber=v;}
 public String toString(){return "FeePayment ["+getId()+"] "+getDisplayName();}
}
