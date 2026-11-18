package com.auca.enrollment;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.student.Student;
import com.auca.course.Course;
public class Enrollment extends Object implements Identifiable, Registrable {
    private String enrollmentId;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String semester;
    private String enrollmentStatus;
    public Enrollment(String enrollmentId, Student student, Course course, LocalDate enrollmentDate, String semester, String enrollmentStatus) {  this.enrollmentId=enrollmentId; this.student=student; this.course=course; this.enrollmentDate=enrollmentDate; this.semester=semester; this.enrollmentStatus=enrollmentStatus; }
    public String getId(){return enrollmentId;} public String getDisplayName(){return String.valueOf(enrollmentId);} public boolean isActive(){return "ACTIVE".equals(enrollmentStatus);}
    public void validate() throws ValidationException { if(enrollmentId==null||enrollmentId.isBlank()) throw new ValidationException("enrollmentId is required."); if(student==null) throw new ValidationException("student is required."); if(course==null) throw new ValidationException("course is required."); if(enrollmentDate==null) throw new ValidationException("enrollmentDate is required."); if(semester==null||semester.isBlank()) throw new ValidationException("semester is required."); if(enrollmentStatus==null||enrollmentStatus.isBlank()) throw new ValidationException("enrollmentStatus is required."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(enrollmentId);}
    public String getEnrollmentId(){return enrollmentId;} public void setEnrollmentId(String v){enrollmentId=v;}
    public Student getStudent(){return student;} public void setStudent(Student v){student=v;}
    public Course getCourse(){return course;} public void setCourse(Course v){course=v;}
    public LocalDate getEnrollmentDate(){return enrollmentDate;} public void setEnrollmentDate(LocalDate v){enrollmentDate=v;}
    public String getSemester(){return semester;} public void setSemester(String v){semester=v;}
    public String getEnrollmentStatus(){return enrollmentStatus;} public void setEnrollmentStatus(String v){enrollmentStatus=v;}
    public String toString(){return getRegistrationSummary();}
}
