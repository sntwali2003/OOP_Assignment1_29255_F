package com.auca.administrator;
import java.time.LocalDate; import com.auca.abstracts.Person; import com.auca.exceptions.ValidationException;
public class Administrator extends Person {
 private String staffNumber,jobTitle,assignedOffice; private LocalDate employmentDate; private int accessLevel; private boolean active;
 public Administrator(String id,String f,String l,String e,String p,LocalDate dob,String sn,String jt,String ao,LocalDate ed,int al,boolean a){super(id,f,l,e,p,dob);staffNumber=sn;jobTitle=jt;assignedOffice=ao;employmentDate=ed;accessLevel=al;active=a;}
 public String getRoleDescription(){return "Administrator";} public boolean isActive(){return active;}
 public void validate() throws ValidationException{super.validate();if(staffNumber==null||staffNumber.isBlank()||jobTitle==null||jobTitle.isBlank()||assignedOffice==null||assignedOffice.isBlank()||employmentDate==null||employmentDate.isAfter(LocalDate.now())||accessLevel<1||accessLevel>5)throw new ValidationException("Invalid administrator details; access level 1-5.");}
 public String getStaffNumber(){return staffNumber;} public void setStaffNumber(String v){staffNumber=v;} public String getJobTitle(){return jobTitle;} public void setJobTitle(String v){jobTitle=v;} public String getAssignedOffice(){return assignedOffice;} public void setAssignedOffice(String v){assignedOffice=v;}
 public LocalDate getEmploymentDate(){return employmentDate;} public void setEmploymentDate(LocalDate v){employmentDate=v;} public int getAccessLevel(){return accessLevel;} public void setAccessLevel(int v){accessLevel=v;} public void setActive(boolean v){active=v;}
}
