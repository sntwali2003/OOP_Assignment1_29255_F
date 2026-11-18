package com.auca.enrollment;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; 
public class Enrollment implements Identifiable, Registrable {
 private String enrollmentId;
 private com.auca.student.Student student;
 private com.auca.course.Course course;
 private java.time.LocalDate enrollmentDate;
 private String semester;
 private String enrollmentStatus;
 public Enrollment(String enrollmentId, com.auca.student.Student student, com.auca.course.Course course, java.time.LocalDate enrollmentDate, String semester, String enrollmentStatus){this.enrollmentId=enrollmentId;this.student=student;this.course=course;this.enrollmentDate=enrollmentDate;this.semester=semester;this.enrollmentStatus=enrollmentStatus;}
 public String getId(){return enrollmentId;} public String getDisplayName(){return student.getDisplayName()+" - "+course.getCourseTitle();} public boolean isActive(){return true;}
 public void validate() throws ValidationException {if(enrollmentId==null||enrollmentId.isBlank()||student==null||course==null||enrollmentDate==null||enrollmentDate.isAfter(java.time.LocalDate.now())||semester==null||semester.isBlank()||enrollmentStatus==null||!java.util.Arrays.asList("ACTIVE","INACTIVE","COMPLETED").contains(enrollmentStatus.toUpperCase()))throw new ValidationException("Invalid enrollment.");}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getDisplayName()+" ["+getId()+"]";}
 public String getEnrollmentId(){return enrollmentId;} public void setEnrollmentId(String v){enrollmentId=v;}
 public com.auca.student.Student getStudent(){return student;} public void setStudent(com.auca.student.Student v){student=v;}
 public com.auca.course.Course getCourse(){return course;} public void setCourse(com.auca.course.Course v){course=v;}
 public java.time.LocalDate getEnrollmentDate(){return enrollmentDate;} public void setEnrollmentDate(java.time.LocalDate v){enrollmentDate=v;}
 public String getSemester(){return semester;} public void setSemester(String v){semester=v;}
 public String getEnrollmentStatus(){return enrollmentStatus;} public void setEnrollmentStatus(String v){enrollmentStatus=v;}
 public String toString(){return "Enrollment ["+getId()+"] "+getDisplayName();}
}
