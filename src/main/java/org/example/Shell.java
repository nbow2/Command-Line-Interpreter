package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Shell {

    private boolean isRunning;

    public Shell() {
        this.isRunning = true;
    }

    public String executeCommand(String command) {
        String[] parts = command.split(" ");
        String mainCommand = parts[0];
        try {
            switch (mainCommand) {
                case "pwd":
                    return pwd();
                case "ls":
                    return ls(parts);
                case "touch":
                    return touch(parts);
                case "rmdir":
                    return rmdir(parts);
                case "mkdir":
                    return mkdir(parts);
                case "cat":
                    return cat(parts);
                case "cd":
                    return cd(parts);
                case "exit":
                    this.isRunning = false;
                    return "Shell exited";
                default:
                    return "Unknown command: " + mainCommand;
            }
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    private String pwd() {
        return Paths.get("").toAbsolutePath().toString();
    }

    private String ls(String[] parts) {
        StringBuilder output = new StringBuilder();
        File dir = new File(System.getProperty("user.dir"));
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (parts.length > 1 && parts[1].equals("-a")) {
                    output.append(file.getName()).append("\n");
                } else if (!file.isHidden()) {
                    output.append(file.getName()).append("\n");
                }
            }
        }
        return output.toString().trim();
    }

    private String touch(String[] parts) throws IOException {
        if (parts.length > 1) {
            File file = new File(parts[1]);
            if (file.createNewFile()) {
                return "File created: " + parts[1];
            } else {
                return "File already exists.";
            }
        } else {
            return "Please specify a file name.";
        }
    }

    private String rmdir(String[] parts) {
        if (parts.length > 1) {
            File dir = new File(parts[1]);
            if (dir.isDirectory() && dir.delete()) {
                return "Directory removed: " + parts[1];
            } else {
                return "Failed to remove directory.";
            }
        } else {
            return "Please specify a directory to remove.";
        }
    }

    private String mkdir(String[] parts) {
        if (parts.length > 1) {
            File dir = new File(parts[1]);
            if (dir.mkdir()) {
                return "Directory created: " + parts[1];
            } else {
                return "Failed to create directory.";
            }
        } else {
            return "Please specify a directory name.";
        }
    }

    private String cat(String[] parts) {
        if (parts.length > 1) {
            try (BufferedReader br = new BufferedReader(new FileReader(parts[1]))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString().trim();
            } catch (IOException e) {
                return "Error reading file: " + e.getMessage();
            }
        } else {
            return "Please specify a file to display.";
        }
    }

    private String cd(String[] parts) {
        if (parts.length > 1) {
            File dir = new File(parts[1]);
            if (dir.isDirectory()) {
                System.setProperty("user.dir", dir.getAbsolutePath());
                return "Changed directory to " + dir.getAbsolutePath();
            } else {
                return "Directory not found: " + parts[1];
            }
        } else {
            return "Please specify a directory.";
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Shell! Type 'exit' to quit.");

        while (shell.isRunning) {
            System.out.print("$ ");
            String command = scanner.nextLine();
            String output = shell.executeCommand(command);
            System.out.println(output);
        }

        scanner.close();
        System.out.println("Shell closed.");
    }
}
