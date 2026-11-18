package com.auca.assessment;
import com.auca.interfaces.*; import com.auca.exceptions.ValidationException; 
public class Assessment implements Identifiable, Registrable {
 private String assessmentId;
 private com.auca.enrollment.Enrollment enrollment;
 private String assessmentType;
 private double maximumScore;
 private double obtainedScore;
 private java.time.LocalDate assessmentDate;
 public Assessment(String assessmentId, com.auca.enrollment.Enrollment enrollment, String assessmentType, double maximumScore, double obtainedScore, java.time.LocalDate assessmentDate){this.assessmentId=assessmentId;this.enrollment=enrollment;this.assessmentType=assessmentType;this.maximumScore=maximumScore;this.obtainedScore=obtainedScore;this.assessmentDate=assessmentDate;}
 public String getId(){return assessmentId;} public String getDisplayName(){return assessmentType+" - "+enrollment.getStudent().getDisplayName();} public boolean isActive(){return true;}
 public void validate() throws ValidationException {if(assessmentId==null||assessmentId.isBlank()||enrollment==null||!"ACTIVE".equalsIgnoreCase(enrollment.getEnrollmentStatus())||assessmentType==null||assessmentType.isBlank()||maximumScore<=0||obtainedScore<0||obtainedScore>maximumScore||assessmentDate==null)throw new ValidationException("Invalid assessment or inactive enrollment.");}
 public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getDisplayName()+" ["+getId()+"]";}
 public String getAssessmentId(){return assessmentId;} public void setAssessmentId(String v){assessmentId=v;}
 public com.auca.enrollment.Enrollment getEnrollment(){return enrollment;} public void setEnrollment(com.auca.enrollment.Enrollment v){enrollment=v;}
 public String getAssessmentType(){return assessmentType;} public void setAssessmentType(String v){assessmentType=v;}
 public double getMaximumScore(){return maximumScore;} public void setMaximumScore(double v){maximumScore=v;}
 public double getObtainedScore(){return obtainedScore;} public void setObtainedScore(double v){obtainedScore=v;}
 public java.time.LocalDate getAssessmentDate(){return assessmentDate;} public void setAssessmentDate(java.time.LocalDate v){assessmentDate=v;}
 public String toString(){return "Assessment ["+getId()+"] "+getDisplayName();}
}
