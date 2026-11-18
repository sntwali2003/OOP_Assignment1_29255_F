# AUCA_ID – School Management System (Java)

## Compile and run
Requires JDK 17 or newer (the menu uses switch-arrow syntax).

From the `AUCA_ID` directory:

```bash
javac -d out $(find src -name "*.java")
java -cp out com.auca.main.Main
```

## Package structure
All prescribed domain types and custom exceptions are in the packages required by the assignment. The model includes the two interfaces, two abstract classes and eleven concrete classes, with the six declared attributes, constructors, accessors, validation methods, summaries and `toString()` methods.

## Important implementation note
This is a compilable domain-model foundation and a runnable starter entry point. The assignment's full 19-option interactive CRUD system, four-step smart forms, prerequisite-resume workflows, duplicate registries, reports and transactional book-loan menu flows still need to be completed in `Main`/a service layer. They are not represented as finished features here. The supplied assignment explicitly requires those workflows to work during the physical demonstration; do not submit this starter as if those menu requirements were complete.
