package com.auca.classroom;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
public class Classroom extends Object implements Identifiable, Registrable {
    private String classroomId;
    private String buildingName;
    private String roomNumber;
    private int capacity;
    private int floorNumber;
    private boolean available;
    public Classroom(String classroomId, String buildingName, String roomNumber, int capacity, int floorNumber, boolean available) {  this.classroomId=classroomId; this.buildingName=buildingName; this.roomNumber=roomNumber; this.capacity=capacity; this.floorNumber=floorNumber; this.available=available; }
    public String getId(){return classroomId;} public String getDisplayName(){return String.valueOf(roomNumber);} public boolean isActive(){return available;}
    public void validate() throws ValidationException { if(classroomId==null||classroomId.isBlank()) throw new ValidationException("classroomId is required."); if(buildingName==null||buildingName.isBlank()) throw new ValidationException("buildingName is required."); if(roomNumber==null||roomNumber.isBlank()) throw new ValidationException("roomNumber is required."); if(capacity<1) throw new ValidationException("Invalid capacity."); if(floorNumber<0) throw new ValidationException("Invalid floorNumber."); }
    public void printDetails(){System.out.println(this);} public String getRegistrationSummary(){return getId()+" | "+String.valueOf(roomNumber);}
    public String getClassroomId(){return classroomId;} public void setClassroomId(String v){classroomId=v;}
    public String getBuildingName(){return buildingName;} public void setBuildingName(String v){buildingName=v;}
    public String getRoomNumber(){return roomNumber;} public void setRoomNumber(String v){roomNumber=v;}
    public int getCapacity(){return capacity;} public void setCapacity(int v){capacity=v;}
    public int getFloorNumber(){return floorNumber;} public void setFloorNumber(int v){floorNumber=v;}
    public boolean getAvailable(){return available;} public void setAvailable(boolean v){available=v;}
    public String toString(){return getRegistrationSummary();}
}
