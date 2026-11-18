package com.auca.abstracts;
import java.time.LocalDate; import com.auca.department.Department; import com.auca.exceptions.ValidationException;
public abstract class AcademicMember extends Person {
 private String memberNumber; private Department department; private LocalDate joinDate; private String academicStatus,institutionalEmail,advisorName;
 protected AcademicMember(String id,String f,String l,String e,String p,LocalDate dob,String mn,Department d,LocalDate jd,String st,String ie,String an){
  super(id,f,l,e,p,dob);memberNumber=mn;department=d;joinDate=jd;academicStatus=st;institutionalEmail=ie;advisorName=an;
 }
 public abstract String getAcademicCategory();
 public void validate() throws ValidationException {super.validate();if(blank(memberNumber)||department==null||joinDate==null||joinDate.isAfter(LocalDate.now())||!("ACTIVE".equalsIgnoreCase(academicStatus)||"INACTIVE".equalsIgnoreCase(academicStatus))||blank(institutionalEmail)||!institutionalEmail.contains("@")||blank(advisorName))throw new ValidationException("Invalid academic-member details or department.");}
 public String getMemberNumber(){return memberNumber;} public void setMemberNumber(String v){memberNumber=v;} public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
 public LocalDate getJoinDate(){return joinDate;} public void setJoinDate(LocalDate v){joinDate=v;} public String getAcademicStatus(){return academicStatus;} public void setAcademicStatus(String v){academicStatus=v;}
 public String getInstitutionalEmail(){return institutionalEmail;} public void setInstitutionalEmail(String v){institutionalEmail=v;} public String getAdvisorName(){return advisorName;} public void setAdvisorName(String v){advisorName=v;}
 public String getRegistrationSummary(){return getAcademicCategory()+" "+getId()+" "+getDisplayName()+" | "+department.getDepartmentName();}
}
