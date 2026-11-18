package com.auca.main;
import java.util.*;
import java.time.*;
import java.math.*;
import com.auca.interfaces.*;
import com.auca.abstracts.*;
import com.auca.student.Student;
import com.auca.teacher.Teacher;
import com.auca.administrator.Administrator;
import com.auca.department.Department;
import com.auca.course.Course;
import com.auca.classroom.Classroom;
import com.auca.enrollment.Enrollment;
import com.auca.assessment.Assessment;
import com.auca.feepayment.FeePayment;
import com.auca.librarybook.LibraryBook;
import com.auca.bookloan.BookLoan;
import com.auca.exceptions.*;

public class Main {
 private static final Scanner in=new Scanner(System.in);
 private static final List<Department> departments=new ArrayList<>();
 private static final List<Student> students=new ArrayList<>();
 private static final List<Teacher> teachers=new ArrayList<>();
 private static final List<Administrator> admins=new ArrayList<>();
 private static final List<Course> courses=new ArrayList<>();
 private static final List<Classroom> rooms=new ArrayList<>();
 private static final List<Enrollment> enrollments=new ArrayList<>();
 private static final List<Assessment> assessments=new ArrayList<>();
 private static final List<FeePayment> payments=new ArrayList<>();
 private static final List<LibraryBook> books=new ArrayList<>();
 private static final List<BookLoan> loans=new ArrayList<>();

