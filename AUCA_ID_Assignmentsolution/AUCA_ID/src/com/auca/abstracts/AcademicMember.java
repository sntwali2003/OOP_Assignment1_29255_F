package com.auca.abstracts;

import java.time.LocalDate; import com.auca.department.Department; import com.auca.exceptions.ValidationException;
public abstract class AcademicMember extends Person {
    private String memberNumber; private Department department; private LocalDate joinDate; private String academicStatus, institutionalEmail, advisorName;
    protected AcademicMember(String personId,String firstName,String lastName,String email,String phoneNumber,LocalDate dateOfBirth,String memberNumber,Department department,LocalDate joinDate,String academicStatus,String institutionalEmail,String advisorName){
        super(personId,firstName,lastName,email,phoneNumber,dateOfBirth); this.memberNumber=memberNumber;this.department=department;this.joinDate=joinDate;this.academicStatus=academicStatus;this.institutionalEmail=institutionalEmail;this.advisorName=advisorName;
    }
    public abstract String getAcademicCategory();
    public void validate() throws ValidationException {super.validate(); if(memberNumber==null||memberNumber.isBlank()||department==null||joinDate==null||academicStatus==null||institutionalEmail==null||advisorName==null) throw new ValidationException("All academic member fields are required."); if(!academicStatus.equals("ACTIVE")&&!academicStatus.equals("INACTIVE")) throw new ValidationException("Status must be ACTIVE or INACTIVE.");}
    public String getMemberNumber(){return memberNumber;} public void setMemberNumber(String v){memberNumber=v;} public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
    public LocalDate getJoinDate(){return joinDate;} public void setJoinDate(LocalDate v){joinDate=v;} public String getAcademicStatus(){return academicStatus;} public void setAcademicStatus(String v){academicStatus=v;}
    public String getInstitutionalEmail(){return institutionalEmail;} public void setInstitutionalEmail(String v){institutionalEmail=v;} public String getAdvisorName(){return advisorName;} public void setAdvisorName(String v){advisorName=v;}
}
