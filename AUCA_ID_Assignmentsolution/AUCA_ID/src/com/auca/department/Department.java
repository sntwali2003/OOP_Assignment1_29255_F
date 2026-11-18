package com.auca.department;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.teacher.Teacher;
public class Department extends Object implements Identifiable, Registrable {
    private String departmentId;
    private String departmentName;
    private String departmentCode;
    private String officeLocation;
    private String contactEmail;
    private Teacher headTeacher;
    public Department(String departmentId, String departmentName, String departmentCode, String officeLocation, String contactEmail, Teacher headTeacher) {  this.departmentId=departmentId; this.departmentName=departmentName; this.departmentCode=departmentCode; this.officeLocation=officeLocation; this.contactEmail=contactEmail; this.headTeacher=headTeacher; }
    public String getId(){return departmentId;} public String getDisplayName(){return String.valueOf(departmentName);} public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(departmentId==null||departmentId.isBlank()) throw new ValidationException("departmentId is required."); if(departmentName==null||departmentName.isBlank()) throw new ValidationException("departmentName is required."); if(departmentCode==null||departmentCode.isBlank()) throw new ValidationException("departmentCode is required."); if(officeLocation==null||officeLocation.isBlank()) throw new ValidationException("officeLocation is required."); if(contactEmail==null||contactEmail.isBlank()) throw new ValidationException("contactEmail is required."); if(headTeacher==null) throw new ValidationException("headTeacher is required."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(departmentName);}
    public String getDepartmentId(){return departmentId;} public void setDepartmentId(String v){departmentId=v;}
    public String getDepartmentName(){return departmentName;} public void setDepartmentName(String v){departmentName=v;}
    public String getDepartmentCode(){return departmentCode;} public void setDepartmentCode(String v){departmentCode=v;}
    public String getOfficeLocation(){return officeLocation;} public void setOfficeLocation(String v){officeLocation=v;}
    public String getContactEmail(){return contactEmail;} public void setContactEmail(String v){contactEmail=v;}
    public Teacher getHeadTeacher(){return headTeacher;} public void setHeadTeacher(Teacher v){headTeacher=v;}
    public String toString(){return getRegistrationSummary();}
}
