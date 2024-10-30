Shell Command Line Interpreter with JUnit Testing
This project is a basic Command Line Interpreter (CLI) in Java, similar to a Unix/Linux shell, which supports executing commands such as pwd, ls, touch, rmdir, mkdir, cat, and more. It includes unit tests written using the JUnit framework to ensure each command functions correctly.

Table of Contents
Overview
Shell Commands
Getting Started
Running the Shell
JUnit Testing
Commands Tested
Contributing
License
Overview
The Shell class in this project provides a command-line interpreter that can execute basic file operations and other system commands. The JUnit tests validate the functionality of each command.

The primary goals of this project are:

To create a Java-based shell for basic command execution.
To write JUnit tests to verify that each command works as expected.
Shell Commands
The following commands are implemented in the Shell class:

pwd: Prints the current directory.
ls: Lists files in the current directory.
ls -a: Lists all files, including hidden ones.
touch [filename]: Creates a new file.
rmdir [directory]: Removes an empty directory.
mkdir [directory]: Creates a new directory.
cat [filename]: Displays the content of a file.
cd [directory]: Changes the current directory.
exit: Exits the shell.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
JUnit 5 for testing
Installing JUnit in IntelliJ IDEA
Go to File > Project Structure.
Under Libraries, click + to add a library.
Select From Maven and enter org.junit.jupiter:junit-jupiter:5.7.0 (or the latest version).
Click OK to add JUnit to your project.
Running the Shell
The main entry point for this project is in the ShellMain class, which contains the main method for executing shell commands interactively.

To run the shell, open ShellMain.java in your IDE and run the main method. You can type commands directly into the console.

Example commands:

shell
Copy code
> pwd
> ls
> mkdir testDir
> cd testDir
> touch testFile.txt
> cat testFile.txt
> exit
JUnit Testing
The project includes a set of JUnit test cases to verify that each command works as expected. These tests are in the ShellTest class.

Running Tests
To run the JUnit tests:

Right-click on ShellTest.java in your IDE.
Select Run 'ShellTest' to execute all test cases.
Commands Tested
Each of the following commands has a corresponding test method in ShellTest.java:

pwd: Checks if the current directory is correctly returned.
ls: Verifies that files are listed in the current directory.
touch: Ensures a file can be created.
rmdir: Checks if an empty directory can be removed.
mkdir: Verifies that a new directory can be created.
cat: Checks if a file's content is displayed correctly.
ls -a: Ensures that hidden files are listed as well.
cd: Tests changing directories within the shell.
Example Test
java
Copy code
@Test
void testPwd() {
    Shell shell = new Shell();
    String currentDir = System.getProperty("user.dir");
    assertEquals(currentDir, shell.executeCommand("pwd"), "The pwd command should return the current directory.");
}
This test checks that the pwd command returns the correct current directory.

Contributing
If you'd like to contribute to this project, please fork the repository and use a feature branch. Pull requests are warmly welcome.

License
This project is open-source and available under the MIT License.

This README.md now provides a guide for setting up, running, and testing the shell without mentioning the repository cloning step.
