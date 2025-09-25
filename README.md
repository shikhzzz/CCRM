1. Project Overview & How to Run
This is a comprehensive guide to the Campus Course & Records Manager (CCRM), a console-based Java application. The CCRM allows an institution to manage students, courses, grades, and records. It is a Java SE project built and run locally, demonstrating key object-oriented programming principles and advanced Java concepts.
To run this application, you must have the Java Development Kit (JDK) installed on your machine. This project was developed using JDK 17.
How to Run:
1.	Compile: Open your terminal in the project's root directory and run: javac -d bin src/edu/ccrm/cli/Main.java
2.	Run: Execute the compiled code with: java -cp bin edu.ccrm.cli.Main

2. Evolution of Java (Short Timeline)
•	1995: Java 1.0 is released by Sun Microsystems, based on the principle of "write once, run anywhere."
•	1998: Java 2 is released, introducing the different editions: J2SE (Standard), J2EE (Enterprise), and J2ME (Micro).
•	2004: Java 5 introduces significant language features like generics, annotations, and enums.
•	2014: Java 8 is a major update, introducing lambda expressions, the Stream API, and the Date/Time API, which are all used in this project.
•	2017: Java 9 introduces the Java Platform Module System (JPMS) to make the platform more modular.
•	2018-Present: Java shifts to a six-month release cadence, with LTS (Long-Term Support) versions like JDK 11 and 17 providing stability.

3.	Java ME vs. Java SE vs. Java EE
Feature	Java ME (Micro Edition) 	Java SE (Standard Edition)	Java EE (Enterprise Edition)
Platform	Embedded devices, IoT, feature phones	Desktops, workstations, single-server systems	Large-scale, multi-tiered enterprise applications
Libraries	A highly constrained subset of SE libraries	A comprehensive set of core libraries (java.lang, java.util, java.io, java.nio)	Adds extensive APIs for networking, databases, web services (Servlets, JPA, EJB)
UseCase	Smart meters, older mobile games, embedded systems	Desktop applications, command-line tools	Web servers, e-commerce, banking systems, distributed applications
4. Java Architecture: JDK, JRE, JVM
•	JDK (Java Development Kit): The full development kit for creating Java applications. It includes the JRE and all the development tools like the compiler (javac), debugger, and archiver.
•	JRE (Java Runtime Environment): Provides the necessary environment to run a Java application. It contains the JVM and the core class libraries.
•	JVM (Java Virtual Machine): The virtual machine that runs your compiled Java bytecode (.class files). The JVM is what makes Java platform-independent; it translates the bytecode into the native machine code of the underlying operating system.
Interaction: A developer writes code (.java), compiles it with the JDK's javac tool into bytecode (.class). The end-user then runs the application using the JRE, which provides the JVM to execute the bytecode.

5. Windows Install & Eclipse Setup
1.	Install Java on Windows:
•	Download the JDK installer from Oracle's website.
•	Run the installer and follow the on-screen prompts.
•	Set up your JAVA_HOME and Path environment variables.
•	Verify the installation by opening a Command Prompt and typing java -version.
2.	Using Eclipse IDE:
•	Download and install the "Eclipse IDE for Java Developers" from the Eclipse website.
•	Launch Eclipse and create a new Java Project.
•	Create the required package structure (edu.ccrm.cli, edu.ccrm.domain, etc.) by right-clicking the src folder.
•	Run your main class by right-clicking Main.java and selecting Run As > Java Application.

6. Mapping Table: Syllabus Topic to File/Class/Method
Syllabus Topic	File/Class/Method
Encapsulation	Student.java, Course.java (using private fields with getters/setters)
Inheritance	Student.java and Instructor.java extends Person.java
Abstraction	Person.java as an abstract class with an abstract method
Polymorphism	displayDetails() method in Student and Instructor classes; calling s.displayDetails() in Main.java
Singleton Pattern	AppConfig.java (private constructor, getInstance() method)
Builder Pattern	Course.java (the Course.Builder static nested class)
Enums	Grade.java and Semester.java (with fields and constructors)
Custom Exceptions	MaxCreditLimitExceededException.java, DuplicateEnrollmentException.java
NIO.2 + Streams	BackupService.java, ImportExportService.java (using Path, Files, walk)
Recursion	BackupService.calculateSize() (recursively calculates folder size)
	


7. Enabling Assertions and Sample Commands
Assertions are used to verify internal state invariants and are disabled by default.
•	To enable assertions, you must pass the -ea (enable assertions) flag to the JVM when you run your program.
•	Sample Command: java -ea -cp bin edu.ccrm.cli.Main
If an assertion fails, the program will terminate with an AssertionError.

