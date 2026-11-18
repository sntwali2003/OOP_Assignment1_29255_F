package com.auca.course;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.department.Department;
import com.auca.teacher.Teacher;
public class Course extends Object implements Identifiable, Registrable {
    private String courseId;
    private String courseCode;
    private String courseTitle;
    private int creditHours;
    private Department department;
    private Teacher assignedTeacher;
    public Course(String courseId, String courseCode, String courseTitle, int creditHours, Department department, Teacher assignedTeacher) {  this.courseId=courseId; this.courseCode=courseCode; this.courseTitle=courseTitle; this.creditHours=creditHours; this.department=department; this.assignedTeacher=assignedTeacher; }
    public String getId(){return courseId;} public String getDisplayName(){return String.valueOf(courseTitle);} public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(courseId==null||courseId.isBlank()) throw new ValidationException("courseId is required."); if(courseCode==null||courseCode.isBlank()) throw new ValidationException("courseCode is required."); if(courseTitle==null||courseTitle.isBlank()) throw new ValidationException("courseTitle is required."); if(creditHours<1) throw new ValidationException("Invalid creditHours."); if(department==null) throw new ValidationException("department is required."); if(assignedTeacher==null) throw new ValidationException("assignedTeacher is required."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(courseTitle);}
    public String getCourseId(){return courseId;} public void setCourseId(String v){courseId=v;}
    public String getCourseCode(){return courseCode;} public void setCourseCode(String v){courseCode=v;}
    public String getCourseTitle(){return courseTitle;} public void setCourseTitle(String v){courseTitle=v;}
    public int getCreditHours(){return creditHours;} public void setCreditHours(int v){creditHours=v;}
    public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
    public Teacher getAssignedTeacher(){return assignedTeacher;} public void setAssignedTeacher(Teacher v){assignedTeacher=v;}
    public String toString(){return getRegistrationSummary();}
}
