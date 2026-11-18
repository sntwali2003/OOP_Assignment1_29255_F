package com.auca.department;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; 
public class Department implements Identifiable, Registrable {
 private String departmentId;
 private String departmentName;
 private String departmentCode;
 private String officeLocation;
 private String contactEmail;
 private com.auca.teacher.Teacher headTeacher;
 public Department(String departmentId, String departmentName, String departmentCode, String officeLocation, String contactEmail, com.auca.teacher.Teacher headTeacher){this.departmentId=departmentId;this.departmentName=departmentName;this.departmentCode=departmentCode;this.officeLocation=officeLocation;this.contactEmail=contactEmail;this.headTeacher=headTeacher;}
 public String getId(){return departmentId;} public String getDisplayName(){return departmentName;} public boolean isActive(){return true;}
 public void validate() throws ValidationException {if(departmentId==null||departmentId.isBlank()||departmentName==null||departmentName.trim().length()<2||departmentCode==null||departmentCode.isBlank()||officeLocation==null||officeLocation.isBlank()||contactEmail==null||!contactEmail.contains("@"))throw new ValidationException("Invalid department details.");}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getDisplayName()+" ["+getId()+"]";}
 public String getDepartmentId(){return departmentId;} public void setDepartmentId(String v){departmentId=v;}
 public String getDepartmentName(){return departmentName;} public void setDepartmentName(String v){departmentName=v;}
 public String getDepartmentCode(){return departmentCode;} public void setDepartmentCode(String v){departmentCode=v;}
 public String getOfficeLocation(){return officeLocation;} public void setOfficeLocation(String v){officeLocation=v;}
 public String getContactEmail(){return contactEmail;} public void setContactEmail(String v){contactEmail=v;}
 public com.auca.teacher.Teacher getHeadTeacher(){return headTeacher;} public void setHeadTeacher(com.auca.teacher.Teacher v){headTeacher=v;}
 public String toString(){return "Department ["+getId()+"] "+getDisplayName();}
}
