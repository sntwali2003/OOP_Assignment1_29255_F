package com.auca.student;
import java.time.LocalDate; import com.auca.abstracts.AcademicMember; import com.auca.department.Department; import com.auca.exceptions.ValidationException;
public class Student extends AcademicMember {
 private String studentNumber,programName; private LocalDate admissionDate; private int studyYear; private String guardianPhone; private boolean scholarshipStatus;
 public Student(String id,String f,String l,String e,String p,LocalDate dob,String mn,Department d,LocalDate jd,String st,String ie,String an,String sn,String pn,LocalDate ad,int sy,String gp,boolean ss){
 super(id,f,l,e,p,dob,mn,d,jd,st,ie,an);studentNumber=sn;programName=pn;admissionDate=ad;studyYear=sy;guardianPhone=gp;scholarshipStatus=ss;}
 public String getRoleDescription(){return "Student";} public String getAcademicCategory(){return "Student";}
 public void validate() throws ValidationException{super.validate();if(studentNumber==null||studentNumber.isBlank()||programName==null||programName.isBlank()||admissionDate==null||admissionDate.isAfter(LocalDate.now())||studyYear<1||studyYear>8||guardianPhone==null||!guardianPhone.matches("\\+?\\d{10,15}"))throw new ValidationException("Invalid student details; study year must be 1-8.");}
 public String getStudentNumber(){return studentNumber;} public void setStudentNumber(String v){studentNumber=v;} public String getProgramName(){return programName;} public void setProgramName(String v){programName=v;}
 public LocalDate getAdmissionDate(){return admissionDate;} public void setAdmissionDate(LocalDate v){admissionDate=v;} public int getStudyYear(){return studyYear;} public void setStudyYear(int v){studyYear=v;}
 public String getGuardianPhone(){return guardianPhone;} public void setGuardianPhone(String v){guardianPhone=v;} public boolean isScholarshipStatus(){return scholarshipStatus;} public void setScholarshipStatus(boolean v){scholarshipStatus=v;}
 public String getRegistrationSummary(){return "Student "+getId()+" "+getDisplayName()+" | "+programName+" | Year "+studyYear;}
}
