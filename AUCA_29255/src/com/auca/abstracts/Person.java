package com.auca.abstracts;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; import java.time.LocalDate;
public abstract class Person implements Identifiable, Registrable {
 private String personId,firstName,lastName,email,phoneNumber; private LocalDate dateOfBirth;
 protected Person(String id,String first,String last,String email,String phone,LocalDate dob){personId=id;firstName=first;lastName=last;this.email=email;phoneNumber=phone;dateOfBirth=dob;}
 public abstract String getRoleDescription();
 public String getId(){return personId;} public String getDisplayName(){return firstName+" "+lastName;} public boolean isActive(){return true;}
 public void validate() throws ValidationException {
  if(blank(personId)||personId.length()<4||personId.length()>30)throw new ValidationException("Person ID must be 4-30 characters.");
  if(!name(firstName)||!name(lastName))throw new ValidationException("Names must be 2-60 characters.");
  if(blank(email)||email.length()>120||!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))throw new ValidationException("Enter a valid email.");
  if(phoneNumber==null||!phoneNumber.matches("\\+?\\d{10,15}"))throw new ValidationException("Phone must contain 10-15 digits.");
  if(dateOfBirth==null||!dateOfBirth.isBefore(LocalDate.now()))throw new ValidationException("Date of birth must be in the past.");
 }
 protected static boolean blank(String s){return s==null||s.trim().isEmpty();} protected static boolean name(String s){return s!=null&&s.trim().length()>=2&&s.trim().length()<=60;}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getRoleDescription()+" "+personId+" "+getDisplayName();}
 public String getPersonId(){return personId;} public void setPersonId(String v){personId=v;} public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhoneNumber(){return phoneNumber;} public void setPhoneNumber(String v){phoneNumber=v;} public LocalDate getDateOfBirth(){return dateOfBirth;} public void setDateOfBirth(LocalDate v){dateOfBirth=v;}
 public String toString(){return getRegistrationSummary()+" | "+email+" | "+phoneNumber+" | DOB "+dateOfBirth;}
}
