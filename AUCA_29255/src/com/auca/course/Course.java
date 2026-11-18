package com.auca.course;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; 
public class Course implements Identifiable, Registrable {
 private String courseId;
 private String courseCode;
 private String courseTitle;
 private int creditHours;
 private com.auca.department.Department department;
 private com.auca.teacher.Teacher assignedTeacher;
 public Course(String courseId, String courseCode, String courseTitle, int creditHours, com.auca.department.Department department, com.auca.teacher.Teacher assignedTeacher){this.courseId=courseId;this.courseCode=courseCode;this.courseTitle=courseTitle;this.creditHours=creditHours;this.department=department;this.assignedTeacher=assignedTeacher;}
 public String getId(){return courseId;} public String getDisplayName(){return courseTitle;} public boolean isActive(){return true;}
 public void validate() throws ValidationException {if(courseId==null||courseId.isBlank()||courseCode==null||courseCode.isBlank()||courseTitle==null||courseTitle.isBlank()||creditHours<1||creditHours>6||department==null||assignedTeacher==null)throw new ValidationException("Course requires valid fields, department and teacher; credits 1-6.");}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getDisplayName()+" ["+getId()+"]";}
 public String getCourseId(){return courseId;} public void setCourseId(String v){courseId=v;}
 public String getCourseCode(){return courseCode;} public void setCourseCode(String v){courseCode=v;}
 public String getCourseTitle(){return courseTitle;} public void setCourseTitle(String v){courseTitle=v;}
 public int getCreditHours(){return creditHours;} public void setCreditHours(int v){creditHours=v;}
 public com.auca.department.Department getDepartment(){return department;} public void setDepartment(com.auca.department.Department v){department=v;}
 public com.auca.teacher.Teacher getAssignedTeacher(){return assignedTeacher;} public void setAssignedTeacher(com.auca.teacher.Teacher v){assignedTeacher=v;}
 public String toString(){return "Course ["+getId()+"] "+getDisplayName();}
}