 public static void main(String[] args) {
  System.out.println("==============================================");
  System.out.println("       AUCA_ID SCHOOL MANAGEMENT SYSTEM");
  System.out.println("==============================================");
  boolean running=true;
  while(running){
   menu();
   try{
    int choice=integer("Select an option: ");
    switch(choice){
     case 1: registerDepartment(); break;
     case 2: registerStudent(); break;
     case 3: registerTeacher(); break;
     case 4: registerAdministrator(); break;
     case 5: registerCourse(); break;
     case 6: registerClassroom(); break;
     case 7: enrollStudent(); break;
     case 8: recordAssessment(); break;
     case 9: recordPayment(); break;
     case 10: registerBook(); break;
     case 11: borrowBook(); break;
     case 12: returnBook(); break;
     case 13: viewAll(); break;
     case 14: searchById(); break;
     case 15: updateRecord(); break;
     case 16: academicSummary(); break;
     case 17: paymentHistory(); break;
     case 18: availableBooks(); break;
     case 19: demonstratePolymorphism(); break;
     case 0: running=false; System.out.println("Thank you for using AUCA_ID."); break;
     default: System.out.println("Choose a number from 0 to 19.");
    }
   }catch(Exception e){System.out.println("Operation could not be completed: "+e.getMessage());}
   if(running) pause();
  }
 }
 private static void menu(){
  System.out.println("\n============== AUCA_ID SCHOOL MANAGEMENT ==============");
  System.out.println(" 1 Register Department       11 Borrow Library Book");
  System.out.println(" 2 Register Student          12 Return Library Book");
  System.out.println(" 3 Register Teacher          13 View All Records");
  System.out.println(" 4 Register Administrator   14 Search Record by ID");
  System.out.println(" 5 Register Course          15 Update Existing Record");
  System.out.println(" 6 Register Classroom       16 Student Academic Summary");
  System.out.println(" 7 Enroll Student           17 Student Payment History");
  System.out.println(" 8 Record Assessment        18 View Available Books");
  System.out.println(" 9 Record Fee Payment       19 Demonstrate Polymorphism");
  System.out.println("10 Register Library Book     0 Exit");
 }
 private static String ask(String label){System.out.print(label);return in.nextLine().trim();}
 private static String required(String label){while(true){String s=ask(label);if(!s.isBlank())return s;System.out.println("This field is required.");}}
 private static int integer(String label){while(true){try{return Integer.parseInt(ask(label));}catch(NumberFormatException e){System.out.println("Enter a whole number.");}}}
 private static double decimal(String label){while(true){try{return Double.parseDouble(ask(label));}catch(NumberFormatException e){System.out.println("Enter a valid number.");}}}
 private static BigDecimal money(String label){while(true){try{BigDecimal v=new BigDecimal(ask(label));if(v.signum()>0)return v;System.out.println("Amount must be greater than zero.");}catch(NumberFormatException e){System.out.println("Enter a valid amount.");}}}
 private static LocalDate date(String label){while(true){try{return LocalDate.parse(ask(label));}catch(DateTimeException e){System.out.println("Use YYYY-MM-DD.");}}}
 private static boolean yesNo(String label){while(true){String s=ask(label+" (Y/N): ");if(s.equalsIgnoreCase("Y"))return true;if(s.equalsIgnoreCase("N"))return false;System.out.println("Enter Y or N.");}}
 private static void pause(){System.out.print("\nPress ENTER to return to menu...");in.nextLine();}
 private static void unique(String id,List<? extends Identifiable> list) throws DuplicateRecordException {for(Identifiable x:list)if(x.getId().equalsIgnoreCase(id))throw new DuplicateRecordException("ID already exists: "+id);}
 private static <T> T choose(String label,List<T> list) throws PrerequisiteMissingException {
  if(list.isEmpty())throw new PrerequisiteMissingException("No "+label+" records exist. Register one first.");
  while(true){System.out.println("\nSelect "+label+":");for(int i=0;i<list.size();i++)System.out.println((i+1)+". "+list.get(i));System.out.println("0. Cancel");
   int n=integer("Choice: ");if(n==0)return null;if(n>0&&n<=list.size())return list.get(n-1);System.out.println("Invalid selection.");}
 }
 private static void save(Registrable r) throws ValidationException {r.validate();r.printDetails();if(yesNo("Save this record?"))System.out.println("Saved successfully: "+r.getRegistrationSummary());else System.out.println("Cancelled; nothing was saved.");}
 private static Department selectDepartment() throws Exception {
  if(departments.isEmpty()){System.out.println("No Department exists. Register a department first.");if(yesNo("Register Department now?"))registerDepartment();else return null;}
  return choose("Department",departments);
 }
 private static Student selectStudent() throws Exception {
  if(students.isEmpty()){System.out.println("No Student exists. Register a student first.");if(yesNo("Register Student now?"))registerStudent();else return null;}
  return choose("Student",students);
 }
 private static Teacher selectTeacher() throws Exception {
  if(teachers.isEmpty()){System.out.println("No Teacher exists. Register a teacher first.");if(yesNo("Register Teacher now?"))registerTeacher();else return null;}
  return choose("Teacher",teachers);
 }
 private static Course selectCourse() throws Exception {
  if(courses.isEmpty()){System.out.println("No Course exists. Register a course first.");if(yesNo("Register Course now?"))registerCourse();else return null;}
  return choose("Course",courses);
 }
 private static void registerDepartment() throws Exception {
  System.out.println("\n--- REGISTER DEPARTMENT ---");
  String id=required("Department ID: ");unique(id,departments);
  String name=required("Department name: "),code=required("Department code: "),office=required("Office location: "),email=required("Contact email: ");
  Department d=new Department(id,name,code,office,email,null);d.validate();
  if(yesNo("Save department?")){departments.add(d);System.out.println("Department registered.");}
 }
 private static void registerStudent() throws Exception {
  System.out.println("\n--- REGISTER STUDENT ---");
  Department dep=selectDepartment();if(dep==null)return;
  String id=required("Person ID: ");unique(id,allPeople());
  String first=required("First name: "),last=required("Last name: "),email=required("Email: "),phone=required("Phone (10-15 digits): ");LocalDate dob=date("Date of birth (YYYY-MM-DD): ");
  String member=required("Member number: "),status=required("Academic status (ACTIVE/INACTIVE): "),inst=required("Institutional email: "),advisor=required("Advisor name: ");LocalDate join=date("Join date: ");
  String sn=required("Student number: "),program=required("Program name: ");LocalDate admission=date("Admission date: ");int year=integer("Study year (1-8): ");String guardian=required("Guardian phone: ");boolean scholarship=yesNo("Scholarship");
  Student s=new Student(id,first,last,email,phone,dob,member,dep,join,status,inst,advisor,sn,program,admission,year,guardian,scholarship);s.validate();
  if(yesNo("Save student?")){students.add(s);System.out.println("Student registered: "+s.getId());}
 }
 private static void registerTeacher() throws Exception {
  System.out.println("\n--- REGISTER TEACHER ---");Department dep=selectDepartment();if(dep==null)return;
  String id=required("Person ID: ");unique(id,allPeople());String f=required("First name: "),l=required("Last name: "),e=required("Email: "),p=required("Phone: ");LocalDate dob=date("Date of birth: ");
  String mn=required("Member number: "),st=required("Academic status (ACTIVE/INACTIVE): "),ie=required("Institutional email: "),ad=required("Advisor name: ");LocalDate jd=date("Join date: ");
  String en=required("Employee number: "),sp=required("Specialization: ");LocalDate hd=date("Hire date: ");BigDecimal sal=money("Salary: ");String off=required("Office number: "),type=required("Employment type (FULL_TIME/PART_TIME/CONTRACT): ");
  Teacher t=new Teacher(id,f,l,e,p,dob,mn,dep,jd,st,ie,ad,en,sp,hd,sal,off,type);t.validate();if(yesNo("Save teacher?")){teachers.add(t);if(dep.getHeadTeacher()==null)dep.setHeadTeacher(t);System.out.println("Teacher registered.");}
 }
 private static void registerAdministrator() throws Exception {
  System.out.println("\n--- REGISTER ADMINISTRATOR ---");String id=required("Person ID: ");unique(id,allPeople());String f=required("First name: "),l=required("Last name: "),e=required("Email: "),p=required("Phone: ");LocalDate dob=date("Date of birth: ");
  String sn=required("Staff number: "),jt=required("Job title: "),office=required("Assigned office: ");LocalDate ed=date("Employment date: ");int level=integer("Access level (1-5): ");boolean active=yesNo("Active");
  Administrator a=new Administrator(id,f,l,e,p,dob,sn,jt,office,ed,level,active);a.validate();if(yesNo("Save administrator?")){admins.add(a);System.out.println("Administrator registered.");}
 }
 private static void registerCourse() throws Exception {
  System.out.println("\n--- REGISTER COURSE ---");Department d=selectDepartment();if(d==null)return;Teacher t=selectTeacher();if(t==null)return;
  String id=required("Course ID: ");unique(id,courses);String code=required("Course code: ");String title=required("Course title: ");int credits=integer("Credit hours (1-6): ");
  Course c=new Course(id,code,title,credits,d,t);c.validate();if(yesNo("Save course?")){courses.add(c);System.out.println("Course registered.");}
 }
 private static void registerClassroom() throws Exception {
  System.out.println("\n--- REGISTER CLASSROOM ---");String id=required("Classroom ID: ");unique(id,rooms);String b=required("Building: "),r=required("Room number: ");int cap=integer("Capacity: "),floor=integer("Floor number (0+): ");boolean available=yesNo("Available");
  Classroom c=new Classroom(id,b,r,cap,floor,available);c.validate();if(yesNo("Save classroom?")){rooms.add(c);System.out.println("Classroom registered.");}
 }
 private static void enrollStudent() throws Exception {
  System.out.println("\n--- ENROLL STUDENT ---");Student s=selectStudent();if(s==null)return;Course c=selectCourse();if(c==null)return;String sem=required("Semester (e.g. 2026-S1): ");
  for(Enrollment x:enrollments)if(x.getStudent()==s&&x.getCourse()==c&&x.getSemester().equalsIgnoreCase(sem)&&x.getEnrollmentStatus().equalsIgnoreCase("ACTIVE"))throw new DuplicateRecordException("Student already has an active enrollment in this course and semester.");
  String id=required("Enrollment ID: ");unique(id,enrollments);LocalDate d=date("Enrollment date: ");String st=required("Status (ACTIVE/INACTIVE/COMPLETED): ");
  Enrollment x=new Enrollment(id,s,c,d,sem,st);x.validate();if(yesNo("Save enrollment?")){enrollments.add(x);System.out.println("Enrollment saved.");}
 }
 private static void recordAssessment() throws Exception {
  System.out.println("\n--- RECORD ASSESSMENT ---");Enrollment en=choose("Enrollment",enrollments);if(en==null)return;String id=required("Assessment ID: ");unique(id,assessments);String type=required("Assessment type (QUIZ/TEST/ASSIGNMENT/EXAM): ");double max=decimal("Maximum score: "),got=decimal("Obtained score: ");LocalDate d=date("Assessment date: ");
  Assessment a=new Assessment(id,en,type,max,got,d);a.validate();if(yesNo("Save assessment?")){assessments.add(a);System.out.println("Assessment saved.");}
 }
 private static void recordPayment() throws Exception {
  System.out.println("\n--- RECORD FEE PAYMENT ---");Student s=selectStudent();if(s==null)return;String id=required("Payment ID: ");unique(id,payments);BigDecimal amount=money("Amount: ");LocalDate d=date("Payment date: ");String method=required("Payment method (CASH/BANK/MOBILE_MONEY/CARD): ");String receipt=required("Receipt number: ");
  for(FeePayment p:payments)if(p.getReceiptNumber().equalsIgnoreCase(receipt))throw new DuplicateRecordException("Receipt number already exists.");
  FeePayment p=new FeePayment(id,s,amount,d,method,receipt);p.validate();if(yesNo("Save payment?")){payments.add(p);System.out.println("Payment saved.");}
 }
 private static void registerBook() throws Exception {
  System.out.println("\n--- REGISTER LIBRARY BOOK ---");String id=required("Book ID: ");unique(id,books);String isbn=required("ISBN: "),title=required("Title: "),author=required("Author: ");int total=integer("Total copies: ");int avail=integer("Available copies: ");
  LibraryBook b=new LibraryBook(id,isbn,title,author,total,avail);b.validate();if(yesNo("Save book?")){books.add(b);System.out.println("Book registered.");}
 }
 private static void borrowBook() throws Exception {
  System.out.println("\n--- BORROW LIBRARY BOOK ---");Student s=selectStudent();if(s==null)return;LibraryBook b=choose("available book",availableBookList());if(b==null)return;if(b.getAvailableCopies()<=0)throw new BookUnavailableException("No copies of this book are available.");
  String id=required("Loan ID: ");unique(id,loans);LocalDate borrowed=date("Borrowed date: "),due=date("Due date: ");BookLoan loan=new BookLoan(id,s,b,borrowed,due,null);loan.validate();
  if(yesNo("Confirm borrowing?")){b.setAvailableCopies(b.getAvailableCopies()-1);loans.add(loan);System.out.println("Book borrowed. Available copies: "+b.getAvailableCopies());}
 }
 private static void returnBook() throws Exception {
  System.out.println("\n--- RETURN LIBRARY BOOK ---");List<BookLoan> active=new ArrayList<>();for(BookLoan l:loans)if(l.getReturnedDate()==null)active.add(l);BookLoan l=choose("active loan",active);if(l==null)return;
  if(yesNo("Confirm return of "+l.getBook().getTitle()+"?")){l.setReturnedDate(LocalDate.now());l.getBook().setAvailableCopies(l.getBook().getAvailableCopies()+1);System.out.println("Book returned. Available copies: "+l.getBook().getAvailableCopies());}
 }
 private static List<Person> allPeople(){List<Person> p=new ArrayList<>();p.addAll(students);p.addAll(teachers);p.addAll(admins);return p;}
 private static List<LibraryBook> availableBookList(){List<LibraryBook> a=new ArrayList<>();for(LibraryBook b:books)if(b.getAvailableCopies()>0)a.add(b);return a;}
 private static void viewAll(){
  section("DEPARTMENTS",departments);section("STUDENTS",students);section("TEACHERS",teachers);section("ADMINISTRATORS",admins);section("COURSES",courses);section("CLASSROOMS",rooms);section("ENROLLMENTS",enrollments);section("ASSESSMENTS",assessments);section("FEE PAYMENTS",payments);section("LIBRARY BOOKS",books);section("BOOK LOANS",loans);
 }
 private static void section(String title,List<?> list){System.out.println("\n--- "+title+" ("+list.size()+") ---");if(list.isEmpty())System.out.println("No records.");else for(Object o:list)System.out.println(o);}
 private static List<Identifiable> allEntities(){List<Identifiable> a=new ArrayList<>();a.addAll(departments);a.addAll(students);a.addAll(teachers);a.addAll(admins);a.addAll(courses);a.addAll(rooms);a.addAll(enrollments);a.addAll(assessments);a.addAll(payments);a.addAll(books);a.addAll(loans);return a;}
 private static void searchById(){
  String id=required("Enter record ID: ");for(Identifiable x:allEntities())if(x.getId().equalsIgnoreCase(id)){System.out.println(x);return;}System.out.println("No record found with ID "+id);
 }
 private static void updateRecord(){
  String id=required("Enter ID of record to update: ");for(Identifiable x:allEntities())if(x.getId().equalsIgnoreCase(id)){
   System.out.println("Found: "+x);
   if(x instanceof Classroom){Classroom c=(Classroom)x;c.setAvailable(yesNo("Set classroom available?"));System.out.println("Classroom updated.");}
   else if(x instanceof LibraryBook){LibraryBook b=(LibraryBook)x;int n=integer("New total copies: ");int a=integer("New available copies: ");if(n>=0&&a>=0&&a<=n){b.setTotalCopies(n);b.setAvailableCopies(a);System.out.println("Book updated.");}else System.out.println("Invalid copy counts; no change.");}
   else if(x instanceof Enrollment){Enrollment e=(Enrollment)x;String s=required("New status (ACTIVE/INACTIVE/COMPLETED): ").toUpperCase();if(Arrays.asList("ACTIVE","INACTIVE","COMPLETED").contains(s)){e.setEnrollmentStatus(s);System.out.println("Enrollment updated.");}else System.out.println("Invalid status.");}
   else if(x instanceof Administrator){Administrator a=(Administrator)x;a.setActive(yesNo("Set administrator active?"));System.out.println("Administrator updated.");}
   else System.out.println("This record type has no quick-edit fields in this version.");
   return;
  }System.out.println("Record not found.");
 }
 private static void academicSummary() throws Exception {
  Student s=choose("Student",students);if(s==null)return;System.out.println("\nACADEMIC SUMMARY: "+s.getRegistrationSummary());int count=0;for(Enrollment e:enrollments)if(e.getStudent()==s){count++;System.out.println(e+" | "+e.getEnrollmentStatus());for(Assessment a:assessments)if(a.getEnrollment()==e)System.out.println("  "+a.getAssessmentType()+": "+a.getObtainedScore()+"/"+a.getMaximumScore());}if(count==0)System.out.println("No enrollments recorded.");
 }
 private static void paymentHistory() throws Exception {
  Student s=choose("Student",students);if(s==null)return;System.out.println("PAYMENT HISTORY: "+s.getDisplayName());BigDecimal total=BigDecimal.ZERO;for(FeePayment p:payments)if(p.getStudent()==s){System.out.println(p);total=total.add(p.getAmount());}System.out.println("Total paid: "+total);
 }
 private static void availableBooks(){section("AVAILABLE BOOKS",availableBookList());}
 private static void demonstratePolymorphism(){
  System.out.println("\n--- PERSON POLYMORPHISM ---");List<Person> people=allPeople();if(people.isEmpty())System.out.println("Register a Student, Teacher or Administrator first.");for(Person p:people)System.out.println(p.getRoleDescription()+" -> "+p.getRegistrationSummary());
  System.out.println("\n--- INTERFACE POLYMORPHISM ---");List<Identifiable> entities=allEntities();for(Identifiable e:entities)System.out.println(e.getId()+" | "+e.getDisplayName()+" | active="+e.isActive());
 }
}
