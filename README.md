# Shell Command Line Interpreter with JUnit Testing

This project is a basic Command Line Interpreter (CLI) in Java, similar to a Unix/Linux shell, which supports executing commands such as `pwd`, `ls`, `touch`, `rmdir`, `mkdir`, `cat`, and more. It includes unit tests written using the JUnit framework to ensure each command functions correctly.

## Table of Contents

- [Overview](#overview)
- [Shell Commands](#shell-commands)
- [Getting Started](#getting-started)
- [Running the Shell](#running-the-shell)
- [JUnit Testing](#junit-testing)
- [Commands Tested](#commands-tested)
- [Contributing](#contributing)
- [License](#license)

## Overview

The `Shell` class in this project provides a command-line interpreter that can execute basic file operations and other system commands. The `JUnit` tests validate the functionality of each command.

The primary goals of this project are:

- To create a Java-based shell for basic command execution.
- To write JUnit tests to verify that each command works as expected.

## Shell Commands

The following commands are implemented in the `Shell` class:

- **pwd**: Prints the current directory.
- **ls**: Lists files in the current directory.
- **ls -a**: Lists all files, including hidden ones.
- **touch [filename]**: Creates a new file.
- **rmdir [directory]**: Removes an empty directory.
- **mkdir [directory]**: Creates a new directory.
- **cat [filename]**: Displays the content of a file.
- **cd [directory]**: Changes the current directory.
- **exit**: Exits the shell.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- JUnit 5 for testing

### Installing JUnit in IntelliJ IDEA

1. Go to **File > Project Structure**.
2. Under **Libraries**, click **+** to add a library.
3. Select **From Maven** and enter `org.junit.jupiter:junit-jupiter:5.7.0` (or the latest version).
4. Click **OK** to add JUnit to your project.

## Running the Shell

The main entry point for this project is in the `ShellMain` class, which contains the `main` method for executing shell commands interactively.

To run the shell, open `ShellMain.java` in your IDE and run the `main` method. You can type commands directly into the console.

Example commands:

```shell
> pwd
> ls
> mkdir testDir
> cd testDir
> touch testFile.txt
> cat testFile.txt
> exit
