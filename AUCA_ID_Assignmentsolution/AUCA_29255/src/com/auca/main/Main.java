package com.auca.main;

import java.util.*;
import com.auca.interfaces.Identifiable;
import com.auca.abstracts.Person;
import com.auca.student.Student;
import com.auca.teacher.Teacher;
import com.auca.administrator.Administrator;

/** Entry point and small polymorphism demonstration. Extend this menu with the registration workflows. */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in); // one shared Scanner
    private static final List<Person> PEOPLE = new ArrayList<>();
    private static final List<Identifiable> RECORDS = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\\n============== AUCA_ID SCHOOL MANAGEMENT ==============");
            System.out.println("1. View all people   2. Search person by ID   3. Demonstrate polymorphism   0. Exit");
            System.out.print("Select an option: ");
            String line = SCANNER.nextLine().trim();
            try {
                choice = Integer.parseInt(line);
                switch (choice) {
                    case 1 -> PEOPLE.forEach(p -> p.printDetails());
                    case 2 -> searchPerson();
                    case 3 -> demonstratePolymorphism();
                    case 0 -> System.out.println("Goodbye.");
                    default -> System.out.println("Choose 0, 1, 2 or 3.");
                }
            } catch (NumberFormatException ex) {
                choice = -1;
                System.out.println("Please enter a whole number.");
            }
        } while (choice != 0);
    }

    private static void searchPerson() {
        System.out.print("Enter person ID: ");
        String id = SCANNER.nextLine().trim();
        PEOPLE.stream().filter(p -> p.getId().equalsIgnoreCase(id)).findFirst()
                .ifPresentOrElse(Person::printDetails, () -> System.out.println("No person found with ID " + id));
    }

    private static void demonstratePolymorphism() {
        System.out.println("Person is abstract; create Student, Teacher and Administrator objects in their respective registration workflows.");
        for (Person person : PEOPLE) {
            System.out.println(person.getRoleDescription() + " -> " + person.getRegistrationSummary());
        }
        System.out.println("Identifiable records stored: " + RECORDS.size());
        for (Identifiable record : RECORDS) {
            System.out.println(record.getId() + " | " + record.getDisplayName() + " | active=" + record.isActive());
        }
    }
}
