package com.auca.administrator;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
public class Administrator extends Person  {
    private String staffNumber;
    private String jobTitle;
    private String assignedOffice;
    private LocalDate employmentDate;
    private int accessLevel;
    private boolean active;
    public Administrator(String personId,String firstName,String lastName,String email,String phoneNumber,LocalDate dateOfBirth, String staffNumber, String jobTitle, String assignedOffice, LocalDate employmentDate, int accessLevel, boolean active) { super(personId,firstName,lastName,email,phoneNumber,dateOfBirth); this.staffNumber=staffNumber; this.jobTitle=jobTitle; this.assignedOffice=assignedOffice; this.employmentDate=employmentDate; this.accessLevel=accessLevel; this.active=active; }
    public String getRoleDescription(){return "Administrator";}
    public String getId(){return staffNumber;} public String getDisplayName(){return String.valueOf(staffNumber);} public boolean isActive(){return active;}
    public void validate() throws ValidationException { super.validate(); if(staffNumber==null||staffNumber.isBlank()) throw new ValidationException("staffNumber is required."); if(jobTitle==null||jobTitle.isBlank()) throw new ValidationException("jobTitle is required."); if(assignedOffice==null||assignedOffice.isBlank()) throw new ValidationException("assignedOffice is required."); if(employmentDate==null) throw new ValidationException("employmentDate is required."); if(accessLevel<0) throw new ValidationException("Invalid accessLevel."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(staffNumber);}
    public String getStaffNumber(){return staffNumber;} public void setStaffNumber(String v){staffNumber=v;}
    public String getJobTitle(){return jobTitle;} public void setJobTitle(String v){jobTitle=v;}
    public String getAssignedOffice(){return assignedOffice;} public void setAssignedOffice(String v){assignedOffice=v;}
    public LocalDate getEmploymentDate(){return employmentDate;} public void setEmploymentDate(LocalDate v){employmentDate=v;}
    public int getAccessLevel(){return accessLevel;} public void setAccessLevel(int v){accessLevel=v;}
    public boolean getActive(){return active;} public void setActive(boolean v){active=v;}
    public String toString(){return getRegistrationSummary();}
}
