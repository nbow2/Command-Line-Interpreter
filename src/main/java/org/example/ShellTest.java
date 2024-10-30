package org.example ;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ShellTest {

    @Test
    void testPwd() {
        Shell shell = new Shell();
        String currentDir = System.getProperty("user.dir");
        assertEquals(currentDir, shell.executeCommand("pwd"), "The pwd command should return the current directory.");
    }

    @Test
    void testLs() {
        Shell shell = new Shell();
        String output = shell.executeCommand("ls");
        assertNotNull(output, "The ls command should return the list of files in the current directory.");
        assertFalse(output.isEmpty(), "The ls command output should not be empty.");
    }

    @Test
    void testTouch() {
        Shell shell = new Shell();
        String fileName = "testFi1le.txt";
        String output = shell.executeCommand("touch " + fileName);
        assertEquals("File created: " + fileName, output, "The touch command should create a new file.");

        // Clean up the file after test
       // shell.executeCommand("rm " + fileName);
    }

    @Test
    void testRmdir() {
        Shell shell = new Shell();
        String dirName = "ahmed";
        shell.executeCommand("mkdir " + dirName);
        String output = shell.executeCommand("rmdir " + dirName);
        assertEquals("Directory removed: " + dirName, output, "The rmdir command should remove the directory.");
    }

    @Test
    void testMkdir() {
        Shell shell = new Shell();
        String dirName = "dele";
        String output = shell.executeCommand("mkdir " + dirName);
        assertEquals("Directory created: " + dirName, output, "The mkdir command should create a new directory.");

        // Clean up the directory after test
       // shell.executeCommand("rmdir " + dirName);
    }

    @Test
    void testCat() {
        Shell shell = new Shell();
        String fileName = "testFile.txt";
        shell.executeCommand("touch " + fileName);
        String output = shell.executeCommand("cat " + fileName);
        assertEquals("", output, "The cat command should return an empty string for an empty file.");

        // Clean up the file after test
        shell.executeCommand("rm " + fileName);
    }

    @Test
    void testLsA() {
        Shell shell = new Shell();
        String output = shell.executeCommand("ls -a");
        assertNotNull(output, "The ls -a command should list all files, including hidden ones.");
    }

    @Test
    void testCd() {
        Shell shell = new Shell();
        String initialDir = shell.executeCommand("pwd");
        shell.executeCommand("mkdir testDir");
        String output = shell.executeCommand("cd testDir");

        // Change back and clean up
        shell.executeCommand("cd " + initialDir);
        shell.executeCommand("rmdir testDir");
        assertEquals("Changed directory to " + initialDir + "/testDir", output, "The cd command should change the current directory.");

    }
}
