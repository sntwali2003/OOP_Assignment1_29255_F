package com.auca.student;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import com.auca.department.Department;
public class Student extends AcademicMember  {
    private String studentNumber;
    private String programName;
    private LocalDate admissionDate;
    private int studyYear;
    private String guardianPhone;
    private boolean scholarshipStatus;
    public Student(String personId,String firstName,String lastName,String email,String phoneNumber,LocalDate dateOfBirth,String memberNumber,Department department,LocalDate joinDate,String academicStatus,String institutionalEmail,String advisorName, String studentNumber, String programName, LocalDate admissionDate, int studyYear, String guardianPhone, boolean scholarshipStatus) { super(personId,firstName,lastName,email,phoneNumber,dateOfBirth,memberNumber,department,joinDate,academicStatus,institutionalEmail,advisorName); this.studentNumber=studentNumber; this.programName=programName; this.admissionDate=admissionDate; this.studyYear=studyYear; this.guardianPhone=guardianPhone; this.scholarshipStatus=scholarshipStatus; }
    public String getRoleDescription(){return "Student";} public String getAcademicCategory(){return "Student";}
    public String getId(){return studentNumber;} public String getDisplayName(){return String.valueOf(studentNumber);} public boolean isActive(){return true;}
    public void validate() throws ValidationException { super.validate(); if(studentNumber==null||studentNumber.isBlank()) throw new ValidationException("studentNumber is required."); if(programName==null||programName.isBlank()) throw new ValidationException("programName is required."); if(admissionDate==null) throw new ValidationException("admissionDate is required."); if(studyYear<1) throw new ValidationException("Invalid studyYear."); if(guardianPhone==null||guardianPhone.isBlank()) throw new ValidationException("guardianPhone is required."); if(studyYear>8) throw new ValidationException("Study year must be 1-8 as shown in the smart form specification."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(studentNumber);}
    public String getStudentNumber(){return studentNumber;} public void setStudentNumber(String v){studentNumber=v;}
    public String getProgramName(){return programName;} public void setProgramName(String v){programName=v;}
    public LocalDate getAdmissionDate(){return admissionDate;} public void setAdmissionDate(LocalDate v){admissionDate=v;}
    public int getStudyYear(){return studyYear;} public void setStudyYear(int v){studyYear=v;}
    public String getGuardianPhone(){return guardianPhone;} public void setGuardianPhone(String v){guardianPhone=v;}
    public boolean getScholarshipStatus(){return scholarshipStatus;} public void setScholarshipStatus(boolean v){scholarshipStatus=v;}
    public String toString(){return getRegistrationSummary();}
}
