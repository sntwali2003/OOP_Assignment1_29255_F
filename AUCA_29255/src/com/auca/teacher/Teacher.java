package com.auca.teacher;
import java.time.LocalDate; import java.math.BigDecimal; import com.auca.abstracts.AcademicMember; import com.auca.department.Department; import com.auca.exceptions.ValidationException;
public class Teacher extends AcademicMember {
 private String employeeNumber,specialization; private LocalDate hireDate; private BigDecimal salary; private String officeNumber,employmentType;
 public Teacher(String id,String f,String l,String e,String p,LocalDate dob,String mn,Department d,LocalDate jd,String st,String ie,String an,String en,String sp,LocalDate hd,BigDecimal sal,String off,String et){super(id,f,l,e,p,dob,mn,d,jd,st,ie,an);employeeNumber=en;specialization=sp;hireDate=hd;salary=sal;officeNumber=off;employmentType=et;}
 public String getRoleDescription(){return "Teacher";} public String getAcademicCategory(){return "Teacher";}
 public void validate() throws ValidationException{super.validate();if(employeeNumber==null||employeeNumber.isBlank()||specialization==null||specialization.isBlank()||hireDate==null||hireDate.isAfter(LocalDate.now())||salary==null||salary.signum()<=0||officeNumber==null||officeNumber.isBlank()||employmentType==null||employmentType.isBlank())throw new ValidationException("Invalid teacher details; salary must be positive.");}
 public String getEmployeeNumber(){return employeeNumber;} public void setEmployeeNumber(String v){employeeNumber=v;} public String getSpecialization(){return specialization;} public void setSpecialization(String v){specialization=v;}
 public LocalDate getHireDate(){return hireDate;} public void setHireDate(LocalDate v){hireDate=v;} public BigDecimal getSalary(){return salary;} public void setSalary(BigDecimal v){salary=v;}
 public String getOfficeNumber(){return officeNumber;} public void setOfficeNumber(String v){officeNumber=v;} public String getEmploymentType(){return employmentType;} public void setEmploymentType(String v){employmentType=v;}
 public String getRegistrationSummary(){return "Teacher "+getId()+" "+getDisplayName()+" | "+specialization;}
}
