package com.auca.assessment;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.enrollment.Enrollment;
public class Assessment extends Object implements Identifiable, Registrable {
    private String assessmentId;
    private Enrollment enrollment;
    private String assessmentType;
    private double maximumScore;
    private double obtainedScore;
    private LocalDate assessmentDate;
    public Assessment(String assessmentId, Enrollment enrollment, String assessmentType, double maximumScore, double obtainedScore, LocalDate assessmentDate) {  this.assessmentId=assessmentId; this.enrollment=enrollment; this.assessmentType=assessmentType; this.maximumScore=maximumScore; this.obtainedScore=obtainedScore; this.assessmentDate=assessmentDate; }
    public String getId(){return assessmentId;} public String getDisplayName(){return String.valueOf(assessmentId);} public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(assessmentId==null||assessmentId.isBlank()) throw new ValidationException("assessmentId is required."); if(enrollment==null) throw new ValidationException("enrollment is required."); if(assessmentType==null||assessmentType.isBlank()) throw new ValidationException("assessmentType is required."); if(maximumScore<0) throw new ValidationException("maximumScore cannot be negative."); if(obtainedScore<0) throw new ValidationException("obtainedScore cannot be negative."); if(assessmentDate==null) throw new ValidationException("assessmentDate is required."); if(maximumScore<=0||obtainedScore>maximumScore) throw new ValidationException("Scores must be within 0 and maximumScore."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(assessmentId);}
    public String getAssessmentId(){return assessmentId;} public void setAssessmentId(String v){assessmentId=v;}
    public Enrollment getEnrollment(){return enrollment;} public void setEnrollment(Enrollment v){enrollment=v;}
    public String getAssessmentType(){return assessmentType;} public void setAssessmentType(String v){assessmentType=v;}
    public double getMaximumScore(){return maximumScore;} public void setMaximumScore(double v){maximumScore=v;}
    public double getObtainedScore(){return obtainedScore;} public void setObtainedScore(double v){obtainedScore=v;}
    public LocalDate getAssessmentDate(){return assessmentDate;} public void setAssessmentDate(LocalDate v){assessmentDate=v;}
    public String toString(){return getRegistrationSummary();}
}
