/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykanban;

/**
 *
 * @author RC_Student_lab
 */

public class Task {
    private static int taskCounter = 0;

    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskId;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskId = createTaskID();
        this.taskStatus = taskStatus;
    }

    public String checkTaskDescription() {
        if (this.taskDescription.length() > 50) {
            return "Please enter a task description of less than 50 characters";
        }
        return "Task successfully captured";
    }

    public String createTaskID() {
        return String.format("%s:%d:%s", taskName.substring(0, 2).toUpperCase(), taskNumber, developerLastName.substring(developerLastName.length() - 3).toUpperCase());
    }

    public String printTaskDetails() {
        return String.format("Task Status: %s\nDeveloper Details: %s %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nDuration: %d hours",
                taskStatus, developerFirstName, developerLastName, taskNumber, taskName, taskDescription, taskId, taskDuration);
    }

    public static int returnTotalHours(Task[] tasks) {
        int total = 0;
        for (Task task : tasks) {
            total += task.taskDuration;
        }
        return total;
    }

    
    public String getTaskDescription() { return taskDescription; }
    public String getTaskId() { return taskId; }
}
